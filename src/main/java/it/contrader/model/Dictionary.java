package it.contrader.model;

public class Dictionary {

	private int id;

	private String name;

	public Dictionary() {}

	public Dictionary(String name) {
		this.name = name;
	}

	public Dictionary(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() { return this.id; }
	
	public void setId(int id) { this.id = id; }

	public String getName() { return this.name; }

	public void setName(String name) { this.name = name; }

	@Override
	public String toString() {
		return  id + "\t"  + name +"\t\t";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dictionary other = (Dictionary) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
