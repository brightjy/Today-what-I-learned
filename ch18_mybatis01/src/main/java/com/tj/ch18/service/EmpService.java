package com.tj.ch18.service;

import java.util.List;

import com.tj.ch18.dto.Dept;
import com.tj.ch18.dto.Emp;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp searchEmp);
}
