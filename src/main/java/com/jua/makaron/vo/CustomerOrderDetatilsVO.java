package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerOrderDetatilsVO {

	private String details_id;
	private String order_id;
	private String customer_order_state_code;
	private String subject_name;
	private String subject_mumber;
	private String postal_code;
	private String address_base;
	private String address_sub;
	private String address_type;
	private Date order_date;
	private Date confirmation_date;
	
	// 작성자 : 함세연
	// MypageOrderMapper에서 사용 (주문 내역 리스트 불러오기)
	private String product_title; //상품명
	private String file_url; //상품 이미지 url
	private String file_name; //상품 이미지명
	private int product_price; //상품 가격
	private int total_count; //총 수량
	private int total_price; //총 가격
	private int final_price; //최종 가격
	private String invoice_number; //운송장 번호
	private String order_messege; //배송 메세지 
	private String state_list_name; //주문 상태 (예:배송준비중 등)
}
