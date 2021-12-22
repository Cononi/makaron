package com.jua.makaron.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jua.makaron.domain.LoginDTO;
import com.jua.makaron.interceptor.AuthInterceptor;
import com.jua.makaron.service.LoginService;
import com.jua.makaron.vo.CustomerVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
public class LoginController {

	private LoginService service;
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@PostMapping(value = "/login")
	public @ResponseBody Object login(@Valid LoginDTO loginDTO, BindingResult result, HttpServletRequest request, 
		ModelAndView modelAndView) {
		// 세션이 존재하지 확인
//		HttpSession session = request.getSession(false);
		// 에러 내용을 키값으로 파싱
		HashMap<String, String> message = new HashMap<>();

		// 객체를 키값 형식으로 바꾸거나 JSON형식으로 파싱
//		ObjectMapper objectMapper = new ObjectMapper();
				
		// 하나로만 처리해서 필요가 없어짐.
//		// 해당 유효성 검증 실패일 경우
//		if (result.hasErrors()) {
//			// 에러 필드정보를 담을 리스트
//			List<FieldError> errorFileds = result.getFieldErrors();
//
//			// 에러 번호 저장
//			message.put("status", "400");
//			
//			//ValidationUtils.rejectIfEmpty : 값이 null이거나 길이가 0인 경우 에러 코드를 추가
//			// 값이 Null 이거나 길이가 0이거나 값이 공백 문자로 구성되어 있는 경우 에러코드를 추가
//			// (에러값, 에러명, 에러번호)
//			//ValidationUtils.rejectIfEmptyOrWhitespace(result, "id", "required");
//			for (FieldError error : errorFileds) {
//				// 에러를 순환하면서 map에 저장 (key,value)
//				message.put(error.getField(), error.getDefaultMessage());
//			}
//			// 유효성 처리에 의한값 반환
//		}

		
		// 로그인 카운트와 로그인 차단여부를 검사함. (미완)
		// 로그인 검증 로직후 데이터를 받아옴
		CustomerVO userLoginPWIDCheck = service.userLoginCheck(loginDTO);
		// 로그인 성공시
		if(userLoginPWIDCheck != null && userLoginPWIDCheck.getState().equals("Y")) {
//			HashMap<String, Object> s = objectMapper.convertValue(loginDTO, HashMap.class);
//			for(String key : s.keySet()) {
//				message.put(key, (String) s.get(key));
//			}
			// 로그인 정보를 보냅니다.
			message.put("status", "200");
			request.setAttribute("loginDTO", userLoginPWIDCheck);
		} else {
			message.put("status", "400");
			message.put("loginError", " 아이디 또는 비밀번호가 잘못 입력 되었습니다. 아이디와 비밀번호를 정확히 입력해 주세요.");
			// 화면으로 에러 메세지 전ㅅ
			request.setAttribute("errorLoginMSG",message);
		}

		// 모델폼 정의 
		modelAndView.addObject("userLoginForm",loginDTO);
		// 모델뷰 주소
		modelAndView.setViewName("/login");
		return modelAndView;
	}
	
	
}
