package com.tj.ch20.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch20.dto.Member;
@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public int idConfirm(String mId) {
		return sessionTemplate.selectOne("idConfirm", mId);
	}

	@Override
	public int joinMember(Member member) {
		return sessionTemplate.insert("joinMember", member);
	}

	@Override
	public Member getMember(String mId) {
		return sessionTemplate.selectOne("getMember", mId);
	}

	@Override
	public int modifyMember(Member member) {
		return sessionTemplate.update("modifyMember", member);
	}

}
