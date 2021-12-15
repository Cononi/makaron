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
}
