package com.lti.service;

import java.util.List;

import com.lti.dto.UpdateCustomer;
import com.lti.entity.Customer;
import com.lti.entity.CustomerAddress;

public interface CustomerService {
	
	boolean customerLogin(String emailId, String password);

	String customerSignup(Customer customer);
	
	UpdateCustomer updateCustomerProfile(Customer customer);
	
//	String customerAddAddress(CustomerAddress address);
	
	String removeCustomerAddress(int addressId);
	
	List<CustomerAddress> viewAllAddreses(int addressId);

}
