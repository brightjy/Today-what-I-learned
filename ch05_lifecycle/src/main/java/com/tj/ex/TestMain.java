package com.tj.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 컨테이너 생성(환경설정)
		ctx.load("classpath:applicationCTX.xml"); // 파싱
		ctx.refresh(); // 빈 생성
		Student student = ctx.getBean("student", Student.class);
		Student student2 = ctx.getBean("student", Student.class); // student 와 주소가 같음
		OtherStudent otherStudent = ctx.getBean("otherStudent", OtherStudent.class);
		System.out.println("student : "+student);
		System.out.println("otherStudent : "+otherStudent);
		
		ctx.close();// 빈 소멸, 컨테이너 소멸
	}
}
