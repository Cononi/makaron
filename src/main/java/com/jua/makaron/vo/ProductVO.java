package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVO {
	private String product_id;
	private String category_id;
	private String product_title;
	private int product_price;
	private int max_count;
	private int delivery_charge;
	private String product_content;
	private Date product_date;
	//ch 추가 url, name필요
	private String file_url;
	private String file_name;
	//ch 추가 qna보여주기위해
	private String qna_no;
	private String customer_id;
	private String qna_title;
	private Date create_date;
	//ch추가  review보여주기위해
	private String review_no;
	private String review_title;
	private String review_content;
	private String view_count;
	
	
	
}
