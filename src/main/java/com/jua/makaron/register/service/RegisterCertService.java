package com.jua.makaron.register.service;

import com.jua.makaron.domain.CustomerDTO;

public interface RegisterCertService {
	
	// 아이디 중복검사
	public boolean idCheck(String id);
	
	public int register(CustomerDTO customerDTO);
}
