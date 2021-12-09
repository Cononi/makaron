package com.jua.makaron.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {
	
	@NotBlank(message = "X 아이디는 필수 입력 값입니다.")
	@Pattern(regexp="^[a-z0-9!]{5,16}$", message = "X 영문으로 시작 그리고 5자 이상의 영문(소문자)과 숫자만 가능, 최대 16자만 사용 가능합니다.")
	private String id;
	
	@NotBlank(message = "X 비밀번호는 필수 입력 값입니다.")
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$",message="최소 8 자 ~ 최대 16 자, 최소 하나의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요.")
	private String password;
	
//	@NotBlank
//	@Pattern(regexp="[01]")
	private String autoLoginCheck;
	
	private String salt;
}
