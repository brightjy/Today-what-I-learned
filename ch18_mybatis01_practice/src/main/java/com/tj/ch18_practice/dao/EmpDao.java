package com.tj.ch18_practice.dao;

import java.util.List;

import com.tj.ch18_practice.dto.Emp;

public interface EmpDao {
	public List<Emp> empList(Emp searchEmp);
}
