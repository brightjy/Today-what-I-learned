package com.tj.ch19_mybatis02.dao;

import java.util.List;

import com.tj.ch19_mybatis02.dto.Dept;

public interface DeptDao {
	public List<Dept> deptList(); // 메소드이름=id이름 (으로 함)
}
