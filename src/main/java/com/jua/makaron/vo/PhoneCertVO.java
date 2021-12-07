package com.jua.makaron.vo;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneCertVO {

	private String no;
	private String phone_no;
	private String token;
	private Date sms_date;
	private String salt;
	
}
