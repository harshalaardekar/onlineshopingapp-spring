package com.lti.service;

import java.util.List;

import com.lti.dto.UpdatePassword;
import com.lti.entity.Customer;
import com.lti.entity.CustomerAddress;

public interface CustomerService {
	
	boolean customerLogin(String emailId, String password);

	boolean customerSignup(Customer customer);
	Customer viewProfile(int customerId);
	
	boolean updatePassword(UpdatePassword up);
	
//	UpdatePassword updateCustomerProfile(Customer customer);
	
//	String customerAddAddress(CustomerAddress address);
	
	String removeCustomerAddress(int addressId);
	
	List<CustomerAddress> viewAllAddreses(int addressId);

}
