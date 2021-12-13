package com.jua.makaron.controller;


import org.springframework.stereotype.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jua.makaron.domain.Criteria;
import com.jua.makaron.domain.PageDTO;
import com.jua.makaron.service.ListService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Controller
public class IndexController {
	
	private ListService service;
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/notice")
	public String notice() {
		return "/includes/notice";
	}
	
	@GetMapping("/list")
	public String list() {
		return "/includes/list";
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
	

	
}
