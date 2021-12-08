package com.jua.makaron.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.kerberos.ServicePermission;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jua.makaron.domain.CustomerDTO;
import com.jua.makaron.phonecert.service.PhoneCertService;
import com.jua.makaron.register.service.RegisterCertService;
import com.jua.makaron.vo.PhoneCertVO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RegisterCertController {
	

	private RegisterCertService service;
	private PhoneCertService servicePhone;
	private HttpSession session;
	

	// 아이디 중복 검증
	@GetMapping(value = "/idCheck/{id}", produces = "text/plain; charset=UTF-8")
	public String idCheck(@PathVariable String id) {
		
		boolean chk = service.idCheck(id);
		
		return chk + "";
	}
	
	// 회원 가입 유효성 체크
	@PostMapping(value = "/register/check", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	public HashMap<String, String> regiseterCheck(@RequestBody @Valid CustomerDTO customerDTO, BindingResult result) {
		// 에러 내용을 JSON으로 파싱
		HashMap<String, String> message = new HashMap<>();
		ObjectMapper objectMapper = new ObjectMapper();
		// 해당 유효성 검증 실패일 경우
		if (result.hasErrors()) {
			// 에러 필드정보를 담을 리스트
			List<FieldError> errorFileds = result.getFieldErrors();
			
			// 에러 번호 저장
			message.put("status", "400");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(result, "id", "required");
			for (FieldError error : errorFileds) {
				// 에러를 순환하면서 map에 저장 (key,value)
				message.put(error.getField(), error.getDefaultMessage());
				}
			
			// 순환값 반환
			return message;
			}
		
		System.out.println(session.getAttribute("phoneCertComplete"));
		
		if(session.getAttribute("phoneCertComplete") != null) {
			String cert = (String)session.getAttribute("phoneCertComplete");
			PhoneCertVO cert_main = servicePhone.phoneCertHistoryNumberSuccess(cert);
			if(cert.equals(cert_main.getToken()) && cert_main.getPhone_no().equals(customerDTO.getPhone())) {	
				
				// 휴대폰 인증 검사
				message.put("status", "200");
				message.put("success", "OK");
				// 맵 데이터를 반환
				HashMap<String, Object> s = objectMapper.convertValue(customerDTO, HashMap.class);
				for(String key : s.keySet()) {
					message.put(key, (String) s.get(key));
		            System.out.println(key + " : " + s.get(key));
				}
				session.removeAttribute("phoneCertComplete");
			} else {
				message.put("status", "500");
				message.put("success", "미인증");
			}
		} 
		return message;

	
		
		
	}
	
	// 회원 가입 완료
	@PostMapping(value = "/register/check/success")
	public void success(@ModelAttribute("joinUser") CustomerDTO customerDTO, HttpServletResponse response) throws IOException {
		customerDTO.setPhone_cert("Y");
		System.out.println(customerDTO);
		service.register(customerDTO);
		response.sendRedirect("/");
	}
	
	
	
}
