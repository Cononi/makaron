package com.jua.makaron.service;

import com.jua.makaron.vo.LoginVO;

public interface LoginService {
	// 로그인 체크
	public boolean userLoginCheck(LoginVO loginVO);
	
	// 마지막 접속일 입력
	public void userLastLoginCheck(String id);
	
	// salt값 받아오기
	public String userSaltGet(LoginVO loginVO);
	
	// 로그인 정보 받아오기
	public LoginVO userLoginCountCheck(String id);
	
	// 락 변경
	public void userLoginLockSet(String login_lock, String id);
}
