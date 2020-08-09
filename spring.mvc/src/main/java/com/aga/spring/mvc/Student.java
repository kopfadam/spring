package com.aga.spring.mvc;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favLang;
	private String[] experiencedOS;

	public Student() {
		
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFavLang() {
		return favLang;
	}

	public void setFavLang(String favLang) {
		this.favLang = favLang;
	}
	public String[] getExperiencedOS() {
		return experiencedOS;
	}

	public void setExperiencedOS(String[] experiencedOS) {
		this.experiencedOS = experiencedOS;
	}

}
