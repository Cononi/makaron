package com.jua.makaron.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
@AllArgsConstructor
public class MypageQuestionTests {
	
	
	private MypageQuestionService service;
	
	@Test
	public void getQuestionList() {
		service.getQuestionList("seyeon");
	}
	
	
	/*
	 * @Test public void testRegister() {
	 * 
	 * ProductReviewVO review = new ProductReviewVO();
	 * 
	 * String id = "seyeon"; review.setOrder_id("3");
	 * review.setReview_title("테스트 제목"); review.setReview_content("테스트 내용");
	 * 
	 * service.insertReview(id, review);
	 * 
	 * 
	 * }
	 */
	


}
