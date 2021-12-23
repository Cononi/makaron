package com.jua.makaron.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jua.makaron.domain.LoginDTO;
import com.jua.makaron.mapper.LoginMapper;
import com.jua.makaron.utilities.SHA256Util;
import com.jua.makaron.vo.CustomerVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

	private LoginMapper loginMapper;
	
	/**
	 * 로그인 서비스
	 * @return 회원정보 반환
	 */
	@Override
	public CustomerVO userLoginCheck(LoginDTO loginDTO) {
		// 아이디로 회원정보 조회
		CustomerVO customerDTO = loginMapper.userLoginCheck(loginDTO);
		if(customerDTO != null) {
			// 회원 복호화 단서 가져오기
			String userSalt = customerDTO.getSalt();
			// 회원의 복호화 단서키와 웹상에서 받은키를 SHA256으로 암호화키 변환
			loginDTO.setPassword(SHA256Util.getEncrypt(loginDTO.getPassword(), userSalt));
			// 토큰 비교시 맞으면 회원정보를 반환 아니면 null
			if(customerDTO.getPassword().equals(loginDTO.getPassword())) {
				// 자동 로그인 체크시.
//				if (loginDTO.getAutoLoginCheck() != null) {
//					// salt키 생성
//					String salt = SHA256Util.generateSalt();
//					// token 키값 저장
//					String token = loginDTO.getId();
//					// token 키값 변환
//					token = SHA256Util.getEncrypt(token, salt);
//					customerDTO.setSecession_code(token);
//					loginMapper.userSessionSet(customerDTO.getSecession_code(), loginDTO.getId());
//				}
				return customerDTO;
			}
		} 
		
		return null;
	}
	
	/**
	 * 단순히 접속시간만 체크
	 */
	@Override
	public void userLastLoginCheck(String id) {
		loginMapper.userLastLoginCheck(id);
	}
	
	
	@Override
	public void userLoginLockSet(String login_lock, String id) {
		loginMapper.userLoginLockSet(login_lock,id);
	}
	
	
	@Override
	public LoginDTO userLoginCountCheck(String id) {
		return loginMapper.userLoginCountCheck(id);
	}
	
}
