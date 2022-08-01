package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.entity.Category;
import com.lti.entity.ProductType;
import com.lti.entity.Retailer;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	public boolean validateLogin(String username, String Password) {
		return adminDao.adminLogin(username, Password);
	}

	public List<Retailer> viewRetailerApprovalRequests() {
		return adminDao.nonApprovedRetailers();
	}

	public boolean approveRetailer(int retailerId) {
		Retailer r=adminDao.searchRetailer(retailerId);
		if(r!=null) {
			r.setApproved(true);
			Retailer res = adminDao.approveReailer(r);
			if(res!=null) 
				return true;
			else
				return false;
		}
		else
			return false;
		
	}

	public boolean addCategory(Category category) {
		try {
			Category c = adminDao.addOrUpdateCategory(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addProductType(ProductType ptype) {
		try {
			ProductType pt = adminDao.addOrUpdateProductType(ptype);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Category> viewAllCategories() {
		return adminDao.viewAllCategories();
	}

	public List<ProductType> viewPtypeByCategory(int categoryId) {
		return adminDao.viewPtypeByCategory(categoryId);
		
	}
	
	public boolean removeRetailer(int retailerId) {
        try {
            adminDao.removeRetailer(retailerId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
	
	

}
