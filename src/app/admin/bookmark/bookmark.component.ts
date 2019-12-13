import { Component, OnInit } from '@angular/core';
import {BookmarkDTO} from 'src/dto/bookmarkdto';
import {BookmarkService} from 'src/service/bookmark.service';


@Component({
  selector: 'app-bookmark',
  templateUrl: './bookmark.component.html',
  styleUrls: ['./bookmark.component.css']
})
export class BookmarkComponent implements OnInit {

  bookmarks : BookmarkDTO[];
  bookmarktoinsert : BookmarkDTO = new BookmarkDTO();

  constructor(private service : BookmarkService ) { }

  ngOnInit() {

      this.getBookmarks();
  }
getBookmarks() {
    this.service.getAll().subscribe(bookmarks => this.bookmarks = bookmarks);
  }
  
  delete(bookmark: BookmarkDTO) {
    this.service.delete(bookmark.id).subscribe(() => this.getBookmarks());
  }

  update(bookmark : BookmarkDTO) {
    this.service.update(bookmark).subscribe(() => this.getBookmarks());
  }

  insert(bookmark : BookmarkDTO) {
    this.service.insert(bookmark).subscribe(() => this.getBookmarks());
  }

  clear(){
    this.bookmarktoinsert = new BookmarkDTO();
  }
}

