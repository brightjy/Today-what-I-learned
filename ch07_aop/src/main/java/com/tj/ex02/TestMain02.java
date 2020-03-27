package com.tj.ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain02 {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX02.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		Student02 student02 = ctx.getBean("student02", Student02.class);
		Worker02 worker02 = ctx.getBean("worker02",Worker02.class);
		student02.getStudentInfo();
		worker02.getWorkerInfo();
	}
}
