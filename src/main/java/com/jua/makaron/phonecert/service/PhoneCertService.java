package com.jua.makaron.phonecert.service;

import com.jua.makaron.vo.PhoneCertVO;

public interface PhoneCertService {

	// 인증 횟수 조회
	public int phoneCertHistoryCount(String phone_no);
	
	// 인증 번호 조회
	public PhoneCertVO phoneCertHistoryNumber(String phone_no);
	
	// 인증 입력
	public void phoneCertInsert(PhoneCertVO phoneCertVO);
}
