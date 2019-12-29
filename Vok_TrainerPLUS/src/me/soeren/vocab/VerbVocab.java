package me.soeren.vocab;

public class VerbVocab {
	private String LocalMeaning;
	private String ForeignMeaning;
	
	public VerbVocab(String ForeignMeaning, String LocalMeaning) {
		ForeignMeaning = this.ForeignMeaning;
		LocalMeaning = this.LocalMeaning;
	}
		
	public String getLocalMeaning() {
		return this.LocalMeaning;
	}
	public void setLocalMeaning(String LocalMeaning) {
		this.LocalMeaning = LocalMeaning;
	}
	
	
	public String getForeignMeaning() {
		return this.ForeignMeaning;
	}
}
