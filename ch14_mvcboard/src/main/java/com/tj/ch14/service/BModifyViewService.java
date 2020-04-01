package com.tj.ch14.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;

public class BModifyViewService implements BService {

	@Override
	public void execute(Model model) {
		// model에 bId가 있음.
				Map<String, Object> map = model.asMap();
				int bId = (Integer) map.get("bId");
				BoardDao bDao = BoardDao.getInstance();
				model.addAttribute("modify_view", bDao.modifyView_replyView(bId));

	}

}
