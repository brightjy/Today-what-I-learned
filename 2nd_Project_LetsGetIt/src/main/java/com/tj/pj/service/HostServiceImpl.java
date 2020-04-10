package com.tj.pj.service;

import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.tj.pj.dao.HostDao;
import com.tj.pj.dto.Host;
@Service
public class HostServiceImpl implements HostService {

	@Autowired
	private HostDao hostDao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public int idConfirm(String hId) {
		return hostDao.idConfirm(hId);
	}

	@Override
	public int hostJoin(final Host host, HttpSession httpSession) {
		int result = hostDao.hostJoin(host);
		
		if(result==1) { // 회원가입이 제대로 진행되면,
			httpSession.setAttribute("hId", host.gethId()); // 세션에 호스트 id 정보 저장
			MimeMessagePreparator message = new MimeMessagePreparator() {
				String content =
						"	<br>"+
						"	<img src='https://postfiles.pstatic.net/MjAyMDA0MTBfNTUg/MDAxNTg2NDg5NzIxOTMy.E8J6aCKSBzbkM1X8bmQrJPRynAwMM5GHQ9yUmwFwVP0g.FyyM2XVWCK0v-EYrDbfll33AqSRop8FK9PGlI3FUnmsg.JPEG.barkji0/hostMail1.jpg?type=w966'>"+
						"	<br>"+
						"	<img src='https://postfiles.pstatic.net/MjAyMDA0MTBfMjg3/MDAxNTg2NDg5NzIxOTM2.HUFSt9RBIi1sMy7LQ6BQE0RJalTcQEubUYoDUrigXnEg.5s4o7bnFBNAMhAOsKxTe2KglsQ31w7Zcnmd3UOJXqeMg.JPEG.barkji0/hostMail2.jpg?type=w966'>";
				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(host.gethEmail()));
					mimeMessage.setFrom(new InternetAddress("brightjyp@gmail.com"));
					mimeMessage.setSubject(host.gethName()+"님 반갑습니다. &#128587; &#127808;");
					mimeMessage.setText(content,"utf-8","html");
				}
			};
			mailSender.send(message);
		}
		return result;
	}

	@Override
	public Host getHost(String hId) {
		return hostDao.getHost(hId);
	}

	@Override
	public int hostModify(Host host, HttpSession httpSession) {
		httpSession.setAttribute("host", host);
		return hostDao.hostModify(host);
	}

	@Override
	public List<Host> hostList(Host host) {
		return hostDao.hostList(host);
	}

	@Override
	public List<Host> hostBestList(Host host) {
		return hostDao.hostBestList(host);
	}

	@Override
	public int memberLikeHost(Host host) {
		return hostDao.memberLikeHost(host);
	}

	@Override
	public String hostLoginChk(String hId, String hPw, HttpSession httpSession) {
		String result="";
		Host host = hostDao.getHost(hId);
		if(host==null) {
			result="일치하는 아이디가 없습니다.&#128542;";
		}else if(host.gethPw().equals(hPw)) {
			result="비밀번호가 일치하지 않습니다.&#128542;";
		}else {
			result="로그인 성공,"+host.gethName()+"님 반갑습니다.&#128536;";
			httpSession.setAttribute("host", host);
			httpSession.setAttribute("hId", hId);
		}
		return result;
	}

}
