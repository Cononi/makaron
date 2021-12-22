package com.jua.makaron.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jua.makaron.domain.CriteriaDTO;
import com.jua.makaron.domain.PageDTO;
import com.jua.makaron.service.MypageMainService;
import com.jua.makaron.service.MypageOrderService;
import com.jua.makaron.service.MypageQuestionService;
import com.jua.makaron.service.MypageReviewService;
import com.jua.makaron.vo.CustomerVO;
import com.jua.makaron.vo.ProductQnaVO;
import com.jua.makaron.vo.ProductReviewVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/mypage/*")
@AllArgsConstructor
public class MyPageController {
	
	private MypageMainService mainService;
	private MypageOrderService orderService;
	private MypageReviewService reviewService;
	private MypageQuestionService quesitonService;
	
	//메인 페이지 - 주문 내역 조회
	@GetMapping("/main")
	public void func1(CriteriaDTO cri, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
		String id = customer.getId();
				
		model.addAttribute("customerName", mainService.getCustomerName(id).getName());
		model.addAttribute("customerRating", mainService.getCustomerRating(id).getRating_name());
		model.addAttribute("customerCoupon", mainService.getCouponQuantity(id));
		model.addAttribute("orderList", orderService.getOrderList(id, cri));	
		model.addAttribute("pageMaker", new PageDTO(cri, orderService.getOrderQuantity(id)));
	}
	
	@GetMapping("/myPage")
	public String func1() {
		
		return "myPage";
	}

	//배송지 관리 페이지
	@GetMapping("/address")
	public void func2() {
		
	}
	
	//리뷰 관리 페이지
	@GetMapping("/review")
	public void func3(CriteriaDTO cri, Model model, HttpServletRequest request) {	
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
		String id = customer.getId();
				
		model.addAttribute("customerName", mainService.getCustomerName(id).getName());
		model.addAttribute("customerRating", mainService.getCustomerRating(id).getRating_name());
		model.addAttribute("customerCoupon", mainService.getCouponQuantity(id));
		model.addAttribute("reviewList", reviewService.getReviewList(id, cri));
		model.addAttribute("pageMaker", new PageDTO(cri, reviewService.getReviewQuantity(id)));
	}
	
	//리뷰 작성 페이지
	@GetMapping("/addReview")
	public void func4(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
		String id = customer.getId();
		
		model.addAttribute("chosetoWrite", reviewService.chooseToWrite(id));
	}
	
	//리뷰 작성 로직
	@PostMapping("/addReview")
	public String func5(HttpServletRequest request, ProductReviewVO review, Model model) {
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
		String id = customer.getId();
		
		reviewService.insertReview(id, review);
		model.addAttribute("what","후기");
		return "mypage/close";
	}
	
	//리뷰 삭제 로직
	@PostMapping("/deleteReview") 
	public String func6(ProductReviewVO review, @ModelAttribute("cri") CriteriaDTO cri
			, RedirectAttributes rttr) {

		reviewService.deleteReview(review);
		  
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/mypage/review"; 
	}
	
	//상품 문의 관리 페이지
	@GetMapping("/question")
	public void func7(CriteriaDTO cri, Model model, HttpServletRequest request) {	
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
		String id = customer.getId();
		
		model.addAttribute("customerName", mainService.getCustomerName(id).getName());
		model.addAttribute("customerRating", mainService.getCustomerRating(id).getRating_name());
		model.addAttribute("customerCoupon", mainService.getCouponQuantity(id));
		model.addAttribute("QnaList", quesitonService.getQuestionList(id,cri));
		model.addAttribute("pageMaker", new PageDTO(cri, quesitonService.getQuestionQuantity(id)));
	}
	
	//상품 문의 작성 페이지
	@GetMapping("/addQuestion")
	public void func8(Model model) {

		model.addAttribute("allProductName", quesitonService.allProductName());
	}
		
	//상품 문의 작성 로직
	@PostMapping("/addQuestion")
	public String func9(HttpServletRequest request, ProductQnaVO qna, Model model) {
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO)session.getAttribute("login");
		String id = customer.getId();
		
		quesitonService.insertQuestion(id, qna);
		model.addAttribute("what","문의");
		return "mypage/close";
	}
	
	//상품 문의 삭제 로직
	@PostMapping("/deleteQuestion") 
	public String func10(ProductQnaVO qna, @ModelAttribute("cri") CriteriaDTO cri
			, RedirectAttributes rttr) {
		
		quesitonService.deleteQuestion(qna);
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/mypage/question"; 
	}
	
	
		
	
}
