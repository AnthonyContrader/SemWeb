import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { BookmarkDTO } from 'src/dto/bookmarkdto';

@Injectable({
  providedIn: 'root'
})
export class BookmarkService extends AbstractService<BookmarkDTO> {

  constructor(http: HttpClient) { 
    super(http);
    this.type = "bookmark";
  }
}
}
