package it.contrader.model;

public class Topic {
	
	private String name;
	
	public Topic() {}
	
	public Topic(String name) {
		this.name = name;
	}
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	@Override
	public String toString() { return name; }
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Topic other = (Topic) obj;
		if (name != other.getName()) return false;
		if (name == null) 
		{
			if (other.name != null) return false;
		} 
		else if (!name.equals(other.name)) return false;
		return true;
	}
}
