package com.jua.makaron.service;


import org.springframework.stereotype.Service;

import com.jua.makaron.mapper.CustomerMapper;
import com.jua.makaron.vo.CustomerVO;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerMapper customerMapper;
	

	@Override
	public CustomerVO customerSearch(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(CustomerVO customerDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String customer_id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
