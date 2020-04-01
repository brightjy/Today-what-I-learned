package com.tj.ch14.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;
import com.tj.ch14.dto.Board;

public class BReplyService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		Board bDto = (Board) map.get("board");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		bDto.setbIp(request.getRemoteAddr());
		
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.reply(bDto);
		model.addAttribute("replyResult", result);

	}

}
