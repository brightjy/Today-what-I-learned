package com.tj.ex01;

import org.aspectj.lang.ProceedingJoinPoint;

public class ProxyClass {
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable { // joinPoint: 핵심기능
		// aroundAdvice : 핵심기능 전 후로 공통기능을 수행
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		String signatureName = joinPoint.getSignature().toShortString(); // 핵심기능메소드명
		System.out.println(signatureName + "가 시작되었습니다.");
		long startTime = System.currentTimeMillis(); // 시작시점
		try {
			Object obj = joinPoint.proceed(); // 핵심 기능 실행
			return obj;
		} finally {
			long endTime = System.currentTimeMillis(); // 핵심 가능 수행 후 시점 
			System.out.println(signatureName + "가 종료되었습니다. 결과 시간 : "+(endTime-startTime));
		}
	}
	public void beforeAdvice() {
		System.out.println("[beforeAdvice] : 이 공통 기능 수행하고, 핵심 기능 수행하고 끝");
	}
	public void afterAdvice() {
		System.out.println("[afterAdvice] : 핵심기능 수행 후 이 공통기능 수행");
	}
	public void afterReturningAdvice() {
		System.out.println("[afterReturningAdvice] : 정상적으로 핵심기능을 수행한 후 공통기능 수행");
	}
	public void afterThrowingAdvice() {
		System.out.println("예외가 발생된 핵심기능을 수행한 후 이 공통 기능을 수행");
	}
}
