package com.tj.ch14.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch14.dto.Board;
import com.tj.ch14.service.*; // 서비스가 들어있는 패키지

@Controller
public class BController {
	private BService service;
	private int writeChk = 0;
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		return "mvcboard/list";
	}
	@RequestMapping(value="list", method=RequestMethod.POST)
	public String list_post(String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		return "mvcboard/list";
	}
	@RequestMapping(value="write_view", method=RequestMethod.GET)
	public String write_view() {
		writeChk = 1;
		return "mvcboard/write_view";
	}
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Board board, HttpServletRequest request, Model model) {
		if(writeChk==1) {
			model.addAttribute("request", request); // 서비스단에서 bIp 추출할때 request 객체가 필요함(request.getRemoteAddr();)
			service = new BWriteService();
			service.execute(model);
			writeChk = 0;
		}
		return "forward:list.do"; // BWriteService에서 처리해서 model에 담은 것을 유지해야 하니까 redirect X
	}
	@RequestMapping(value="content_view", method=RequestMethod.GET)
	public String content_view(String bId, String pageNum, Model model) {
		model.addAttribute("bId", bId);
		model.addAttribute("pageNum", pageNum);
		service = new BContentService();
		service.execute(model);
		return "mvcboard/content_view";
	}
}
