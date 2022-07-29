package com.lti;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;


@SpringBootTest
class OnlineShoppingAppApplicationTests {

	
//	@Autowired
//	CustomerDao dao;
//	
//	@Test
//	public void viewCustomerTest() {
//		Customer c = dao.viewCustomerDetails(1000);
//		assertNotNull(c);
//		System.out.println(c.getEmailId());
//	}

}
