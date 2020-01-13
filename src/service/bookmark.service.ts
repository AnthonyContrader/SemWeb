import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { BookmarkDTO } from 'src/dto/bookmarkdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookmarkService extends AbstractService<BookmarkDTO>{

  constructor(http : HttpClient) {
    super(http);
    this.type = "bookmark";
   }
}
