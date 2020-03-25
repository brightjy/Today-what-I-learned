package com.tj.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		/*
		 * Calculation calculation = new Calculation(); 
		 * calculation.setNum1(10);
		 * calculation.setNum2(5);
		 */
		
		// 스프링 컨테이너를 생성하여 xml 설정 파일을 파싱함.
		String resourceLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		// 외부의 Calculation 객체를 주입받아 옴.
		Calculation calculation = ctx.getBean("calculation", Calculation.class);
		calculation.add();
		calculation.sub();
		calculation.mul();
		calculation.div();
		ctx.close(); // 스프링 컨테이너 안의 빈 객체 + 스프링 컨테이너 제거
	}
}
