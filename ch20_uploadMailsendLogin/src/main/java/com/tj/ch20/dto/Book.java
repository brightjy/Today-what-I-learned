package com.tj.ch20.dto;

import java.sql.Date;

public class Book {
	private int bNum;
	private String bTitle;
	private String bWriter;
	private Date bRdate;
	private String bImg1;
	private String bImg2;
	private String bInfo;
	private int startRow;
	private int endRow;
	private String searchText;

	
	
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public Date getbRdate() {
		return bRdate;
	}
	public void setbRdate(Date bRdate) {
		this.bRdate = bRdate;
	}
	public String getbImg1() {
		return bImg1;
	}
	public void setbImg1(String bImg1) {
		this.bImg1 = bImg1;
	}
	public String getbImg2() {
		return bImg2;
	}
	public void setbImg2(String bImg2) {
		this.bImg2 = bImg2;
	}
	public String getbInfo() {
		return bInfo;
	}
	public void setbInfo(String bInfo) {
		this.bInfo = bInfo;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	@Override
	public String toString() {
		return "Book [bNum=" + bNum + ", bTitle=" + bTitle + ", bWriter=" + bWriter + ", bRdate=" + bRdate + ", bImg1="
				+ bImg1 + ", bImg2=" + bImg2 + ", bInfo=" + bInfo + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", searchText=" + searchText + "]";
	}
	
	
	
}
