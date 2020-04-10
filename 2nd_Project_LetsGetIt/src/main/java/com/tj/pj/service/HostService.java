package com.tj.pj.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.tj.pj.dto.Host;

public interface HostService {
	public int idConfirm(String hId);
	public int hostJoin(Host host, HttpSession httpSession); // 회원 가입 하고 나면, 세션에 정보 담을 예정
	public Host getHost(String hId); // 이걸로 로그인도 하고, 수정할 때도 써먹을 예정임
	public int hostModify(Host host, HttpSession httpSession);
	public List<Host> hostList(Host host); // startRow, endRow 다 여기 이뜸~
	public List<Host> hostBestList(Host host);
	public int memberLikeHost(Host host); // 멤버가 좋아해줄때 이걸 소환해서 hcntLike+1 해준당
	public String hostLoginChk(String hId, String hPw, HttpSession httpSession); // getHost 해온 값이랑 비교 예정, 로그인 후에 세션값 필요~
}
