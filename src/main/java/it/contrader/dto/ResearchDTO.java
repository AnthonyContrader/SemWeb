package it.contrader.dto;

public class ResearchDTO {

	private int id;
	
	private String keyWord;

	
	public ResearchDTO() {
		
	}

	public ResearchDTO (String keyWord) {
		this.keyWord = keyWord;
	}

	public ResearchDTO (int id, String keyWord) {
		this.id = id;
		this.keyWord = keyWord;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getKeyWord() {
		return this.keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public String toString() {
		return  id + "\t"  + keyWord +"\t\t";
	}
}
