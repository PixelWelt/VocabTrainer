package me.soeren.vocab;

public class SubstantivVocab {
	private Genus genus;
	private String genitiv;
	private String foreignMeaning;
	private String localMeaning;
	
	public SubstantivVocab(Genus genus, String genitiv, String foreignMeaning, String localMeaning) {
		genus = this.genus;
		genitiv = this.genitiv;
		foreignMeaning = this.foreignMeaning;
		localMeaning = this.localMeaning;
		
	}
	public Genus getGenus() {
		return genus;
	}
	public String getGenitiv() {
		return genitiv;
	}
	public String getForeignMeaning() {
		return foreignMeaning;
	}
	public String getLocalMeaning() {
		return localMeaning;
	}
	
	
	public void setGenus(Genus genus) {
		this.genus = genus;
	}
	public void setGenitiv(String genitiv) {
		this.genitiv = genitiv;
	}
	public void setForeignMeaning(String foreignMeaning) {
		this.foreignMeaning = foreignMeaning;
	}	
	public void setLocalMeaning(String localMeaning) {
		this.localMeaning = localMeaning;
	}
	
	
}
