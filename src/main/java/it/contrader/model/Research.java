package it.contrader.model;

import java.sql.Date;

public class Research {
	
	private Date date;
	
	private Topic topic;
	
	public Research() {}
	
	public Research(Date date, Topic topic) {
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
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Research other = (Research) obj;
		if (topic != other.getTopic()) return false;
		else 
		{ 
			if (date != other.getDate()) return false;
		}
		if (topic == null) 
		{
			if (other.topic != null) return false;
		} 
		else if (!topic.equals(other.topic)) return false;
		return true;
	}
}
