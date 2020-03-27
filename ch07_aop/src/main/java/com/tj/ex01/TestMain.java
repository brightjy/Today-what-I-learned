package com.tj.ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX01.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		Student student = ctx.getBean("student", Student.class);
		Worker worker = ctx.getBean("worker",Worker.class);
		student.getStudentInfo();
		worker.getWorkerInfo();
	}
}
