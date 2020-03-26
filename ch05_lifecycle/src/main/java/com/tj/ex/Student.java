package com.tj.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class Student implements InitializingBean, DisposableBean, EnvironmentAware{
	private String  name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("= #2. 막 Student 빈 객체 생성함. 초기화 작업 여기서 =");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("= #3. 이제 Student 빈 객체는 소멸됨. 마무리 작업 여기서 = ");
		
	}
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("= #1. Student 빈 생성 바로 직전에 환경 설정 할 때. 환경이 environment 변수에 붙는다. =");
		
	}
}
