package com.jua.makaron.mapper;

import com.jua.makaron.vo.PhoneCertVO;

public interface PhoneCertMapper {
	
	// 인증 조회
	public int phoneCertHistory(String phone_no);
	
	// 인증 번호 조회
	public String phoneCertHistoryNumber(String phone_no);
	
	// 인증 입력
	public void phoneCertInsert(PhoneCertVO phoneCertVO);
	
	// 인증 검증
	public PhoneCertVO phoneCertHistoryNumberSuccess(String token);
	
	// 가입 조회
	public int phoneCertUserError(String phone_no);
}
