package com.jua.makaron.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderVO {
	
	private String order_id;
	private String product_id;
	private String customer_id;
	private int total_count;
	private int total_price;
	private String invoice_number;
	private String order_messege;
	private String product_order_date;
}
