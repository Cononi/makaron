package com.jua.makaron.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jua.makaron.service.MypageMainService;
import com.jua.makaron.service.MypageOrderService;
import com.jua.makaron.service.MypageQuestionService;
import com.jua.makaron.service.MypageReviewService;
import com.jua.makaron.vo.CustomerVO;
import com.jua.makaron.vo.ProductReviewVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j
@RequestMapping("/mypage/*")
@AllArgsConstructor
public class MyPageController {
	
	private MypageMainService mainService;
	private MypageOrderService orderService;
	private MypageReviewService reviewService;
	
	//메인 페이지 - 주문 내역 조회
	@GetMapping("/main")
	public void func1(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
				
		model.addAttribute("customerName", mainService.getCustomerName(customer.getId()).getName());
		model.addAttribute("customerRating", mainService.getCustomerRating(customer.getId()).getRating_name());
		model.addAttribute("customerCoupon", mainService.getCouponQuantity(customer.getId()));
		model.addAttribute("orderList", orderService.getOrderList(customer.getId()));	
	}
	
	//배송지 관리 페이지
	@GetMapping("/address")
	public void func2() {
		
	}
	
	//리뷰 관리 페이지
	@GetMapping("/review")
	public void func3(Model model, HttpServletRequest request) {	
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
				
		model.addAttribute("customerName", mainService.getCustomerName(customer.getId()).getName());
		model.addAttribute("customerRating", mainService.getCustomerRating(customer.getId()).getRating_name());
		model.addAttribute("customerCoupon", mainService.getCouponQuantity(customer.getId()));
		model.addAttribute("reviewList", reviewService.getReviewList(customer.getId()));
	}
	
	//리뷰 작성 페이지
	@GetMapping("/addReview")
	public void func4(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
		
		model.addAttribute("chosetoWrite", reviewService.chooseToWrite(customer.getId()));
	}
	
	//리뷰 작성 로직
	@PostMapping("/addReview")
	public String func5(HttpServletRequest request, ProductReviewVO review) {
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
	
		reviewService.insertReview(customer.getId(), review);
		
		return "mypage/close";
	}
	
	//리뷰 삭제 로직
	@PostMapping("/deleteReview") public String func6(ProductReviewVO review) {
	 reviewService.deleteReview(review);
	  
	 return "redirect:/mypage/review"; }
	
	//상품 문의 관리 페이지
	@GetMapping("/question")
	public void func7(Model model, HttpServletRequest request) {	
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
				
		model.addAttribute("customerName", mainService.getCustomerName(customer.getId()).getName());
		model.addAttribute("customerRating", mainService.getCustomerRating(customer.getId()).getRating_name());
		model.addAttribute("customerCoupon", mainService.getCouponQuantity(customer.getId()));
	}
	
	
}
