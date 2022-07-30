package com.lti.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.AdminDao;
import com.lti.entity.Admin;
import com.lti.entity.Category;
import com.lti.entity.ProductType;
import com.lti.entity.Retailer;


@SpringBootTest
public class AdminDaoTest {

	@Autowired
	AdminDao dao;

	@Test
	public void addOrUpdateAdmin() {
		
		Admin a = new Admin();
		a.setPassword("admin");
		a.setUsername("admin");
		Admin a2=dao.addOrUpdateAdmin(a);
		assertNotNull(a2);
		
		List<Admin> admins= dao.viewadmins();
		for(Admin a1 : admins) {
			System.out.println(a1.getPassword()+" "+a1.getUsername());
		}

	}
	
	@Test
	public void adminLogin() {
		Boolean loginResult = dao.adminLogin("admin","admi");
		if (loginResult != true) {
			System.out.println("Invalid Credentials");
		} else {
			System.out.println("Login Sucessful");
		}

	}
	
	@Test
	public void viewRetailerDetails() {
		Retailer r=dao.viewRetailerDetails(1006);
		assertNotNull(r);
		System.out.println(r.getRetailerdocs().toString());
	}

	@Test
	public void viewRetailers() {
		List<Retailer> retailers = dao.approvedRetailers();
//		List<Retailer> retailers = dao.nonApprovedRetailers();
		if(retailers.isEmpty())
			System.out.println("No Record Found");
		else
			for(Retailer r:retailers)
				System.out.println(r.toString());
	}
	
	@Test
	public void approveRetailer() {
		Retailer r=dao.searchRetailer(1010);
		if(r!=null) {
			r.setApproved(true);
			System.out.println(dao.approveReailer(r));
		}
		else
			System.out.println("Retailer not present");
	}
	
	@Test
	public void removeTest() {
		dao.removeRetailer(1006);
	}
	
	@Test
	public void addCategoryTest() {
		Category c= new Category();
		c.setCategoryName("Washing Machine");
		
		Category c1 = dao.addOrUpdateCategory(c);
		assertNotNull(c1);
	}
	
	@Test
	public void updateCategoryTest() {
		Category c= new Category();
		c.setCategoryId(106);
		c.setCategoryName("Cloths");
		
		Category c1 = dao.addOrUpdateCategory(c);
		assertNotNull(c1);
	}
	
	@Test
	public void removeCategory() {
		dao.removeCategory(104);
	}
	
	@Test
	public void findCategory() {
		Category c = dao.findCategory(103);
		assertNotNull(c);	
	}
	
	
	@Test
	public void addptypeTest() {
		ProductType p= new ProductType();
		p.setProductTypeName("Mobile");
		p.setCategoryId(105);
		
		ProductType pt=dao.addOrUpdateProductType(p);
		assertNotNull(pt);
	}
	
	@Test
	public void updateptypeTest() {
		ProductType p= new ProductType();
		p.setProductTypeId(101);
		p.setProductTypeName("Mobil");
		ProductType c1 = dao.addOrUpdateProductType(p);
		assertNotNull(c1);
	}
	
	@Test
	public void removeptype() {
		dao.removeCategory(101);
	}
	
	@Test
	public void findptype() {
		Category c = dao.findCategory(102);
		assertNotNull(c);
		
	}
	
	@Test
	public void viewAllCategories() {
		List<Category> c=dao.viewAllCategories();
		assertNotNull(c);;
		for(Category cat:c) {
			System.out.println(cat.getCategoryId()+" "+cat.getCategoryName());
		}
		
	}
	
	@Test
	public void viewPtypeByCategory() {
		List<ProductType> ptype = dao.viewPtypeByCategory(106);
		assertNotNull(ptype);
		for(ProductType pt:ptype) {
			System.out.println(pt.getProductTypeId()+" "+pt.getProductTypeName()+" "+pt.getCategoryId());
		}
	}
	
	@Test
	void testassertnull(){
		String str1=null; 
		String str2="abc"; 
		assertNotNull(str2);
		}
	
	
	
	
	
	
	
	
	
}
