package com.jua.makaron.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jua.makaron.service.ListService;
import com.jua.makaron.service.ProductService;
import com.jua.makaron.vo.ProductCategoryVO;
import com.jua.makaron.vo.ProductImageVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Controller
public class IndexController {

	
	private ProductService pro_service;
	private ListService service;
	
	@GetMapping("/product")
	public void product(@RequestParam("product_id") String product_id, Model model) {
		model.addAttribute("product", pro_service.get(product_id));
		model.addAttribute("qna", pro_service.qna(product_id));
		model.addAttribute("review", pro_service.review(product_id));
		
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
	@GetMapping("/addQna")
	public void addQna(@RequestParam("product_id") String product_id, Model model) {
		model.addAttribute("product", pro_service.product(product_id));
	}
	//qna에 작성후 보내는
//	@PostMapping("/addQna")
//	public String addQna
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
	