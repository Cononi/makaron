package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCouponVO {
	private int coupon_no;
	private String product_id;
	private String coupon_info;
	private int discount_rate;
	private int discount_amount;
	private Date create_date;
	private Date open_validity_date;
	private Date close_validity_date;
	private String coupon_state;
}
