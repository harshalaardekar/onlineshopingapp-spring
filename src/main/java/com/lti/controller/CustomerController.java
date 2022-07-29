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
import com.lti.dto.RemoveCustomerDto;
import com.lti.dto.UpdatePassword;
import com.lti.dto.ViewAddressesDto;
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

	@GetMapping("/viewProfile/{customerId}")
	public Customer viewProfile(@PathVariable int customerId) {
		return customerService.viewProfile(customerId);
	}
	
	@PutMapping(value = "/updatePass")
	public boolean updatePassword(@RequestBody UpdatePassword up) {
		return customerService.updatePassword(up);
	}
	
//	@RequestMapping(value = "/address", method = RequestMethod.POST)
//	public String customerAddAddress(@RequestBody CustomerAddress address) {
//		String message = customerService.customerAddAddress(address);
//		return message;
//	}
	
	@RequestMapping(value = "/removeaddr", method = RequestMethod.DELETE)
	public String removeCustomerAddress(@RequestBody RemoveCustomerDto removeData) {
		String message = customerService.removeCustomerAddress(removeData.getAddressId());
		return message;
	}
	
	@GetMapping("/viewall")
	public List<CustomerAddress> viewAllAddreses(@RequestBody ViewAddressesDto viewData){
		return customerService.viewAllAddreses(viewData.getAddressId());
	}

}
