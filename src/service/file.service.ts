import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { FileDTO } from 'src/dto/filedto';

@Injectable({
  providedIn: 'root'
})
export class FileService extends AbstractService<FileDTO> {

  constructor(http: HttpClient) { 
    super(http);
    this.type = "file";
  }
}
