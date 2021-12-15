package com.jua.makaron.service;

import com.jua.makaron.vo.CustomerPhoneHistoryVO;

public interface PhoneCertService {

	// 인증 횟수 조회
	public int phoneCertHistoryCount(String phone_no);
	
	// 인증 번호 조회
	public String phoneCertHistoryNumber(String phone_no);
	
	// 인증 입력
	public String phoneCertInsert(CustomerPhoneHistoryVO phoneCertVO);
	
	// 인증 검증
	public CustomerPhoneHistoryVO phoneCertHistoryNumberSuccess(String token);
	
	// 폰 등록 검증
	public int phoneCertUserError(String phone_no);
}
