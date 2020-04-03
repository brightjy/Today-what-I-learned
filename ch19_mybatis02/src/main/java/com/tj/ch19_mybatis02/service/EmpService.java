package com.tj.ch19_mybatis02.service;

import java.util.List;

import com.tj.ch19_mybatis02.dto.Dept;
import com.tj.ch19_mybatis02.dto.Emp;
import com.tj.ch19_mybatis02.dto.EmpDept;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp emp); // 페이징 처리는 컨트롤러에서 하겠음.
	public int total();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	public List<EmpDept> empDeptList(String pageNum); // 페이징 처리를 서비스에서 하겠음.
	public void insert50();
}
