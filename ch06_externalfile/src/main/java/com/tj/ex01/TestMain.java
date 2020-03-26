package com.tj.ex01;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class TestMain {
	public static void main(String[] args) {
		// 컨테이너 생성(환경설정)
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("admin.id : "+env.getProperty("admin.id"));
		System.out.println("admin.pw : "+env.getProperty("admin.pw"));
		
		// AdminInfo형 빈객체 생성
		ctx.load("classpath:applicationCTX01.xml");
		ctx.refresh();
		
		AdminInfo adminInfo = ctx.getBean("adminInfo", AdminInfo.class);
		System.out.println("adminInfo의 adminId : "+adminInfo.getAdminId());
		System.out.println("adminInfo의 adminPw : "+adminInfo.getAdminPw());
	}
}
