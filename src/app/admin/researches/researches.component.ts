import { Component, OnInit } from '@angular/core';
import { ResearchDTO } from 'src/dto/researchdto';
import { ResearchService } from 'src/service/research.service';
import { UserDTO } from 'src/dto/userdto';
import { TopicService } from 'src/service/topic.service';
import { TopicDTO } from 'src/dto/topicdto';

@Component({
  selector: 'app-researches',
  templateUrl: './researches.component.html',
  styleUrls: ['./researches.component.css']
})
export class ResearchesComponent implements OnInit {

  user: UserDTO;
  researches: ResearchDTO[] = new Array();
  researchtoinsert: ResearchDTO = new ResearchDTO();

  constructor(private service: ResearchService) { }

  ngOnInit() {
    this.researchtoinsert.topic = new TopicDTO();
    this.getResearches();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  getResearches() {
    this.service.getAll().subscribe(researches => this.researches = researches);
  }

  delete(research: ResearchDTO) {
    this.service.delete(research.id).subscribe(() => this.getResearches());
  }

  update(research: ResearchDTO) {
    this.service.update(research).subscribe(() => this.getResearches());
  }

  insert(research: ResearchDTO) {
    research.researcher = this.user;
    research.date = new Date();
    this.service.insert(research).subscribe(() => this.getResearches());
  }

  clear(){
    this.researchtoinsert = new ResearchDTO();
    this.researchtoinsert.topic = new TopicDTO();
  }
}
