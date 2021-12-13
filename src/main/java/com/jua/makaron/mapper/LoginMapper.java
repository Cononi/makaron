package com.jua.makaron.mapper;


import org.apache.ibatis.annotations.Param;

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
	
	// 원본키 조회
	public String userSaltGet(String id);
	
	// 로그인 정보 받아오기
	public LoginVO userLoginCountCheck(String id);
	
	// 락 변경
	public void userLoginLockSet(@Param("login_lock") String login_lock,@Param("id") String id);
	
}
