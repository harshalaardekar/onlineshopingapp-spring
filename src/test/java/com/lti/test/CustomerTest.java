package com.lti.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;
import com.lti.entity.CustomerAddress;

@SpringBootTest
class CustomerTest {

	@Autowired
	CustomerDao dao;
	
	
	@Test
	public void addOrUpdateCustomerTest() {
		Customer customer = new Customer();
		customer.setCustomerName("Vikrant");
		customer.setEmailId("vik@gmail.com");
		customer.setPassword("vik123");
		customer.setPhoneNo("7894561235");
		Customer savedCustomer = dao.addOrUpdateCustomer(customer);
		assertNotNull(savedCustomer);
	}
	
	@Test
	public void customerLogin() {
		Boolean loginResult = dao.customerLogin("vik@gmail.com", "vik123");
		if(loginResult!=true) {
			System.out.println("Invalid Credentials");
		}
		else {
			System.out.println("Login Sucessful");
		}
	}
	
	@Test
	public void viewProfile() {
		Customer c = dao.viewCustomerDetails("harshalaardekar101@gmail.com");
		assertNotNull(c);
		System.out.println(c.getCustomerId());
	}
	
	@Test 
	public void addCustomerAddressTest() {
		Customer c=dao.searchByCustomerId(1000);
		assertNotNull(c);
		CustomerAddress address = new CustomerAddress();
		address.setHouseNo("302");
		address.setStreet("Geet Sonali");
		address.setCity("Koparkhairne");
		address.setState("Maharashtra");
		address.setPinCode("400703");
		address.setCountry("India");
		address.setCustomer(c);
		
//		System.out.println(address.getCustomer().getPassword());
		CustomerAddress savedAddress = dao.addOrUpdateCustomerAddress(address);
//		assertNotNull(savedAddress);
	}
	
	@Test
	public void searchCustomerById() {
		Customer c = dao.searchByCustomerId(1000);
		assertNotNull(c);
		System.out.println(c.getCustomerId());
	}
	@Test
	public void searchByAddressIdTest() {
		CustomerAddress address = dao.searchByAddressId(50);
		assertNotNull(address);
	}
	
	@Test
	public void viewAllAddressesOfCustomer() {
		Customer c= dao.searchByCustomerId(1001);
		assertNotNull(c);
		
		List<CustomerAddress> addresses=c.getAddress();
		addresses.stream().forEach(addr -> {
			System.out.println(addr.getHouseNo()+" "+addr.getStreet()+" "+addr.getCustomer().getCustomerId());
		});
	}
	
	@Test 
	public void updateCustomerAddressTest() {
		CustomerAddress ca=dao.searchByAddressId(50);
		assertNotNull(ca);
//		CustomerAddress address = new CustomerAddress();
		ca.setAddressId(502);
		ca.setHouseNo("302");
		ca.setStreet("Geet");
		ca.setCity("Koparkhairne");
		ca.setState("Maharashtra");
		ca.setPinCode("400703");
		ca.setCountry("India");
		
//		System.out.println(address.getCustomer().getPassword());
		CustomerAddress savedAddress = dao.addOrUpdateCustomerAddress(ca);
		assertNotNull(savedAddress);
	}
	
	@Test
	public void removeAnAddress() {
		dao.removeAddressById(506);
	}
	
	
}
