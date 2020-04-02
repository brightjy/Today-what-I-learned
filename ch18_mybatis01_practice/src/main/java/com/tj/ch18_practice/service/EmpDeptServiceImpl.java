package com.tj.ch18_practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.ch18_practice.dao.DeptDao;
import com.tj.ch18_practice.dao.EmpDao;
import com.tj.ch18_practice.dto.Dept;
import com.tj.ch18_practice.dto.Emp;
@Service
public class EmpDeptServiceImpl implements EmpDeptService {
	@Autowired
	private DeptDao dDao;
	@Autowired
	private EmpDao eDao;
	@Override
	public List<Dept> deptList() {
		return dDao.deptList();
	}

	@Override
	public List<Emp> empList(Emp searchEmp) {
		if(searchEmp.getEname()!=null) {
			searchEmp.setEname(searchEmp.getEname().toUpperCase());
		}
		if(searchEmp.getJob()!=null) {
			searchEmp.setJob(searchEmp.getJob().toUpperCase());
		}
		return eDao.empList(searchEmp);
	}
}
