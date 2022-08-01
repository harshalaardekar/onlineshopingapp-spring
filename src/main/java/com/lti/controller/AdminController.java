package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Admin;
import com.lti.entity.Category;
import com.lti.entity.ProductType;
import com.lti.entity.Retailer;
import com.lti.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
//	http://localhost:8181/OnlineShoppingWebApp/myapp/admin/login
	@PostMapping("/login")
	public boolean login(@RequestBody Admin login) {
		boolean res = adminService.validateLogin(login.getUsername(), login.getPassword());
		return res;
	}
	
//	http://localhost:8181/OnlineShoppingWebApp/myapp/admin/retailerRequests
	@GetMapping("/retailerRequests")
	public List<Retailer> viewRetailerApprovalRequests(){
		return adminService.viewRetailerApprovalRequests();
	}
	
	@GetMapping("/approveRetailer/{retailerId}")
	public boolean approveRetailer(@PathVariable int retailerId) {
		return adminService.approveRetailer(retailerId);
	}
	
	@RequestMapping(value="/addCategory" , method=RequestMethod.POST) 
	public boolean addCategory(@RequestBody Category category) {
		boolean res=adminService.addCategory(category);
		return res;
	}
	
	@RequestMapping(value="/addProductType" , method=RequestMethod.POST)
	public boolean addProductType(@RequestBody ProductType productType) {
		boolean res=adminService.addProductType(productType);
		return res;
	}
	
	@GetMapping("/viewallcategories")
	public List<Category> viewAllCategories(){
		return adminService.viewAllCategories();
	}
	
	@GetMapping("/viewallproducttypes/{categoryId}")
	public List<ProductType> viewPtypeByCategory(@PathVariable int categoryId){
		return adminService.viewPtypeByCategory(categoryId);
	}
	
	  @RequestMapping(value="/removeRetailer/{retailerId}",method=RequestMethod.DELETE)
	    public boolean removeRetailer(@PathVariable int retailerId) {
	        boolean res= adminService.removeRetailer(retailerId);
	        return res;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
