package com.jua.makaron.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jua.makaron.domain.CustomerDTO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	
//	private ProductCategoryService pcs_service;
	@Autowired
    private HttpSession session;
	
	@GetMapping("/")
	public String home(RedirectAttributes rttr, Model model) {
		//model.addAttribute("ctg_all_lists",pcs_service.ctg_all_list());
		
		return "index";
	}
	// 가입 페이지
	@GetMapping("/register")
	public void register(CustomerDTO customerDTO, Model model) {
		// hidden Form 세팅
		model.addAttribute("joinUser", customerDTO);
		// 세션 제거
		if(session.getAttribute("phoneCertComplete") != null)
			session.removeAttribute("phoneCertComplete");
	}

}
