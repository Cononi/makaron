package com.jua.makaron.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {
	
	@NotBlank
	@Pattern(regexp="^[a-z0-9!]{5,16}$")
	private String id;
	
	@NotBlank
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$")
	private String password;
	
//	@NotBlank
//	@Pattern(regexp="[01]")
	private String autoLoginCheck;
	
}
