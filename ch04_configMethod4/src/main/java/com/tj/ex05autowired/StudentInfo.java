package com.tj.ex05autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentInfo {
	@Autowired // setter 위에 써도 되고, setter를 굳이 쓰지 않아도 된다. (그냥 변수 위에 써도 됨) 
	private Student student;
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	public Student getStudent() {
		return student;
	}
	
}
