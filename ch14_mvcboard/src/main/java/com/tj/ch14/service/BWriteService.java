package com.tj.ch14.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;
import com.tj.ch14.dto.Board;

public class BWriteService implements BService {

	@Override
	public void execute(Model model) {
		// model에 request 객체와 board가 있음		
		Map<String, Object> map = model.asMap(); // model에서 값 빼내기 1단계 : model을 Map화 시킨다.
		Board bDto = (Board) map.get("board"); // board 빼내기
		HttpServletRequest request = (HttpServletRequest)map.get("request"); // request 객체 빼내기
		bDto.setbIp(request.getRemoteAddr());
		
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.write(bDto);
		model.addAttribute("writeResult",result);
		
	}

}
