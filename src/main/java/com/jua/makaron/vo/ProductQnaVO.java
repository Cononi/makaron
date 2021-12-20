package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductQnaVO {
	private String qna_no;
	private String product_id;
	private String customer_id;
	private String qna_title;
	private String qna_content;
	private Date create_date;
	private Date update_date;
	private String is_del;
	
	// 작성자 : 함세연
	// MypageQuestionMapper에서 사용 (상품 문의 리스트 불러오기)
    private String name; // 유저 이름
    private String product_title; // 상품명
}
