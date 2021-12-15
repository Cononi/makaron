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
}
