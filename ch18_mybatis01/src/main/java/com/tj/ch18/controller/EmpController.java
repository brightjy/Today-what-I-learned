package com.tj.ch18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch18.dto.Emp;
import com.tj.ch18.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService eService;
	@RequestMapping(value="emp", method=RequestMethod.GET)
	public String emp(Emp emp, Model model) {
		model.addAttribute("empList", eService.empList(emp));
		model.addAttribute("deptList", eService.deptList());
		return "emp";
	}
}
