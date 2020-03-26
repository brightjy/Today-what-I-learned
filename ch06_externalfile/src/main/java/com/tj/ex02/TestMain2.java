package com.tj.ex02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminInfo adminInfo = ctx.getBean("adminInfo", AdminInfo.class);
		System.out.println("adminId : "+adminInfo.getAdminId());
		System.out.println("adminPw : "+adminInfo.getAdminPw());
		System.out.println("sub_adminId : "+adminInfo.getSubAdminId());
		System.out.println("sub_adminPw : "+adminInfo.getSubAdminPw());
		ctx.close();
	}
}
