package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReviewVO {
	
	private String review_no;
	private String product_id;
	private String customer_id;
	private String review_title;
	private String review_content;
	private String view_count;
	private Date create_date;
	private Date update_date;
	private String is_del;
	
	// 작성자 : 함세연
	// MypageReviewMapper에서 사용 (상품 리뷰 리스트 불러오기, 작성하기)
	private String product_title; // 상품명
	private String product_price; // 상품 가격
	private String order_id; //주문번호
}
