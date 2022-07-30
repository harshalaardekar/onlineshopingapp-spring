package com.lti.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.RetailerDao;
import com.lti.dto.RetailerSignupDto;
import com.lti.entity.Retailer;
import com.lti.entity.RetailerDocs;

@Service
public class RetailerServiceImpl implements RetailerService {

	@Autowired
	RetailerDao dao;
	public boolean retailerLogin(int retailerId, String password) {
		
		Retailer retailer = dao.login(retailerId, password);
		if(retailer!=null) {
			if(retailer.isApproved())
				return true;
			else
				return false;
		}
		else {
			return false;
		}
	}

	public String signup(Retailer retailer) {
		if(dao.retailerExist(retailer.getEmail())){
			return "Email Id Already exist";
		}
		else {
		retailer.setApproved(false);
	
		Retailer r1 = dao.addOrUpdate(retailer);
		
		if(r1!=null) {
			return "Signup successful Your userid is: " + r1.getRetailerId();
		}
		else {
			return "Something went wrong... Please try again";
		}
	}
		
	}
	
	
}