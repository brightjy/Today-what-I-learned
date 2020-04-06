package com.tj.ch20.service;

import javax.servlet.http.HttpSession;

import com.tj.ch20.dto.Member;

public interface MemberService {
	public int idConfirm(String mId);
	public int joinMember(Member member, HttpSession httpSession); // 세션에 정보 담을 때 필요한 세션객체도
	public Member getMember(String mId);
	public int modifyMember(Member member, HttpSession httpSession);
	public String loginChk(String mId, String mPw, HttpSession httpSession); // getMember 해서 비교할 예정
	
}
