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
	public void phoneCertInsert(PhoneCertVO phoneCertVO) {
		String salt = SHA256Util.generateSalt();
		
		phoneCertVO.setSalt(salt);
		
		String token = phoneCertVO.getToken();
		
		token = SHA256Util.getEncrypt(token, salt);
		
		// 다시 DTO에 저장
		phoneCertVO.setToken(token);
		
		phoneCertMapper.phoneCertInsert(phoneCertVO);
	}

}
