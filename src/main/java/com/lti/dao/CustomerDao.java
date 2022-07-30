package com.lti.dao;

import java.util.List;

import com.lti.dto.UpdatePassword;
import com.lti.entity.Customer;
import com.lti.entity.CustomerAddress;

public interface CustomerDao {
	
	boolean customerExist(String email);
	
	Customer addOrUpdateCustomer(Customer customer);
	boolean customerLogin(String emailId , String password);
	Customer viewCustomerDetails(int customerID);
	
	Customer viewCustomerDetails(String emailId);
	Customer searchByCustomerId(int customerId);
	Boolean updatePassword(UpdatePassword up);
		
	CustomerAddress addOrUpdateCustomerAddress(CustomerAddress address);
	CustomerAddress searchByAddressId(int addressId);
	CustomerAddress updateAddress(CustomerAddress address);
	void removeAddressById(int addressId);
	
	
}
