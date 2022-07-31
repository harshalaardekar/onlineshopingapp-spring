package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CustomerLoginDto;
import com.lti.dto.UpdatePassword;
import com.lti.dto.addAddressDto;
import com.lti.entity.Customer;
import com.lti.entity.CustomerAddress;
import com.lti.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public boolean customerSignup(@RequestBody Customer customer) {
		boolean message = customerService.customerSignup(customer);
		return message;
	}

	@PostMapping("/login")
	public boolean login(@RequestBody CustomerLoginDto loginData) {
		boolean res = customerService.customerLogin(loginData.getEmailId(), loginData.getPassword());
		return res;
	}

//	@GetMapping("/viewProfile/{customerId}")
//	public Customer viewProfile(@PathVariable int customerId) {
//		return customerService.viewProfile(customerId);
//	}
//	
	@GetMapping("/viewProfileDetails/{emailID}")
	public Customer viewProfileDetails(@PathVariable String emailID) {
		return customerService.viewDetails(emailID);
	}
	
	@PutMapping(value = "/updatePass")
	public boolean updatePassword(@RequestBody UpdatePassword up) {
		return customerService.updatePassword(up);
	}
	
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public boolean addAddress(@RequestBody addAddressDto address) {
		boolean res = customerService.customerAddAddress(address);
		return res;
	}
	
	@PutMapping(value = "/updateAddress")
	public boolean updateAddress(@RequestBody CustomerAddress address) {
		return customerService.updateAddress(address);
	}
	
	@GetMapping("/viewallAddress/{customerId}")
	public List<CustomerAddress> viewAddress(@PathVariable int customerId){
		return customerService.viewAllAddreses(customerId);
	}
	
//	@GetMapping("/removeAddress/{addressId}")
//	public boolean removeAddress(@PathVariable int addressId){
//		return customerService.removeCustomerAddress(addressId);
//	}
	
	
	@RequestMapping(value = "/removeAddr/{addressId}", method = RequestMethod.DELETE)
	public boolean removeCustomerAddress(@PathVariable int addressId) {
		boolean res = customerService.removeCustomerAddress(addressId);
		return res;
	}
	
//	@GetMapping(value = "/removeAddr/{addressId}")
//	public boolean removeCustomerAddress(@PathVariable int addressId) {
//		boolean res = customerService.removeCustomerAddress(addressId);
//		return res;
//	}
//

}
