package com.tj.ch14.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;

public class BReplyViewService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); // 모델을 Map화 (asMap)
		int bId = (Integer) map.get("bId");
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("reply_view", bDao.modifyView_replyView(bId));
		
	}

}
