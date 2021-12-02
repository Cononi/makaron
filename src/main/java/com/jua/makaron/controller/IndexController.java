package com.jua.makaron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	@GetMapping("/product")
	public String product() {
		
		return "/includes/product";
	}
	@GetMapping("/cart")
	public String cart() {
		
		return "/includes/cart";
	}
	@GetMapping("/checkout")
	public String checkout() {
		
		return "/includes/checkout";
	}
}
