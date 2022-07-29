package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RetailerLoginDto;
import com.lti.dto.RetailerSignupDto;
import com.lti.entity.Retailer;
import com.lti.service.RetailerService;

@RestController
@RequestMapping("/retailer")
public class RetailerController {
	
	@Autowired
	RetailerService retailerService;	
	
//	http://localhost:8181/OnlineShoppingWebApp/myapp/retailer/signup
	@RequestMapping(value="/signup" , method=RequestMethod.POST) //new usersignup
	public String signup(@RequestBody Retailer retailer) {
		String message=retailerService.signup(retailer);
		return message;
	}
	
//	http://localhost:8181/OnlineShoppingWebApp/myapp/retailer/login
	@PostMapping("/login")
	public boolean login(@RequestBody RetailerLoginDto loginData) {
		boolean res = retailerService.retailerLogin(loginData.getId(), loginData.getPassword());
		
		return res;
	}
}
