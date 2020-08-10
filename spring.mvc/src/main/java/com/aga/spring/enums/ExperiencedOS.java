package com.aga.spring.enums;

public enum ExperiencedOS {
	
	WINDOWS("MS Windows"),
	MACOS("Mac OS"),
	LINUX("Linux");
	
	private String osName;

	ExperiencedOS(String osName) {
		this.osName = osName;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}
	
	
	
	
}
