import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isTopicCollapsed = false;
  isResearchCollapsed = false;
  isFileCollapsed = false;
  isBookmarkCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  topicscollapse() {
    if (this.isTopicCollapsed === false) {
      this.isTopicCollapsed = true;
    } else { this.isTopicCollapsed = false; }
  }

  researchescollapse() {
    if (this.isResearchCollapsed === false) {
      this.isResearchCollapsed = true;
    } else { this.isResearchCollapsed = false; }
  }

  bookmarkscollapse() {
    if (this.isBookmarkCollapsed === false) {
      this.isBookmarkCollapsed = true;
    } else { this.isBookmarkCollapsed = false; }
  }

  filescollapse() {
    if (this.isFileCollapsed === false) {
      this.isFileCollapsed = true;
    } else { this.isFileCollapsed = false; }
  }
}
