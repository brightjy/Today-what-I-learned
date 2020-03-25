package com.tj.ex01xml;

public class Family {
	private String fatherName;
	private String motherName;
	private String daughterName;
	private String sonName;
	public Family(String fatherName, String motherName) {
		super();
		this.fatherName = fatherName;
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getDaughterName() {
		return daughterName;
	}
	public void setDaughterName(String daughterName) {
		this.daughterName = daughterName;
	}
	public String getSonName() {
		return sonName;
	}
	public void setSonName(String sonName) {
		this.sonName = sonName;
	}
	
	
}
