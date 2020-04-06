package com.tj.ch20.dao;

import com.tj.ch20.dto.Member;

public interface MemberDao {
	public int idConfirm(String mId);
	public int joinMember(Member member);
	public Member getMember(String mId);
	public int modifyMember(Member member);
}
