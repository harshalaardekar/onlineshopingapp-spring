package com.lti.service;

import java.util.List;

import com.lti.dto.UpdatePassword;
import com.lti.dto.addAddressDto;
import com.lti.entity.Customer;
import com.lti.entity.CustomerAddress;

public interface CustomerService {
	
	boolean customerLogin(String emailId, String password);
	boolean customerSignup(Customer customer);
	Customer viewProfile(int customerId);
	boolean updatePassword(UpdatePassword up);
	
	Customer viewDetails(String emailId);
//	UpdatePassword updateCustomerProfile(Customer customer);
	
	boolean customerAddAddress(addAddressDto address);
	boolean updateAddress(CustomerAddress address);
	List<CustomerAddress> viewAllAddreses(int customerId);
	boolean removeCustomerAddress(int addressId);

}
