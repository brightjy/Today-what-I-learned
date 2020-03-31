package com.tj.ch13.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch13.dto.Student;
import com.tj.ch13.dto.StudentValidator;

@Controller
public class MyController {
	@RequestMapping(value="inputForm", method=RequestMethod.GET)
	public String inputForm() {
		return "inputForm"; // view Page
	}
	@RequestMapping(value="input", method=RequestMethod.GET)
	public String student(@Valid Student student, BindingResult errors, Model model) {
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, errors); // 검증해
		if(errors.hasErrors()) {
			if(errors.getFieldError("name")!=null) {
				model.addAttribute("nameError", "name은 반드시 입력");
			}
			if(errors.getFieldError("age")!=null) {
				model.addAttribute("ageError", "age는 자연수로 입력");
			}
			return "inputForm";
		}
		return "inputResult"; // view Page
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator()); // 많은 곳에서 써야 하면 이렇게 한 번에
	}
}
