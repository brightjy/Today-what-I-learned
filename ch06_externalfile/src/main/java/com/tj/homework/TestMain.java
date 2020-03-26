package com.tj.homework;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;


public class TestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("dev? run?");
		config = scanner.next();
		if(!config.equals("dev")) {
			config="run";
		}
		scanner.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("homework/dev.xml", "homework/run.xml");
		ctx.refresh();
		EnvInfo envInfo = ctx.getBean("envInfo", EnvInfo.class);
		System.out.println("ip번호 : "+envInfo.getIpNum());
		System.out.println("port번호 : "+envInfo.getPortNum());
		System.out.println("userId : "+envInfo.getUserId());
		System.out.println("userPw : "+envInfo.getUserPw());
		ctx.close();
	}
}
