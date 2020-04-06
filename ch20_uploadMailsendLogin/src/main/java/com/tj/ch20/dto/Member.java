package com.tj.ch20.dto;

public class Member {
	private String mId;
	private String mPw;
	private String mName;
	private String mMail;
	private String mPost;
	private String mAddr;
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmMail() {
		return mMail;
	}
	public void setmMail(String mMail) {
		this.mMail = mMail;
	}
	public String getmPost() {
		return mPost;
	}
	public void setmPost(String mPost) {
		this.mPost = mPost;
	}
	public String getmAddr() {
		return mAddr;
	}
	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}
	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", mMail=" + mMail + ", mPost=" + mPost
				+ ", mAddr=" + mAddr + "]";
	}
	
	
}
