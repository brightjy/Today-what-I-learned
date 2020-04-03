package com.tj.ch19_mybatis02.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.ch19_mybatis02.dao.DeptDao;
import com.tj.ch19_mybatis02.dao.EmpDao;
import com.tj.ch19_mybatis02.dto.Dept;
import com.tj.ch19_mybatis02.dto.Emp;
import com.tj.ch19_mybatis02.dto.EmpDept;
import com.tj.ch19_mybatis02.util.Paging;
@Service // 서비스 bean 만들어
public class EmpServiceImpl implements EmpService {
	
	// dao 호출해서 받아야 하니깐
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList();
	}

	@Override
	public List<Emp> empList(Emp emp) { // startRow, endRow는 controller에서 넣어서 호출예정임~
		return empDao.empList(emp);
	}

	@Override
	public int total() {
		return empDao.total();
	}

	@Override
	public Emp detail(int empno) {
		return empDao.detail(empno);
	}

	@Override
	public List<Emp> managerList() {
		return empDao.managerList();
	}

	@Override
	public int insert(Emp emp) {
		return empDao.insert(emp);
	}

	@Override
	public int update(Emp emp) {
		return empDao.update(emp);
	}

	@Override
	public int delete(int empno) {
		return empDao.delete(empno);
	}

	@Override
	public List<EmpDept> empDeptList(String pageNum) {
		Paging paging = new Paging(total(), pageNum, 10, 10); // empDao.total() 해듀 됨.
		EmpDept empDept = new EmpDept(); // 매개변수에 EmpDept empDept 가 없으니까 여기서 해쥼.
		empDept.setStartRow(paging.getStartRow()); // 입력받은 값 셋팅해줌 10
		empDept.setEndRow(paging.getEndRow()); // 입력받은 값 셋팅해줌 10
		return empDao.empDeptList(empDept);
	}

	@Override
	public void insert50() {
		Emp emp = new Emp();
		for(int i=2000; i<2050; i++) {
			emp.setEmpno(i);
			emp.setEname("홍"+i);
			emp.setJob("job");
			emp.setMgr(7566);
			emp.setHiredate(Timestamp.valueOf("2020-04-03 15:43:00"));
			emp.setSal(i);
			emp.setComm(i/10);
			emp.setDeptno(10);
			int result = empDao.insert(emp);
			System.out.println(result==1? i+"성공":i+"실패");
		}
	}
}
