package com.jua.makaron.service;

import org.springframework.stereotype.Service;

import com.jua.makaron.mapper.LoginMapper;
import com.jua.makaron.utilities.SHA256Util;
import com.jua.makaron.vo.LoginVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

	private LoginMapper loginMapper;
	
	/**
	 * 로그인 서비스
	 * @return int값을 받아와서 boolean으로 반환
	 */
	@Override
	public boolean userLoginCheck(LoginVO loginVO) {
		
		// 암호화 토큰과 아이디 전송후 반환값을 받음
		return loginMapper.userLoginCheck(loginVO) == 1 ? true : false;
	}
	
	/**
	 * 단순히 접속시간만 체크
	 */
	@Override
	public void userLastLoginCheck(String id) {
		loginMapper.userLastLoginCheck(id);
	}
	
	
	/**
	 * salt값 받아오기
	 */
	@Override
	public String userSaltGet(LoginVO loginVO) {
		
		// 사실 줄여도 무방
		// 회원의 slat값
		String userSalt = loginMapper.userSaltGet(loginVO.getId()) == null ? loginVO.getId() : loginMapper.userSaltGet(loginVO.getId());
		// 회원 비밀번호
		String password = loginVO.getPassword();
		// SHA256으로 암호화키 변환
		String token = SHA256Util.getEncrypt(password, userSalt);
		// 다시 LoginVO에 비밀번호 저장
		loginVO.setPassword(token);
		
		return loginVO.getPassword();
	}
	
	@Override
	public void userLoginLockSet(String login_lock, String id) {
		loginMapper.userLoginLockSet(login_lock,id);
	}
	
	
	@Override
	public LoginVO userLoginCountCheck(String id) {
		return loginMapper.userLoginCountCheck(id);
	}
	
}
