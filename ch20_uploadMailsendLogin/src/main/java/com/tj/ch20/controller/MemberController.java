package com.tj.ch20.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tj.ch20.dto.Member;
import com.tj.ch20.service.MemberService;

@Controller
@RequestMapping(value="member")
public class MemberController {
	
	@Autowired
	private MemberService service;

	@RequestMapping(params="method=joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	@RequestMapping(params="method=idConfirm")
	public String idConfirm(String mId, Model model) {
		if(service.idConfirm(mId)==1) {
			model.addAttribute("idConfirmMsg","이미 사용 중인 아이디 입니다.");
		}else {
			model.addAttribute("idConfirmMsg","사용 가능한 아이디 입니다.");
		}
		return "member/idConfirmMsg";
	}
	@RequestMapping(params="method=join")
	public String join(Member member, Model model, HttpSession httpSession) {
		int result = service.joinMember(member, httpSession);
		if(result==1) {
			model.addAttribute("result", "회원가입 성공" );
		}
		return "member/loginForm";
	}
	@RequestMapping(params="method=loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	@RequestMapping(params="method=login")
	public String login(String mId, String mPw, HttpSession httpSession, Model model) {
		String result = service.loginChk(mId, mPw, httpSession);
		if(result.equals("로그인 성공")) {
			return "redirect:main.do";	
		}else {
			model.addAttribute("mId", mId);
			model.addAttribute("mPw", mPw);
			model.addAttribute("result", result);
			return "forward:member.do?method=loginForm";
		}
	}
	@RequestMapping(params="method=modifyForm")
	public String modifyForm() {
			return "member/modifyForm";
	}
	@RequestMapping(params="method=modify")
	public String modify(Member member, HttpSession httpSession, Model model) {
		int result = service.modifyMember(member, httpSession);
		if(result==1) {
			model.addAttribute("modifyResult", "정보수정 성공");
			return "redirect:main.do";
		}else {
			model.addAttribute("modifyResult", "정보수정 실패");
			return "forward:member.do?method=modifyForm";
		}
	}
	@RequestMapping(params="method=logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();		
		return "redirect:main.do";
	}

	
}
