package com.jua.makaron.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAdressBookVO {
	private long book_no;
	private String customer_id;
	private String nickname;
	private String postal_code;
	private String address_base;
	private String address_sub;
}
