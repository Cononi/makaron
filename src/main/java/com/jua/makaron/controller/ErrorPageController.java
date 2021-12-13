package com.jua.makaron.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController {

	
	@GetMapping("/error404")
	public String error404(HttpServletResponse res, Model model){
		model.addAttribute("code", "ERROR_404");
		return "error/404";
	}
	
	@GetMapping("/error500")
	public String error500(HttpServletResponse res, Model model){
		model.addAttribute("code", "ERROR_500");
		return "error/500";
	}
}
