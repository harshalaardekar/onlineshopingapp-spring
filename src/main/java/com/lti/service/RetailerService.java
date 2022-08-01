package com.lti.service;

import com.lti.dto.RegResponseDto;
import com.lti.dto.UpdateRetailer;
import com.lti.entity.Retailer;

public interface RetailerService {
	boolean retailerLogin(int retailerId,String password);
	RegResponseDto signup(Retailer retailer);
    UpdateRetailer updateProfile(Retailer retailer);
    Retailer findRetailer(int retailerId);
	
}
