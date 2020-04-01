package com.tj.ch15.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch15.dao.BoardDao;

public class BContentService implements BService {

	@Override
	public void execute(Model model) {
		// model에 bId가 있음.
		Map<String, Object> map = model.asMap(); // model에 어떤 타입을 넣었을지 모르니 일단 Object로 받아서 형변환한다.
		int bId = (Integer) map.get("bId");
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("content_view", bDao.contentView(bId));
	}


}
