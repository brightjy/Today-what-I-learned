package com.tj.ch19_mybatis02.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch19_mybatis02.dto.Emp;
import com.tj.ch19_mybatis02.service.EmpService;
import com.tj.ch19_mybatis02.util.Paging;

@Controller // bean을 만들어유
public class EmpController {

	// service를 써먹을거니까 Autowired받는다.
	@Autowired
	private EmpService service;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(String pageNum, Model model) {
		Paging paging = new Paging(service.total(), pageNum, 10, 10); // 페이징처리(서비스에서 하든지 여기서 하든지)
		Emp emp = new Emp();
		emp.setStartRow(paging.getStartRow());
		emp.setEndRow(paging.getEndRow());
		model.addAttribute("list", service.empList(emp));
		model.addAttribute("paging", paging);
		return "list";
	}

	@RequestMapping(value = "joinlist", method = RequestMethod.GET)
	public String joinlist(String pageNum, Model model) {
		Paging paging = new Paging(service.total(), pageNum, 10, 10);
		model.addAttribute("paging", paging); /// 서비스에서 처리이미 해쥼
		model.addAttribute("joinlist", service.empDeptList(pageNum));
		return "joinlist";
	}
	@RequestMapping(value = "joinlist", method = RequestMethod.POST)
	public String joinlistPost(String pageNum, Model model) {
		Paging paging = new Paging(service.total(), pageNum, 10, 10);
		model.addAttribute("paging", paging); /// 서비스에서 처리이미 해쥼
		model.addAttribute("joinlist", service.empDeptList(pageNum));
		return "joinlist";
	}
	@RequestMapping(value="dummyinsert", method = RequestMethod.GET)
	public String dummyinsert() {
		service.insert50();
		return "redirect:joinlist.do";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(int empno, Model model) {
		model.addAttribute("detail", service.detail(empno));
		return "detail";
	}

	@RequestMapping(value="updateForm", method=RequestMethod.GET) 
	public String updateForm(int empno, Model model) {
		model.addAttribute("updateForm", service.detail(empno));
		return "updateForm";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Emp emp, String tempHiredate, Model model) {
		emp.setHiredate(Timestamp.valueOf(tempHiredate + " 00:00:00"));
		try {
			service.update(emp);			
		}catch(Exception e) {
			model.addAttribute("updateResult", "수정 실패");
			System.out.println(e.getMessage());
			return "forward:updateForm.do";
		}
		return "forward:joinlist.do";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int empno) {
		service.delete(empno);
		return "forward:joinlist.do";
	}
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("managerList", service.managerList());
		model.addAttribute("deptList", service.deptList());
		return "writeForm";
	}
	
	@RequestMapping(value="confirmNo", method=RequestMethod.GET)
	public String confirmNo(int empno, Model model) {
		if(service.detail(empno)==null) {
			model.addAttribute("msg", "사용 가능한 사번입니다");
		}else {
			model.addAttribute("msg", "중복된 사번입니다. 다른 사번으로");
		}
		return "forward:writeForm.do";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Emp emp, String tempHiredate, Model model) {
		emp.setHiredate(Timestamp.valueOf(tempHiredate+" 00:00:00"));
		service.insert(emp);
		return "forward:joinlist.do";
	}


}
