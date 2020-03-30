package com.tj.ch10.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tj.ch10.dto.MemberDto;

@Controller
@RequestMapping("member")
public class MController {
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
	@RequestMapping("join01")
	public String join01(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("age",age);
		model.addAttribute("email",email);
		model.addAttribute("address",address);
		return "member/result01";
	}
	@RequestMapping("join02")
	public String join02(
			@RequestParam("name") String name,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("age") int age,
			@RequestParam("email") String email,
			@RequestParam("address") String address,
			Model model) {
			model.addAttribute("name",name);
			model.addAttribute("id",id);
			model.addAttribute("pw",pw);
			model.addAttribute("age",age);
			model.addAttribute("email",email);
			model.addAttribute("address",address);
		return "member/result01";		
	}
	@RequestMapping("join03") // 변수 이름=파라미터name 인 경우 사용 가능
	public String join03(String name, String id, String pw, int age, String email, String address, Model model) {
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("age",age);
		model.addAttribute("email",email);
		model.addAttribute("address",address);
		return "member/result01";
	}
	@RequestMapping("join04")
	public String join04(@ModelAttribute("member") MemberDto memberDto) {
		return "member/result04";
	}
	@RequestMapping("join05")
	public String join05(MemberDto memberDto, Model model) {
		model.addAttribute("member", memberDto);
		return "member/result04";
	}
	@RequestMapping("join06")
	public String join06(MemberDto memberDto) {
		// model.addAttribute("memberDto", memberDto);
		return "member/result06";
	}
}
