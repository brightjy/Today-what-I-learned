package com.tj.ch18_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tj.ch18_practice.dto.Emp;
import com.tj.ch18_practice.service.EmpDeptService;

@Controller
public class EmpController {
	@Autowired
	private EmpDeptService edService;
	@RequestMapping(value="emp", method=RequestMethod.GET)
	public String emp(Emp emp, Model model) {
		model.addAttribute("empList", edService.empList(emp));
		model.addAttribute("deptList", edService.deptList());
		return "emp";
	}
}
