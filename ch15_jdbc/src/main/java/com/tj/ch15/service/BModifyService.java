package com.tj.ch15.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tj.ch15.dao.BoardDao;
import com.tj.ch15.dto.Board;


public class BModifyService implements BService {

	@Override
	public void execute(Model model) {
		// model에 bId, bDto, request가 있음
		Map<String, Object> map = model.asMap();
		Board bDto = (Board) map.get("bDto");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		bDto.setbIp(request.getRemoteAddr());
		
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.modify(bDto);
		model.addAttribute("modifyResult", result);
	}

}
