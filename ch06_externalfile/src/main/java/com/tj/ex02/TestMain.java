package com.tj.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX02.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		AdminInfo info = ctx.getBean("adminInfo", AdminInfo.class);
		System.out.println("adminId : "+info.getAdminId());
		System.out.println("adminPw : "+info.getAdminPw());
		System.out.println("sub_adminId : "+info.getSubAdminId());
		System.out.println("sug_adminPw : "+info.getSubAdminPw());
	}
}
