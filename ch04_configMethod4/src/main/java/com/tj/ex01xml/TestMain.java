package com.tj.ex01xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		
		String location1 = "classpath:ex01/applicationCTX1.xml";
		String location2 = "classpath:ex01/applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location1, location2);
		
		Student student1 = ctx.getBean("student1", Student.class);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		Student student3 = studentInfo.getStudent();
		System.out.println("student1 : "+ student1);
		System.out.println("student3 : "+ student3);
		if(student1.equals(student3)) {
			System.out.println("student1과 student3은 주소가 같은 한 객체");
		}else {
			System.out.println("student1과 student3은 주소가 다른 두 객체");
		}
		student3.setName("홍돌이");
		System.out.println("student1 : "+student1);
		System.out.println("student3 : "+student3);
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getFatherName());
		System.out.println(family.getMotherName());
		System.out.println(family.getDaughterName());
		System.out.println(family.getSonName());
		ctx.close();
	}
}
