package com.tj.ch20.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch20.dto.Book;
@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<Book> mainList() {
		return sessionTemplate.selectList("mainList");
	}

	@Override
	public List<Book> bookList(Book book) {
		return sessionTemplate.selectList("bookList", book);
	}

	@Override
	public int cntBook(Book book) {
		return sessionTemplate.selectOne("cntBook", book);
	}

	@Override
	public Book getBook(int bNum) {
		return sessionTemplate.selectOne("getBook", bNum);
	}

	@Override
	public int registerBook(Book book) {
		return sessionTemplate.insert("registerBook", book);
	}

	@Override
	public int modifyBook(Book book) {
		return sessionTemplate.update("modifyBook", book);
	}

	@Override
	public int deleteBook(int bNum) {
		return sessionTemplate.delete("deletebook", bNum);
	}


}
