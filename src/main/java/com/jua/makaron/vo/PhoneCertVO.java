package com.jua.makaron.vo;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneCertVO {

	private String no;
	@NotBlank
	@Pattern(regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{3,4})\\d{4}$")
	private String phone_no;
	@Pattern(regexp = "[0-9]{6}")
	private String token;
	private Date sms_date;
	private String salt;
	
}
