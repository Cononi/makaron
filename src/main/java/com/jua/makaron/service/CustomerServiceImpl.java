package com.jua.makaron.service;


import org.springframework.stereotype.Service;

import com.jua.makaron.domain.CustomerDTO;
import com.jua.makaron.mapper.CustomerMapper;
import com.jua.makaron.utilities.SHA256Util;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerMapper cus_mapper;
	
	@Override
	public int register(CustomerDTO customerDTO) {
		//SHA256 암호화 - Hash 알고리즘 기반
		//salt 난수 생성
		String salt = SHA256Util.generateSalt();
		
		//salt 저장
		customerDTO.setSalt(salt);
		
		// 패스워드 저장
		String password = customerDTO.getPassword();
		// 저장한 비밀번호를 난수화 합한후 함께 암호화 한다.
		password = SHA256Util.getEncrypt(password, salt);
		// 다시 DTO에 저장
		customerDTO.setPassword(password);
		// 로직 실행과 결과값 반환
		return cus_mapper.register(customerDTO);
	}

	@Override
	public void lastDateCheck(String access_date) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerDTO customerSearch(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String customer_id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
