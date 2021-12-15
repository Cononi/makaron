package com.jua.makaron.service;

import org.springframework.stereotype.Service;

import com.jua.makaron.mapper.RegisterCertMapper;
import com.jua.makaron.utilities.SHA256Util;
import com.jua.makaron.vo.CustomerVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;


@AllArgsConstructor
@Service
public class RegisterCertServiceImpl implements RegisterCertService{
	
	private RegisterCertMapper mapper;
	
	@Override
	public boolean idCheck(String id) {
		return mapper.idCheck(id)!=null;
	}
	
	@Override
	public int register(CustomerVO customerDTO) {
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
		// 인증이 완료된 회원임으로 표시
		customerDTO.setPhone_cert("Y");
		
		System.out.println(customerDTO);
		// 로직 실행과 결과값 반환
		return mapper.register(customerDTO);
	}

}
