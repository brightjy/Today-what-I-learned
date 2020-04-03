package com.tj.ch19_mybatis02.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch19_mybatis02.dto.Dept;
@Repository // 찐Dao 메모리에 bean 만듦
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList"); // ("id")
	}

}
