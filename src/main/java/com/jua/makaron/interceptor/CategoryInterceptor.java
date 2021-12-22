package com.jua.makaron.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jua.makaron.service.ProductCategoryService;


public class CategoryInterceptor extends HandlerInterceptorAdapter {
	
	 private static final Logger logger = LoggerFactory.getLogger(CategoryInterceptor.class);
	 @Autowired
	 private ProductCategoryService service;
	 
	@Override
	public boolean preHandle(HttpServletRequest request, 
	    HttpServletResponse response,
	    Object handler) throws Exception {
		request.setAttribute("category", service.ctg_all_list());
		return true;
		
	}
}
