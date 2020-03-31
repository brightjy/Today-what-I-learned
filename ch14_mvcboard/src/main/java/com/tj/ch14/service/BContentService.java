package com.tj.ch14.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;

public class BContentService implements BService {

	@Override
	public void execute(Model model) {
		// model에 bId, pageNum 가 있음.
		Map<String, Object> map = model.asMap();
		int bId = Integer.parseInt((String) map.get("bId"));
		String pageNum = (String) map.get("pageNum");
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("content_view", bDao.contentView(bId));
		model.addAttribute("pageNum", pageNum);
	}

}
