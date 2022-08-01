package com.lti.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.RetailerDao;
import com.lti.entity.Retailer;

@SpringBootTest
public class RetailerDaoTest {

	@Autowired
	RetailerDao dao;

//	@Before
//	public void initializeDao() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//		dao = context.getBean(RetailerDao.class);
//	}

	
	
//	@Test
//	public void addDocTest() {
//		Retailer retailer=dao.serachRetailer(1003);
//		RetailerDocs retailerDocs = new RetailerDocs();
//		retailerDocs.setAddharCard("adhardoc");
//		retailerDocs.setPanCard("panDac");
//		retailerDocs.setRetailer(retailer);
//		
//		RetailerDocs rd= dao.addDocumentsForRetailer(retailerDocs);
//		assertNotNull(rd);
//	}
	
	@Test
	public void addRetailer() {
		Retailer r = new Retailer();
		r.setRetailerName("OPPO");
		r.setPassword("123");
		r.setEmail("oppin@gail.com");
		r.setPhoneNo("8765679875");
		r.setGstnNo("gstn9820");
		r.setApproved(false);
		
		if(dao.retailerExist(r.getEmail())){
			System.out.println("Email Id exist");
		}
		else {
		Retailer retailer = dao.addOrUpdate(r);
		assertNotNull(retailer);
			System.out.println("Signup successful");
		}
	}
	
	@Test
	public void loginTest() {
		Retailer r = dao.login(1010, "123");
		
		if(r==null) {
			System.out.println("Invalid credentials");
		}
		else {
			if(!r.isApproved()) {
				System.out.println("Account under verification");
			}
			else {
				System.out.println("Login successful");
			}
		}
	}
	
//	@Test
//	public void updateProfileTest() {
//		Retailer r = new Retailer();
//		r.setRetailerId(1006);
//		r.setRetailerName("OPPO");
//		r.setPassword("123");
//		r.setEmail("oppo1@gmail.com");
//		r.setPhoneNo("8765679875");
//		r.setGstnNo("gstn9820");
//		r.setApproved(false);
//		r.setRetailerdocs(r.getRetailerdocs());
//
//		Retailer retailer= dao.addOrUpdate(r);
//		assertNotNull(retailer);
//	}
//	
	@Test
	public void viewProfileTest() {
		Retailer r = dao.viewProfile(1025);
		System.out.println(r.toString());
	}
	
	

}
