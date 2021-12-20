package com.jua.makaron.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jua.makaron.vo.ProductReviewVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MypageReviewTests {
	
	@Setter(onMethod_ = {@Autowired })
	private MypageReviewService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		
		ProductReviewVO review = new ProductReviewVO();
		
		String id = "seyeon";
		review.setOrder_id("3");
		review.setReview_title("테스트 제목");
		review.setReview_content("테스트 내용");
		
		service.insertReview(id, review);
		
		
	}
	
	@Test
	public void testDel() {
		ProductReviewVO review = new ProductReviewVO();
		System.out.println("@@@@@@@@@@@테스트시작@@@@");
		review.setReview_no("3");
		System.out.println(review.getReview_no());
		service.deleteReview(review);
	}

}
