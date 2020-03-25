package com.tj.ex01student;

public class Student {
	private String name;
	private int age;
	private String grade;
	private String classNum;
	public Student(String name, int age, String grade, String classNum) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.classNum = classNum;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGrade() {
		return grade;
	}
	public String getClassNum() {
		return classNum;
	}
	
	
}
