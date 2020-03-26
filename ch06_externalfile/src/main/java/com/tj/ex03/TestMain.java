package com.tj.ex03;

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
		ctx.getEnvironment().setActiveProfiles(config); // dev환경인지, run 환경인지 profile 먼저 체크하고 설정
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ServerInfo serverInfo = ctx.getBean("serverInfo",ServerInfo.class);
		System.out.println("ip번호 : "+serverInfo.getIpNum());
		System.out.println("port번호 : "+serverInfo.getPortNum());
		ctx.close();
	}
}
