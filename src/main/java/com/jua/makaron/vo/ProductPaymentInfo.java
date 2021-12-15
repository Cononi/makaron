package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPaymentInfo {
	private String payment_info_id;
	private int total_money;
	private Date payment_date;
	private String bank_list_name;
	private String bank_customer_name;
	private String payment_state;
}
