package com.tj.ch20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tj.ch20.service.BookService;


@Controller
public class MainController {
	
	@Autowired
	private BookService service;
	
	@RequestMapping(value="main")
	public String mainList(Model model) {
		model.addAttribute("main", service.mainList());
		return "main/main";
	}
}
