package com.lti.service;

import com.lti.entity.Retailer;

public interface RetailerService {
	boolean retailerLogin(int retailerId,String password);
	String signup(Retailer retailer);
	
}
