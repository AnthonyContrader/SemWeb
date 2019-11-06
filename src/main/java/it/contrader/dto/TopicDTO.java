package it.contrader.dto;

public class TopicDTO {

	private int id;
	
	private String name;

	
	public TopicDTO() {
		
	}

	public TopicDTO (String name) {
		this.name = name;
	}

	public TopicDTO (int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  id + "\t"  + name +"\t\t";
	}
}