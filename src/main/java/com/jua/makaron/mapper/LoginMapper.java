package com.jua.makaron.mapper;

import com.jua.makaron.vo.LoginVO;

public interface LoginMapper {
	
	// 로그인 체크
	/**
	 * 로그인 서비스
	 * @return 데이터가있으면 1 아니면 0
	 */
	public int userLoginCheck(LoginVO loginVO);
	
	// 마지막 접속일 입력
	public void userLastLoginCheck(String id);
	
	public String userSaltGet(String id);
}
