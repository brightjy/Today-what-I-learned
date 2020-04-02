package com.tj.ch18.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
//import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch18.dto.Dept;

@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private SqlSession sessionTemplate; // private SqlSessionTemplate sessionTemplate; 이렇게 해도 됨.
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
	}

}
