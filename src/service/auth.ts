import { UserDTO } from 'src/dto/userdto';

export class Auth {

    auth() {
        const user = JSON.parse(localStorage.getItem('Autoken')) as UserDTO;
        if (user) {
            console.log('Bearer ' + user.authorities);
            return 'Bearer ' + user.authorities;
        } else {
            return '';
        }
    }
}