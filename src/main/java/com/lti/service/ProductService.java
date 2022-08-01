package com.lti.service;

import java.util.List;

import com.lti.dto.UpdateProduct;
import com.lti.dto.UpdateRetailer;
import com.lti.entity.Product;
import com.lti.entity.Retailer;

public interface ProductService {
	boolean addProduct(Product product);
	
	Product findProduct(int productId);
	
	UpdateProduct updateProfile(Product product);
	
	public List<Product> viewAllProducts();
}
