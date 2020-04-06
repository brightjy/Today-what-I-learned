package com.tj.ch20.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.tj.ch20.dao.MemberDao;
import com.tj.ch20.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public int idConfirm(String mId) {
		return memberDao.idConfirm(mId);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		int result = memberDao.joinMember(member);
		if(result==1) {
			httpSession.setAttribute("mId", member.getmId());		
			MimeMessagePreparator message = new MimeMessagePreparator() {
				String content = 
						"<h1>"+member.getmName()+"님 반갑습니다. 회원가입 감사해여.</h1>";				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getmMail()));
					mimeMessage.setFrom(new InternetAddress("brightjyp@gmail.com"));
					mimeMessage.setSubject(member.getmName()+"님 회원가입 감사합니다.");
					mimeMessage.setText(content,"utf-8", "html");
				}
			};
			mailSender.send(message);
		}		
		return result;
	}

	@Override
	public Member getMember(String mId) {
		return memberDao.getMember(mId);
	}

	@Override
	public int modifyMember(Member member, HttpSession httpSession) {
		httpSession.setAttribute("member", member);
		return memberDao.modifyMember(member);
	}

	@Override
	public String loginChk(String mId, String mPw, HttpSession httpSession) {
		String result="";
		Member member = memberDao.getMember(mId);
		if(member==null) {
			result="일치하는 아이디가 없습니다.";
		}else if(!member.getmPw().equals(mPw)) {
			result="비밀번호가 일치하지 않습니다.";
		}else {
			result="로그인 성공";
			httpSession.setAttribute("member", member);
			httpSession.setAttribute("mId", mId);
		}		
		return result;
	}
}
