package model;

public enum Gender {
	
	FEMALE("FEMENINO"), 
	MALE("MASCULINO");
	
	private String genderName;
	
	private Gender(String name) {
		this.genderName = name;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String name) {
		this.genderName = name;
	}
}
