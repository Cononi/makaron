package com.jua.makaron.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.kerberos.ServicePermission;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jua.makaron.service.PhoneCertService;
import com.jua.makaron.service.RegisterCertService;
import com.jua.makaron.vo.CustomerVO;
import com.jua.makaron.vo.CustomerPhoneHistoryVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@AllArgsConstructor
public class RegisterCertController {
	

	private RegisterCertService service;
	private PhoneCertService servicePhone;
	

	// 아이디 중복 검증
	@PostMapping(value = "/idCheck", produces = "text/plain; charset=UTF-8")
	public String idCheck(@ModelAttribute("id") String id) {
		boolean chk = service.idCheck(id);
		
		return chk + "";
	}
	
	// 회원 가입 유효성 체크
	@PostMapping(value = "/register/check", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	public HashMap<String, String> regiseterCheck(@RequestBody @Valid CustomerVO customerVO, BindingResult result, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		//  에러 내용을 JSON으로 파싱할 맵
		HashMap<String, String> message = new HashMap<>();
		// 객체를 json으로 바꾸기 위한 객체
		ObjectMapper objectMapper = new ObjectMapper();
		// 해당 유효성 검증 실패일 경우
		if (result.hasErrors()) {
			// 에러 필드정보를 담을 리스트
			List<FieldError> errorFileds = result.getFieldErrors();
			
			// 에러 번호 저장
			message.put("status", "400");
			
			//ValidationUtils.rejectIfEmptyOrWhitespace(result, "id", "required");
			for (FieldError error : errorFileds) {
				// 에러를 순환하면서 map에 저장 (key,value)
				message.put(error.getField(), error.getDefaultMessage());
				}
			
			// 순환값 반환
			return message;
			}
		
		Object phoneCC = session.getAttribute("phoneCertComplete");
		// 인증 내역이 있는지
		if(phoneCC != null) {
			// 세션에 저장된 암호화된 인증키를 가져옴
			String cert = (String)session.getAttribute("phoneCertComplete");
			// 암호화된 인증키를 전체 인증내역에서 찾아서 2차 검토
			CustomerPhoneHistoryVO cert_main = servicePhone.phoneCertHistoryNumberSuccess(cert);
			// 원키와 암호화된 키가 서로 맞을경우
			if(cert.equals(cert_main.getToken()) && cert_main.getPhone_no().equals(customerVO.getPhone())) {	
				
				// 휴대폰 인증 검사
				message.put("status", "200");
				message.put("success", "OK");
				// 받아온 데이터를 json화 즉 Key, value를 맵으로 바꿔 다시 반환
				HashMap<String, Object> s = objectMapper.convertValue(customerVO, HashMap.class);
				for(String key : s.keySet()) {
					message.put(key, (String) s.get(key));
		            System.out.println(key + " : " + s.get(key));
				}
				// 가입후 인증 세션 삭제
				session.removeAttribute("phoneCertComplete");
				service.register(customerVO);
			} else {
				message.put("status", "500");
				message.put("success", "미인증");
			}
		} else {
			message.put("status", "500");
			message.put("success", "미인증");
		}
		return message;

	
		
		
	}
	
	
	
}
