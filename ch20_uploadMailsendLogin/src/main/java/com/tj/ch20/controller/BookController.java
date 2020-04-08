package com.tj.ch20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.ch20.dto.Book;
import com.tj.ch20.service.BookService;
import com.tj.ch20.util.Paging;

@Controller
@RequestMapping(value="book")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@RequestMapping(params="method=detail")
	public String detail(int bNum, Model model) {
		model.addAttribute("book", service.getBook(bNum));
		return "book/detail";
	}
	
	@RequestMapping(params="method=list")
	public String list(String pageNum, Book book, Model model) {
		Paging paging = new Paging(service.cntBook(book), pageNum, 3, 5);

		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());

		model.addAttribute("bookList", service.bookList(book));
		model.addAttribute("paging", paging);
		return "book/list";
	}
	
	@RequestMapping(params="method=registerForm")
	public String registerForm() {
		return "book/registerForm";
	}
	
	@RequestMapping(params="method=register", method=RequestMethod.POST)
	public String register(Book book, Model model, MultipartHttpServletRequest mRequest) {
		int result = service.registerBook(book, mRequest);
		if(result==1) {
			model.addAttribute("result", "책 등록 성공");
		}
		return "redirect:book.do?method=list";
	}
	
	@RequestMapping(params="method=modifyForm")
	public String modifyForm(int bNum, Model model) {
		model.addAttribute("book", service.getBook(bNum));
		return "book/modifyForm";
	}
	
	@RequestMapping(params="method=modify", method=RequestMethod.POST)
	public String modify(Book book, Model model, MultipartHttpServletRequest mRequest) {
		int result = service.modifyBook(book, mRequest);
		if(result==1) {
			model.addAttribute("result", "책 수정 성공");
		}
		return "redirect:book.do?method=list";
	}
	
	@RequestMapping(params="method=delete")
	public String delete(int bNum) {
		service.deleteBook(bNum);
		return "forward:book.do?method=list";
	}
	
}
