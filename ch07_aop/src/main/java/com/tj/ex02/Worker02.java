package com.tj.ex02;

public class Worker02 {
	private String name;
	private int age;
	private String job;
	
	public void getWorkerInfo() { // main에서 호출할 핵심 기능(=타깃메소드=비즈니스로직)
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("직업 : "+job);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
