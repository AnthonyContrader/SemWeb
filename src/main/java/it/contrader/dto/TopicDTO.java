package it.contrader.dto;

public class TopicDTO {
	
	private String name;
	
	public TopicDTO() {}
	
	public TopicDTO(String name) {
		this.name = name;
	}
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	@Override
	public String toString() { return name; }
}
