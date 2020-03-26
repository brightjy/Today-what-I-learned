package com.tj.ex05autowired;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:ex05/applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		System.out.println(studentInfo.getStudent());
		ctx.close();
	}
}
