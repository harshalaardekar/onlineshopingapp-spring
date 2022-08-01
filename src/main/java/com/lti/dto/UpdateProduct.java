package com.lti.dto;

import com.lti.entity.Product;

public class UpdateProduct {
	String message;
	Product product;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
