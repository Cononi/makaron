package com.jua.makaron.phonecert.service;

import org.springframework.stereotype.Service;

import com.jua.makaron.mapper.PhoneCertMapper;
import com.jua.makaron.utilities.SHA256Util;
import com.jua.makaron.vo.PhoneCertVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PhoneCertServiceImpl implements PhoneCertService {

 	private PhoneCertMapper phoneCertMapper; 
	
	@Override
	public int phoneCertHistoryCount(String phone_no) {
		return phoneCertMapper.phoneCertHistory(phone_no);
	}

	@Override
	public PhoneCertVO phoneCertHistoryNumber(String phone_no) {
		// TODO Auto-generated method stub
		return phoneCertMapper.phoneCertHistoryNumber(phone_no);
	}
	
	@Override
	public String phoneCertInsert(PhoneCertVO phoneCertVO) {
		// salt키 생성
		String salt = SHA256Util.generateSalt();
		// salt키 저장
		phoneCertVO.setSalt(salt);
		// token 키값 저장
		String token = phoneCertVO.getToken();
		// token 키값 변환
		token = SHA256Util.getEncrypt(token, salt);
		
		// 다시 DTO에 저장
		phoneCertVO.setToken(token);
		// DB에 저장
		phoneCertMapper.phoneCertInsert(phoneCertVO);
		// 암호화 토큰 전송
		return token;
	}

}
