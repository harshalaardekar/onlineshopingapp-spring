package com.lti.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

@SpringBootTest
class CustomerTest {

	@Autowired
	CustomerDao dao;
	
	@Test
	public void viewCustomerTest() {
		Customer c = dao.viewCustomerDetails(1001);
		assertNotNull(c);
		System.out.println(c.getEmailId());
	}
}
