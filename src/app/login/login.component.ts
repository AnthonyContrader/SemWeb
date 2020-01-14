import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;
  user: UserDTO;
  users: UserDTO[];

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((token: any) => {
      localStorage.setItem("AUTOKEN", JSON.stringify({ "authorities": token.id_token }));
      localStorage.setItem("currentUser", JSON.stringify({ "authorities": token.id_token }));
      this.service.userLogged(this.loginDTO.username).subscribe((user: UserDTO) => {

        if (user != null) {
          localStorage.setItem('AUTOKEN', JSON.stringify(user));
          console.log(user.authorities);
          if (user.authorities == "ROLE_ADMIN") {
            this.router.navigate(['/admin-dashboard']);
          }
        } else {
          alert("Wrong username or password");
        }
      });
    });
  }

  register(f: NgForm): void {
    this.user = new UserDTO;
    this.user.username = f.value.username;
    this.user.password = f.value.password;
    this.user.authorities = "ROLE_USER";//Usertype.ROLE_ADMIN;
    this.service.insert(this.user).subscribe();
  }
}
