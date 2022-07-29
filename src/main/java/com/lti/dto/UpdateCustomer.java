package com.lti.dto;

import com.lti.entity.Customer;

public class UpdateCustomer {

	String message;
	Customer customer;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setUser(Customer customer) {
		this.customer = customer;
	}
}
