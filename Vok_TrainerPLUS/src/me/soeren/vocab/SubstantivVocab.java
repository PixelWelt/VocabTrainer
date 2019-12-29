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
	public String genitiv() {
		return genitiv;
	}
	
}
