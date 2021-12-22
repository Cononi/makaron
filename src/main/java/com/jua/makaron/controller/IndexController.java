package com.jua.makaron.controller;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.domain.PageDTO;
import com.jua.makaron.domain.PageMakerDTO;
import com.jua.makaron.vo.ProductVO;
import com.jua.makaron.interceptor.AuthInterceptor;
import com.jua.makaron.service.ListService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	private ListService service;
	
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
	
	
	
	
	/* 상품목록 페이지 이동*/
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void listGET(CriteriaDTO cri, Model model) throws Exception{
		
		logger.info(cri.getKeyword());

		log.info("list: " + cri);
		model.addAttribute("list", service.searchList(cri));
		//model.addAttribute("pageMaker", new PageDTO(cri, 123));
		
		int total = service.getTotal(cri);
		
		log.info("total: " + total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		
		/* 상품 리스트 데이터 */
		List<ProductVO> list = service.searchList(cri);
		
		for(ProductVO lis : list) {
			logger.info(lis.getProduct_title());
		}
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
		}else {
			model.addAttribute("listCheck", "empty");
			return;
		}
		
		
	
		
		
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
	