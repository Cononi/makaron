package com.jua.makaron.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@PropertySource("classpath:/properties/smskeys.properties")
public class SMSKey {
	
	@Value("${sms.naver.accesskey}")
	private String accesskey;
	@Value("${sms.naver.secretkey}")
	private String secretkey;
	@Value("${sms.naver.servicekey}")
	private String servicekey;
}
