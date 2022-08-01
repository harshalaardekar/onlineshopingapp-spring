package com.lti.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.RetailerDao;
import com.lti.dto.RegResponseDto;
import com.lti.dto.UpdateRetailer;
import com.lti.entity.Retailer;
import com.lti.exception.UserIdMissingException;
import com.lti.exception.UserNotFoundException;

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
//		return true;
	}

//	public String signup(Retailer retailer) {
//		if(dao.retailerExist(retailer.getEmail())){
//			return "Email Id Already exist";
//		}
//		else {
//		retailer.setApproved(false);
//	
//		Retailer r1 = dao.addOrUpdate(retailer);
//		
//		if(r1!=null) {
//			return "Signup successful Your userid is: " + r1.getRetailerId();
//		}
//		else {
//			return "Something went wrong... Please try again";
//		}
//	}
//		
//	}
	
	 public RegResponseDto signup(Retailer retailer) {
	        // validate user object data
	        try {
	            Retailer retailer2 = dao.addOrUpdate(retailer);
	            //String email=retailer2.getEmail();
	            String text="Registration Successful. Your generated retailer id"
	                    + " is "+retailer2.getRetailerId();
	            String subject="Registration Confirmation";

	            //emailService.sendEmailForSignup(email, text, subject);
	            //System.out.println("Email sent.");
	            //return "Sign up successful. Your userId is: " + user2.getUserId();
	            RegResponseDto dto=new RegResponseDto();
	            dto.setRetailerId(retailer2.getRetailerId());
	            dto.setMessage(text);
	            return dto;
	        } catch (Exception e) {
	            //return "Unexpected error occured. Signup failed.";
	            RegResponseDto dto=new RegResponseDto();
	            //dto.setUserId(0);
	            dto.setMessage("Unexpected error occured. Signup failed.");
	            return dto;
	        }
	    }

	    public UpdateRetailer updateProfile(Retailer retailer) {
	        UpdateRetailer updateRetailer=new UpdateRetailer();
	        try {
	            if (retailer.getRetailerId()==0) {
	                throw new UserIdMissingException("Please mention your retailer id.");
	            } else if (dao.searchRetailerById(retailer.getRetailerId()) == null) {
	                throw new UserNotFoundException("Retailer not found.");
	            } else {
	                Retailer retailer2 = dao.addOrUpdate(retailer);
//	                return "User ID: " + user2.getUserId() + "\nUser Name: " + user2.getUserName() + "\nEmail: "
//	                        + user2.getEmail();
	                updateRetailer.setMessage("Profile updated.");
	                updateRetailer.setRetailer(retailer);
	                return updateRetailer;
	            }
	        } catch (Exception e) {
	            updateRetailer.setMessage(e.getMessage());
	            return updateRetailer;
	        }
	    }
	public Retailer findRetailer(int retailerId) {

	        return dao.searchRetailerById(retailerId);
	    }

	    

	
	
}