package com.tj.ch11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String main() {
		return "main";
	}
//	@RequestMapping(value="student")
//	public String student(HttpServletRequest request, String id, Model model) {
//		String method = request.getMethod();
////		String id = request.getParameter("id");
//		model.addAttribute("method", method);
//		model.addAttribute("id", id);
//		return "studentId";
//	}
	@RequestMapping(value="student", method=RequestMethod.GET)
	public String student(String id, Model model) {
		System.out.println("get방식 student 메소드");
		model.addAttribute("id", id);
		model.addAttribute("method", "GET");
		return "studentId";
	}
	@RequestMapping(value="student", method=RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView modelAndView) {
		System.out.println("post방식 student 메소드");
		modelAndView.addObject("id", id);
		modelAndView.addObject("method", "POST");
		modelAndView.setViewName("studentId");
		return modelAndView;
	}
	@RequestMapping(value="studentConfirm", method=RequestMethod.GET)
	public String studentConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			return "forward:studentOk.do"; // <-> return "redirect:studentOk.do"; 새로운 요청(새로운 request 요청)
		}
		return "redirect:studentNotOk.do?id="+id;
	}
	@RequestMapping(value="studentOk", method=RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	@RequestMapping(value="studentNotOk", method=RequestMethod.GET)
	public String studentNotOk(String id, Model model) {
		model.addAttribute("id", id);
		return "studentNotOk";
	}
	@RequestMapping(value="fullPath", method=RequestMethod.GET)
	public String fullPath() {
		return "redirect:http://localhost:8181/ch11/student/fullPath.jsp";
	}
	@RequestMapping(value="naver", method=RequestMethod.GET)
	public String naver() {
		return "redirect:http://www.naver.com"; // 특정 URL (진짜 있는 주소로 보내고 싶을때도)로 보내고 싶을 때 redirect
	}
}
