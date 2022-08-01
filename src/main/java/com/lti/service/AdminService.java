package com.lti.service;

import java.util.List;

import com.lti.entity.Category;
import com.lti.entity.ProductType;
import com.lti.entity.Retailer;

public interface AdminService {
	
	boolean validateLogin(String username,String Password);
	
	List<Retailer> viewRetailerApprovalRequests();
	boolean approveRetailer(int retailerID);
	
	boolean addCategory(Category category);
	boolean addProductType(ProductType ptype);
	
	List<Category> viewAllCategories();
	List<ProductType> viewPtypeByCategory(int categoryId);
	
	
	boolean removeRetailer(int retailerId);
}
