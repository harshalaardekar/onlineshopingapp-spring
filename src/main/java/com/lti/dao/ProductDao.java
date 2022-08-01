package com.lti.dao;

import java.util.List;

import com.lti.entity.Product;

public interface ProductDao {
	Product addOrUpdateProduct(Product product);

	Product searchProductById(int productId);
	
	public List<Product> viewAllProducts();
}
