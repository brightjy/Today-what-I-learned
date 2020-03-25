package com.tj.ex03xml_java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tj.ex01xml.Student;

@Configuration
public class ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("요가");
		hobbies.add("맛집탐방");
		Student student = new Student("홍길동", 30, hobbies);
		student.setHeight(180);
		student.setWeight(80);
		return student;
	}
}
