package com.jua.makaron.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jua.makaron.register.service.RegisterCertService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RegisterCertController {
	

	private RegisterCertService service;
	
	
	@GetMapping("/idCheck/{id}")
	public String idCheck(@PathVariable String id) {
		
		boolean chk = service.idCheck(id);
		
		return chk + "";
		
	}
}
