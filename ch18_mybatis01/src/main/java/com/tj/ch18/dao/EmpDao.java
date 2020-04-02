package com.tj.ch18.dao;

import java.util.List;

import com.tj.ch18.dto.Emp;

public interface EmpDao {
	public List<Emp> empList(Emp searchEmp);
}
