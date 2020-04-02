package com.tj.ch18.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch18.dto.Emp;
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSession sessionTemplate; // private SqlSessionTemplate sessionTemplate; 이렇게 해도 됨.
	@Override
	public List<Emp> empList(Emp searchEmp) {
		return sessionTemplate.selectList("empList", searchEmp);
	}

}
