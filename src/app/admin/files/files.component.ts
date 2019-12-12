import { Component, OnInit } from '@angular/core';
import { FileService } from 'src/service/file.service';
import { FileDTO } from 'src/dto/filedto';

@Component({
  selector: 'app-files',
  templateUrl: './files.component.html',
  styleUrls: ['./files.component.css']
})
export class FilesComponent implements OnInit {

  files: FileDTO[];
  filetoinsert: FileDTO = new FileDTO();

  constructor(private service: FileService) { }

  ngOnInit() {
    this.getFiles();
  }

  getFiles() {
    this.service.getAll().subscribe(files => this.files = files);
  }
  
  delete(file: FileDTO) {
    this.service.delete(file.id).subscribe(() => this.getFiles());
  }

  update(file: FileDTO) {
    this.service.update(file).subscribe(() => this.getFiles());
  }

  insert(file: FileDTO) {
    this.service.insert(file).subscribe(() => this.getFiles());
  }

  clear(){
    this.filetoinsert = new FileDTO();
  }

}
