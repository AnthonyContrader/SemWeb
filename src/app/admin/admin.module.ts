import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { ResearchesComponent } from './researches/researches.component';
import { TopicsComponent } from './topics/topics.component';
import { FilesComponent } from './files/files.component';
import { BookmarksComponent } from './bookmarks/bookmarks.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, WorkInProgressComponent, ResearchesComponent, 
    TopicsComponent, FilesComponent, BookmarksComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
