package com.jua.makaron.customer.service;


import org.springframework.stereotype.Service;

import com.jua.makaron.domain.CustomerDTO;
import com.jua.makaron.mapper.CustomerMapper;
import com.jua.makaron.utilities.SHA256Util;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerMapper cus_mapper;
	

	@Override
	public void lastDateCheck(String access_date) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerDTO customerSearch(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String customer_id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
