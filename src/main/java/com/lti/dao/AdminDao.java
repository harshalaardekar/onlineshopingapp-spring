package com.lti.dao;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Category;
import com.lti.entity.ProductType;
import com.lti.entity.Retailer;

public interface AdminDao {

	List<Admin> viewadmins() ;
	Admin addOrUpdateAdmin(Admin admin);
	boolean adminLogin(String username, String password);
	
	Retailer serachRetailer(int retailerId);
	Retailer viewRetailerDetails(int retailerId);
	
	List<Retailer> approvedRetailers();
	List<Retailer> nonApprovedRetailers();
	Retailer approveReailer(Retailer retailer);
	Retailer searchRetailer(int retailerId);
	
	void removeRetailer(int retailerId);
	
	Category addOrUpdateCategory(Category category);
	void removeCategory(int categoryId);
	Category findCategory(int categoryId);
	List<Category> viewAllCategories();
	
	ProductType addOrUpdateProductType(ProductType productType);
	void revoveProductType(ProductType productType);
	ProductType findProducttype(int ptypeId);
	List<ProductType> viewPtypeByCategory(int categoryId);
	
}
