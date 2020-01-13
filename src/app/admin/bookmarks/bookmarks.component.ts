import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { BookmarkDTO } from 'src/dto/bookmarkdto';
import { TopicDTO } from 'src/dto/topicdto';
import { BookmarkService } from 'src/service/bookmark.service';
import { TopicService } from 'src/service/topic.service';

@Component({
  selector: 'app-bookmarks',
  templateUrl: './bookmarks.component.html',
  styleUrls: ['./bookmarks.component.css']
})
export class BookmarksComponent implements OnInit {

  user: UserDTO;
  bookmarks : BookmarkDTO[] = new Array();
  topics : TopicDTO[];
  bookmarktoinsert : BookmarkDTO = new BookmarkDTO();

  constructor(private service : BookmarkService, private tservice : TopicService) { }

  ngOnInit() {
    this.bookmarktoinsert.topicDTO = new TopicDTO();
    this.getBookmarks();
    this.getTopics();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }
  
  getBookmarks() {
    this.service.getAll().subscribe(bookmarks => this.bookmarks = bookmarks);
  }

  getTopics() {
    this.tservice.getAll().subscribe(topics => this.topics = topics);
  }

  delete(bookmark: BookmarkDTO) {
    this.service.delete(bookmark.id).subscribe(() => this.getBookmarks());
  }

  update(bookmark : BookmarkDTO) {
    this.service.update(bookmark).subscribe(() => this.getBookmarks());
  }

  insert(bookmark : BookmarkDTO) {
    bookmark.userDTO = this.user;
    this.service.insert(bookmark).subscribe(() => this.getBookmarks());
  }

  clear(){
    this.bookmarktoinsert = new BookmarkDTO();
  }
}
