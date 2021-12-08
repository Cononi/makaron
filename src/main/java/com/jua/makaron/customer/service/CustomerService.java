package com.jua.makaron.customer.service;

import com.jua.makaron.domain.CustomerDTO;


public interface CustomerService {
	//회원 접속날짜 체크
	public void lastDateCheck(String access_date);
	//회원 조회 ( 로그인, 회원 수정시에도 조회 필요 )
	public CustomerDTO customerSearch(String customer_id);
	//회원 수정
	public int modify(CustomerDTO customerDTO);
	//회원 탈퇴
	public int delete(String customer_id);
}
