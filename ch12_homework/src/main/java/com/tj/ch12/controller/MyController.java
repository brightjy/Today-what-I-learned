package com.tj.ch12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch12.dto.Student;

@Controller
public class MyController {
	@ModelAttribute("cnt")
	public String cnt() {
		return "현재 총 4명";
	}
	@RequestMapping(value="inputForm", method=RequestMethod.GET)
	public String inputForm() {
		return "inputForm";
	}
	@RequestMapping(value="input", method=RequestMethod.GET)
	public String input(Student student) {
		student.setTot(student.getKor()+student.getEng()+student.getMat());
		student.setAvg(student.getTot()/3.0);
		return "inputResult";
	}
}
