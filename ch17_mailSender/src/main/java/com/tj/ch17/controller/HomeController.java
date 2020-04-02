package com.tj.ch17.controller;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HomeController {
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "join";
	}
	
	@RequestMapping(value="textMail", method=RequestMethod.GET)
	public String textMail(String name, String mailaddr, Model model) {
		System.out.println(name+"님("+mailaddr+")께 text메일을 발송하는 로직");
		SimpleMailMessage message = new SimpleMailMessage();
		String content = name+"님 반갑습니다. 회원가입 감사해여.<h1>태그는 안됨</h1>";	
		message.setFrom("brightjyp@gmail.com");
		message.setTo(mailaddr);
		message.setSubject(name+"님 회원가입 감사합니다.(setText)");
		message.setText(content);
		mailSender.send(message);		
		model.addAttribute("sendResult", "TEXT 메일 발송 성공");
		return "sendResult";
	}
	
	@RequestMapping(value="htmlMail", method=RequestMethod.GET)
	public String htmlMail(final String name, final String mailaddr, Model model) {
		System.out.println(name+"님("+mailaddr+")께 html메일을 발송하는 로직");
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = 
					"  <h1>"+name+"님의 회원가입을 축하드립니다</h1>"+
							"  <div>" + 
							"    <div>" + 
							"      회원가입 축하 쿠폰을 드립니다\n\n" + 
							"      <hr color=\"red\"/>" + 
							"    </div>" + 
							"    <div>" + 
							"      <p style=\"color:blue;\" >파란색 글씨부분</p>" + 
							"      <p style=\"color:red;\">빨간색 글씨부분</p>" + 
							"    </div>" + 
							"  </div>" + 
							"    <div>" + 
							"      <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20170315064553027.png\" />\n" + 
							"    </div>" + 
							"    <div style=\"font-weight: blod; font-size: 1.2em;\">아무개 사이트 일동</div>\n" + 
							"    <div style=\"color:red;\">서울시 종로구 몰라17길 51 어떤빌딩 8층</div>";

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailaddr));
				mimeMessage.setFrom(new InternetAddress("brightjyp@gmail.com"));
				mimeMessage.setSubject(name+"님 회원가입 감사합니다.(html메일)");
				mimeMessage.setText(content,"utf-8", "html");
			}							
		};
		mailSender.send(message);
		model.addAttribute("sendResult", "html 메일 발송 성공");
		return "sendResult";
	}
}
