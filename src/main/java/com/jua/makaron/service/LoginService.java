package com.jua.makaron.service;

import com.jua.makaron.domain.LoginDTO;
import com.jua.makaron.vo.CustomerVO;

public interface LoginService {
	// 로그인 체크
	public CustomerVO userLoginCheck(LoginDTO loginDTO);
	
	// 마지막 접속일 입력
	public void userLastLoginCheck(String id);
	// 로그인 정보 받아오기
	public LoginDTO userLoginCountCheck(String id);
	
	// 락 변경
	public void userLoginLockSet(String login_lock, String id);
}
