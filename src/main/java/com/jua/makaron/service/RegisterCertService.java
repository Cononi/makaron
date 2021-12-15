package com.jua.makaron.service;

import com.jua.makaron.vo.CustomerVO;

public interface RegisterCertService {
	
	// 아이디 중복검사
	public boolean idCheck(String id);
	
	public int register(CustomerVO customerDTO);
}
