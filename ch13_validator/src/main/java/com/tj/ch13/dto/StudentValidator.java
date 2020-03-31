package com.tj.ch13.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz); // 검증할 객체를 명시
	}

	@Override // validator.validate(student, errors);
	public void validate(Object target, Errors errors) { // 검증하는 메소드
		String name = ((Student)target).getName();
		int age = ((Student)target).getAge();
//		if(name == null || name.trim().isEmpty()) {
//			System.out.println("name이 빈칸임");
//			errors.rejectValue("name", "empty");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty");
		
		if(age<=0) {
			System.out.println("age가 자연수가 아님");
			errors.rejectValue("age", "notNaturalNumber");
		}
	}
	
}
