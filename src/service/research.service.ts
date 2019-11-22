import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { ResearchDTO } from 'src/dto/researchdto';

@Injectable({
  providedIn: 'root'
})
export class ResearchService extends AbstractService<ResearchDTO> {

  constructor(http: HttpClient) { 
    super(http);
  }
}
