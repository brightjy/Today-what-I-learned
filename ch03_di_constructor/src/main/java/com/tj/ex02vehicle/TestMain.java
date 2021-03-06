package com.tj.ex02vehicle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		IVehicle vehicle = ctx.getBean("vehicle", IVehicle.class);
		vehicle.ride("홍길동");
		ctx.close();
	}
}

