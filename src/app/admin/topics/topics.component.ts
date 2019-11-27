import { Component, OnInit } from '@angular/core';
import { TopicDTO } from 'src/dto/topicdto';
import { TopicService } from 'src/service/topic.service';

@Component({
  selector: 'app-topics',
  templateUrl: './topics.component.html',
  styleUrls: ['./topics.component.css']
})
export class TopicsComponent implements OnInit {

  topics: TopicDTO[];
  topictoinsert: TopicDTO = new TopicDTO();

  constructor(private service: TopicService) { }

  ngOnInit() {
    this.getTopics();
  }

  getTopics() {
    this.service.getAll().subscribe(topics => this.topics = topics);
  }
  
  delete(topic: TopicDTO) {
    this.service.delete(topic.id).subscribe(() => this.getTopics());
  }

  update(topic: TopicDTO) {
    this.service.update(topic).subscribe(() => this.getTopics());
  }

  insert(topic: TopicDTO) {
    this.service.insert(topic).subscribe(() => this.getTopics());
  }

  clear(){
    this.topictoinsert = new TopicDTO();
  }
}