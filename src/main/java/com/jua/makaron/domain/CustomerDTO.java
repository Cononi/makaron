package com.jua.makaron.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDTO {
	
	@NotBlank(message = "X 아이디는 필수 입력 값입니다.")
	@Pattern(regexp="^[a-z0-9]{5,16}$", message = "X 영문으로 시작 그리고 5자 이상의 영문(소문자)과 숫자만 가능, 최대 16자만 사용 가능합니다.")
	private String id;
	
	@NotBlank(message = "X 비밀번호는 필수 입력 값입니다.")
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$",message="최소 8 자 ~ 최대 16 자, 최소 하나의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요.")
	private String password;

	@NotBlank(message = "X 이름은 필수 입력 값입니다.")
	@Pattern(regexp="^[가-힣]{1,15}$", message = "X 최소 3 자, 최대 15 자 그리고 완성된 한글만 입력이 가능합니다.")
	private String name;

	@NotBlank(message = "X 이메일은 필수 입력 값입니다.")
	@Email(message = "X 이메일 형식에 맞게 정확하게 입력해주시기 바랍니다.")
	private String email;

	@NotBlank(message = "X 핸드폰은 필수 입력 값입니다.")
	@Pattern(regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{3,4})\\d{4}$", message = "X 10자리 또는 11자리의 휴대폰 번호를 정확히 입력해주세요.")
	private String phone;
	
	
	private String postal_code;
	

	@NotBlank(message = "X 주소는 필수 입력입니다.")
	private String address_base;
	

	private String address_sub;
	

	private String address_type;
	
	
	@NotBlank(message = "X 성별은 필수 입력 값입니다.")
	@Pattern(regexp="[MW]", message = "X 정확한 성별을 입력해주시기 바랍니다.")
	private String sex;
	
	@NotBlank(message = "X 생일은 필수 입력 값입니다.")
	@Pattern(regexp="^(19[0-9][0-9]|20\\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$", message = "X 생년월일을 정확히 입해주세요.")
	private String birthday;
	
	private String phone_cert;

	private String rating_code;

	private Date register_date;

	private Date access_date;

	private Date secession_date;

	private String state;

	private String depth;

	private String salt;

	private String selected_type;
	
	private String category_id;
	
	
}
