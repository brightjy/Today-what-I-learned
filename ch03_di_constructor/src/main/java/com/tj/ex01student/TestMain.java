package com.tj.ex01student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		studentInfo.print();
		Student s1 = studentInfo.getStudent(); // 장천
		Student s2 = ctx.getBean("student1", Student.class); // 장천
		Student s3 = ctx.getBean("student2", Student.class); // 천샤오시
		if(s1.equals(s2)) {
			System.out.println("s1과 s2는 같은 객체");
		}else{
			System.out.println("s1과 s2는 주소가 다른 객체");		
//		if(s2.equals(s3)) {
//			System.out.println("s2과 s3는 같은 객체");
//		}else {
//			System.out.println("s2과 s3는 주소가 다른 객체");
//		}
		ctx.close();
		
		}
	}
}