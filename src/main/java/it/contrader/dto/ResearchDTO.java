package it.contrader.dto;

import java.sql.Date;

import it.contrader.model.Topic;

public class ResearchDTO {
	
	private Date date;
	
	private Topic topic;
	
	public ResearchDTO() {}
	
	public ResearchDTO(Date date, Topic topic) {
		this.date = date;
		this.topic = topic;
	}
	
	public Date getDate() { return date; }
	
	public void setDate(Date date) { this.date = date; }
	
	public Topic getTopic() { return topic; }
	
	public void setTopic(Topic topic) { this.topic = topic; }
	
	@Override
	public String toString() {
		return topic.toString() + "\t\t" + date.toString();
	}
}
