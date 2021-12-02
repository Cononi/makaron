package com.jua.makaron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {
	
	@GetMapping("/myPage")
	public void func1() {	
	}
	
	@GetMapping("/myPage_address")
	public void func2() {	
	}
	
	@GetMapping("/myPage_review")
	public void func3() {	
	}
	
	@GetMapping("/myPage_question")
	public void func4() {	
	}
	
}
