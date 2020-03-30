package com.tj.ch10.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 5;
	}
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		return list;
	}
	@RequestMapping("/")
	public String input() {
		return "input";
	}
//	@RequestMapping("studentId/*")
//	public String studentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
//		// * : 0자 이상의 글자  (studentId/aaa)
//		// ** : 0개 이상의 디렉토리 경로 (studentId/id/aaa)
//		// ? : 1개 이상의 글자 (studentId/a)
//		String uri = request.getRequestURI(); // /ch01/studentId/aaa
//		String id = uri.substring(uri.lastIndexOf("/")+1);
//		id = URLDecoder.decode(id, "utf-8");
//		model.addAttribute("id", id);
//		model.addAttribute("pw", "비밀번호는 없음");
//		return "studentId";
//	}
	@RequestMapping("studentId/{id}")
	public String studentId(@PathVariable("id") String id, Model model){
		model.addAttribute("id", id);
		model.addAttribute("pw", "비밀번호는 없음");
		return "studentId";
	}
}
