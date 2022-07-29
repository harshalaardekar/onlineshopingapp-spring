package com.lti.dao;

import java.util.List;

import com.lti.entity.Customer;
import com.lti.entity.CustomerAddress;

public interface CustomerDao {
	Customer addOrUpdateCustomer(Customer customer);
	
	boolean customerLogin(String emailId , String password);
	
	CustomerAddress addOrUpdateCustomerAddress(CustomerAddress address,int customerId);
	
	String removeAddressById(int addressId);
	
	CustomerAddress searchByAddressId(int addressId);
	
	List<CustomerAddress> viewAllAddress();
	
	boolean customerExist(String email);
	
	Customer searchByCustomerId(int customerId);
	
	List<CustomerAddress> fectchAllAddressesToWhichACustomerBelongs(int addressId);
	
}
