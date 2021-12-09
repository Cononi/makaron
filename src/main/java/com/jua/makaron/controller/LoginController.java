package com.jua.makaron.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jua.makaron.login.service.LoginService;
import com.jua.makaron.vo.LoginVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@AllArgsConstructor
@Log4j
public class LoginController {

	private LoginService service;
	
	@PostMapping(value = "/login/check",  produces = "application/json; charset=UTF-8")
	public HashMap<String, String> login(@RequestBody @Valid LoginVO loginVO, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		// 세션이 존재하지 확인
		HttpSession session = request.getSession(false);

		// 에러 내용을 JSON으로 파싱할 맵
		HashMap<String, String> message = new HashMap<>();

		// 객체를 json으로 바꾸기 위한 객체
		//ObjectMapper objectMapper = new ObjectMapper();

		
		// 해당 유효성 검증 실패일 경우
		if (result.hasErrors()) {
			// 에러 필드정보를 담을 리스트
			List<FieldError> errorFileds = result.getFieldErrors();

			// 에러 번호 저장
			message.put("status", "400");
			
			//ValidationUtils.rejectIfEmpty : 값이 null이거나 길이가 0인 경우 에러 코드를 추가
			// 값이 Null 이거나 길이가 0이거나 값이 공백 문자로 구성되어 있는 경우 에러코드를 추가
			// (에러값, 에러명, 에러번호)
			//ValidationUtils.rejectIfEmptyOrWhitespace(result, "id", "required");
			for (FieldError error : errorFileds) {
				// 에러를 순환하면서 map에 저장 (key,value)
				message.put(error.getField(), error.getDefaultMessage());
			}
			// 유효성 처리에 의한값 반환
			return message;
		}
		// 암호화된 패스워드를 받아옴
		String certPassword = service.userSaltGet(loginVO);
		// 암호화된 패스워드로 비밀번호 변경
		loginVO.setPassword(certPassword);
		
		// 로그인 검증 로직후 데이터를 받아옴 검증이 맞다면 True, 아니면 False
		boolean userLoginPWIDCheck = service.userLoginCheck(loginVO);
		// 로그인 성공시
		if(userLoginPWIDCheck) {
			
		} else {
			message.put("status", "400");
			message.put("loginError", "아이디나 비밀번호가 맞지 않습니다.");
		}
		// 자동 로그인이나 로그인시 다른로그인 접속해제 관련부분
//		if(session != null) {
//		}
		/*
		 *  중복 로그인시 최근 접속자가 로그인하도록 유도
		 *  자동 로그인도 해제.
		 */
		return message;
	}
	
}
