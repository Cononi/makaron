package com.jua.makaron.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jua.makaron.service.ListService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Controller
public class IndexController {

	private ListService service;
	
	@GetMapping("/product")
	public String index() {
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
	
	@GetMapping("/list")
	public String list() {
		return "/includes/list";
	}
}
	
//	@RequestMapping("/list")  //board/list?pageNum=1&amount=10
//	public void list(Criteria cri,Model model) {    // /board/list -> /board/list.jsp
//		model.addAttribute("list",service.getList(cri));
//		PageDTO dto = new PageDTO(cri);
//		log.info("페이지 처리 내용" + dto);
//		model.addAttribute("pageMaker",dto);
//	
//	}
//	
//	
//	@GetMapping("/list")
//	public void list(Model model) {
//		
//		log.info("list");
//		model.addAttribute("list", service.getList());
//		
//		
//	}
	