package com.jua.makaron.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneCertVO {

	public String no;
	public String phone_no;
	public String token;
	public Date sms_date;
	public String salt;
	
}
