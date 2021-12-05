package com.jua.makaron.register.service;

import org.springframework.stereotype.Service;

import com.jua.makaron.mapper.RegisterCertMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegisterCertServiceImpl implements RegisterCertService{
	
	private RegisterCertMapper mapper;
	
	@Override
	public boolean idCheck(String id) {
		return mapper.idCheck(id)!=null;
	}
	
	@Override
	public String smsAccess() {
		
		// TODO Auto-generated method stub
		return null;
	}

}
