package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCartVO {
	
	private String cart_id;
	private String customer_id;
	private String product_id;
	private int cart_count;
	private Date create_date;
	
}
