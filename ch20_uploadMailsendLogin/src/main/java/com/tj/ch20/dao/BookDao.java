package com.tj.ch20.dao;

import java.util.List;

import com.tj.ch20.dto.Book;

public interface BookDao {
	public List<Book> mainList();
	public List<Book> bookList(Book book);
	public int cntBook();
	public Book getBook(int bNum);
	public int registerBook(Book book);
	public int modifyBook(Book book);
	public int deleteBook(int bNum);
}
