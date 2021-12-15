package com.jua.makaron.mapper;

import com.jua.makaron.vo.CustomerVO;

public interface CustomerMapper {

	//회원 접속날짜 체크
	public void lastDateCheck(String access_date);
	//회원 조회 ( 로그인, 회원 수정시에도 조회 필요 )
	public CustomerVO customerSearch(String customer_id);
	//회원 수정
	public int modify(CustomerVO customerDTO);
	//회원 탈퇴
	public int delete(String customer_id);
}
