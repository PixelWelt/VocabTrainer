package me.soeren.vocab;

public enum Genus {
	MALE("Maskulin"),
	FEMALE("Feminin"),
	NEUTRAL("Neutrum");
	
	private Genus(String translation) {
		this.translation = translation;
	}
	private String translation;
	public String getTranslation() {
		return translation;
		
	}
}
