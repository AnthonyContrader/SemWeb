import { Component, OnInit } from '@angular/core';
import { FileService } from 'src/service/file.service';
import { FileDTO } from 'src/dto/filedto';
import { UserDTO } from 'src/dto/userdto';
import { TopicDTO } from 'src/dto/topicdto';
import { TopicService } from 'src/service/topic.service';

@Component({
  selector: 'app-files',
  templateUrl: './files.component.html',
  styleUrls: ['./files.component.css']
})
export class FilesComponent implements OnInit {

  user : UserDTO;
  topics : TopicDTO[];
  files: FileDTO[];
  filetoinsert: FileDTO = new FileDTO();

  constructor(private service: FileService, private tservice : TopicService) { }

  ngOnInit() {
    this.filetoinsert.topicDTO = new TopicDTO();
    this.getFiles();
    this.getTopics();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  getFiles() {
    this.service.getAll().subscribe(files => this.files = files);
  }

  getTopics() {
    this.tservice.getAll().subscribe(topics => this.topics = topics);
  }
  
  delete(file: FileDTO) {
    this.service.delete(file.id).subscribe(() => this.getFiles());
  }

  update(file: FileDTO) {
    this.service.update(file).subscribe(() => this.getFiles());
  }

  insert(file: FileDTO) {
    file.userDTO = this.user;
    this.service.insert(file).subscribe(() => this.getFiles());
  }

  clear(){
    this.filetoinsert = new FileDTO();
  }

}
