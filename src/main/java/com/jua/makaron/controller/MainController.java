package com.jua.makaron.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jua.makaron.domain.LoginDTO;
import com.jua.makaron.service.ProductService;
import com.jua.makaron.service.ProductCategoryService;
import com.jua.makaron.vo.CustomerVO;
import com.jua.makaron.vo.ProductCategoryVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	
	private ProductService pro_service;

	@GetMapping("/")
	public String home(RedirectAttributes rttr, Model model) {
		//model.addAttribute("ctg_all_lists",pcs_service.ctg_all_list());
		model.addAttribute("product", pro_service.getList());
	}

	
	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	// 로그인일 경우 가입페이지,로그인 페이지 접속을 안되게 리다이렉트가 필요하다. 
	
	/*
	 * 가입 페이지
	*/
	@GetMapping("/register")
	public void register(CustomerVO customerVO, Model model) {
		// hidden Form 세팅
		model.addAttribute("joinUser", customerVO);
	}
	
	
	/*
	 * 로그인 페이지
	 */
	@GetMapping("/login")
	public void login(LoginDTO loginVO, Model model) {
		// hidden Form 세팅
		model.addAttribute("userLoginForm", loginVO);
	}

	/*
	 *	회원가입 완료 
	 * 
	 */
	@RequestMapping(value = "/status/success")
	public void main(HttpServletRequest request, @RequestParam("id") String id, @RequestParam("name") String name) {
	}
	
}
