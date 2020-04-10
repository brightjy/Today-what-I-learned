package com.tj.pj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.pj.dto.Host;
import com.tj.pj.service.HostService;

@Controller
public class HostController {
	
	@Autowired
	private HostService hostService;
	
	@RequestMapping(value="hostLoginForm", method=RequestMethod.GET)
	public String hostLoginForm() {
		return "host/loginForm";
	}
	@RequestMapping(value="hostjoinForm", method=RequestMethod.GET)
	public String hostjoinForm() {
		return "host/joinForm";
	}
	@RequestMapping(value="hostJoin", method=RequestMethod.POST)
	public String hostJoin(Host host, HttpSession httpSession ) {
		hostService.hostJoin(host, httpSession);
		return "host/loginForm";
	}
}
