package com.tj.ex02java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//설정 파일이라는 선언

import com.tj.ex01xml.Student;
@Configuration 
public class ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("요가");
		hobbies.add("맛집탐방♥");
		Student student = new Student("홍길순", 30, hobbies);
		student.setHeight(170);
		student.setWeight(50);
		return student;
	}
	@Bean
	public Student student2() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("쇼핑");
		hobbies.add("낮잠");
		Student student = new Student("홍길동", 29, hobbies);
		student.setHeight(188);
		student.setWeight(80);
		return student;
	}
}
