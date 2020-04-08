package com.tj.ch20.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.ch20.dto.Book;

public interface BookService {
	public List<Book> mainList();
	public List<Book> bookList(Book book);
	public int cntBook(Book book);
	public Book getBook(int bNum);
	public int registerBook(Book book, MultipartHttpServletRequest mRequest); // 나중에 파일 첨부 할 때 필요하니까 mRequest 도 담는다.
	public int modifyBook(Book book, MultipartHttpServletRequest mRequest);
	public int deleteBook(int bNum);

}
