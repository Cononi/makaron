package com.jua.makaron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jua.makaron.domain.CustomerDTO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	
	
	@GetMapping("/")
	public String home(RedirectAttributes rttr) {
		//model.addAttribute("ctg_all_lists",pcs_service.ctg_all_list());
		
		return "index";
	}
	
	// 로그인일 경우 가입페이지,로그인 페이지 접속을 안되게 리다이렉트가 필요하다. 
	
	/*
	 * 가입 페이지
	 */
	@GetMapping("/register")
	public void register(CustomerDTO customerDTO, Model model) {
		// hidden Form 세팅
		model.addAttribute("joinUser", customerDTO);
	}
	
	/*
	 * 로그인 페이지
	 */
	@GetMapping("/login")
	public void login(CustomerDTO customerDTO) {
	}

}
