package com.jua.makaron.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
	
	@NotBlank
	@Length(min = 5, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]{3,20}")
	private String id;
	
	@NotBlank
	@Length(min = 8, max = 16)
	@Pattern(regexp = "[a-zA-Z0-9]{8,16}")
	private String password;
	
	@NotBlank
	@Length(min = 3, max = 15)
	@Pattern(regexp = "[가-힣]{3,15}")
	private String name;
	
	@NotBlank
	@Email
	@Pattern(regexp = "[a-bA-B0-9@]")
	private String email;
	
	@NotBlank
	@Length(min = 10, max=11)
	@Pattern(regexp = "[0-9]{10,11}")
	private String phone;
	
	@NotBlank
	@Length(min = 5)
	@Pattern(regexp = "[0-9]{5,5}")
	private String postal_code;
	
	@NotBlank
	@Pattern(regexp = "[가-힣a-zA-Z0-9_-]")
	private String address_base;
	
	@NotBlank
	@Pattern(regexp = "[가-힣a-zA-Z0-9_-]")
	private String address_sub;
	
	@NotBlank
	@Pattern(regexp = "[RJ]")
	private String address_type;
	
	@NotBlank
	@Pattern(regexp = "[MF]")
	private String sex;
	
	@NotBlank
	@Pattern(regexp = "[0-9-]")
	private Date birthday;
	
	@NotBlank
	@Pattern(regexp = "[YN]")
	private String phone_cert;
	
	@NotBlank
	@Pattern(regexp = "[A-E]")
	private String rating_code;
	
	@NotBlank
	private Date register_date;
	
	@NotBlank
	private Date access_date;
	
	private Date secession_date;
	
	@NotBlank
	@Pattern(regexp = "[NY]")
	private String state;
	
	@NotBlank
	@Pattern(regexp = "[0-3]")
	private String depth;
	
	@NotBlank
	private String salt;

	private String selected_type;
}
