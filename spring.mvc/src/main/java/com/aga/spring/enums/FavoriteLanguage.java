package com.aga.spring.enums;

public enum FavoriteLanguage {
	
	JAVA("Java"),
	C_SHARP("C#"),
	PHP("Php"),
	RUBY("Ruby"),
	JAVASCRIPT("Javascript"),
	PYTHON("Python");
	
	
	private String langName;
	
	
	FavoriteLanguage(String langName) {
		this.langName = langName;
	}


	public String getLangName() {
		return langName;
	}


	public void setLangName(String langName) {
		this.langName = langName;
	}
	
	
}
