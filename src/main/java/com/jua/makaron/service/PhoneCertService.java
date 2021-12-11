package com.jua.makaron.service;

import com.jua.makaron.vo.PhoneCertVO;

public interface PhoneCertService {

	// 인증 횟수 조회
	public int phoneCertHistoryCount(String phone_no);
	
	// 인증 번호 조회
	public String phoneCertHistoryNumber(String phone_no);
	
	// 인증 입력
	public String phoneCertInsert(PhoneCertVO phoneCertVO);
	
	// 인증 검증
	public PhoneCertVO phoneCertHistoryNumberSuccess(String token);
	
	// 폰 등록 검증
	public int phoneCertUserError(String phone_no);
}
