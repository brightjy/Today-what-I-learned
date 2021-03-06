package com.tj.ch15.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch15.dao.BoardDao;

public class BDeleteService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bId = (Integer) map.get("bId");
		
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("deleteResult", bDao.delete(bId));

	}

}
