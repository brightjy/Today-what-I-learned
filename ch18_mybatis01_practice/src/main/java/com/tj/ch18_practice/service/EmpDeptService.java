package com.tj.ch18_practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tj.ch18_practice.dto.Dept;
import com.tj.ch18_practice.dto.Emp;

public interface EmpDeptService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp searchEmp);
}
