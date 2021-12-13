package com.jua.makaron.domain;

import lombok.Data;

@Data
public class ProductVO {
	
	private String ID;
	private String title;	//상품명
	private String sub_title;	//서브제목
	private int price;	//가격
	private int sale_price;	//할인율
	private int max_count;	//판매수량
	private int final_price;	//할인된가격
	private String priduct_image_id;	//이미지 URL
}



