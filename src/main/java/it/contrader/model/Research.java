package it.contrader.model;

public class Research {

	private int id;

	private String keyWord;

	public Research() {}

	public Research(String keyWord) {
		this.keyWord = keyWord;
	}

	public Research(int id, String keyWord) {
		this.id = id;
		this.keyWord = keyWord;
	}
	
	public int getId() { return this.id; }
	
	public void setId(int id) { this.id = id; }

	public String getKeyWord() { return this.keyWord; }

	public void setKeyWord(String keyWord) { this.keyWord = keyWord; }

	@Override
	public String toString() {
		return  id + "\t"  + keyWord +"\t\t";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Research other = (Research) obj;
		if (id != other.id)
			return false;
		if (keyWord == null) {
			if (other.keyWord != null)
				return false;
		} else if (!keyWord.equals(other.keyWord))
			return false;
		return true;
	}
}
