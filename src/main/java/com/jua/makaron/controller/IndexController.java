package com.jua.makaron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/product")
	public String product() {
		
		return "/product";
	}
	@GetMapping("/cart")
	public String cart() {
		
		return "/cart";
	}
	@GetMapping("/checkout")
	public String checkout() {
		
		return "/checkout";
	}
	
	@GetMapping("/notice")
	public String notice() {
		return "/includes/notice";
	}
	
	@GetMapping("/search")
	public String search() {
		return "/includes/search";
	}

}
