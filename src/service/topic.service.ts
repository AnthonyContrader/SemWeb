import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { TopicDTO } from 'src/dto/topicdto';

@Injectable({
  providedIn: 'root'
})
export class TopicService extends AbstractService<TopicDTO> {

  constructor(http: HttpClient) { 
    super(http);
  }
}
