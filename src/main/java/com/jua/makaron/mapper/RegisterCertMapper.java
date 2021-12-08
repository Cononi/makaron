package com.jua.makaron.mapper;

import com.jua.makaron.domain.CustomerDTO;

public interface RegisterCertMapper {

	// 아이디 중복검사
	public String idCheck(String id);
	//회원 가입
	public int register(CustomerDTO customerDTO);
}
