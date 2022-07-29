package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.dto.UpdatePassword;
import com.lti.entity.Customer;
import com.lti.entity.CustomerAddress;
import com.lti.exception.CustomerIdMissingException;
import com.lti.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao custDao;

	@Override
	public boolean customerLogin(String emailId, String password) {
		boolean success = custDao.customerLogin(emailId, password);
		if (success != true) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean customerSignup(Customer customer) {
		if (custDao.customerExist(customer.getEmailId())) {
			return false;
		} else {
			try {
				Customer customer2 = custDao.addOrUpdateCustomer(customer);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	@Override
	public Customer viewProfile(int customerId) {
		return custDao.viewCustomerDetails(customerId);
	}
	
	@Override
	public boolean updatePassword(UpdatePassword up) {
		// TODO Auto-generated method stub
		return custDao.updatePassword(up);
	}
	
//	@Override
//	public UpdatePassword updateCustomerProfile(Customer customer) {
//		UpdatePassword updateCustomer = new UpdatePassword();
//		try {
//			if (customer.getCustomerId() == 0) {
//				throw new CustomerIdMissingException("Please mention your customer id");
//			} else if (custDao.searchByCustomerId(customer.getCustomerId()) == null) {
//				throw new CustomerNotFoundException("Customer not found");
//			} else {
//				Customer customer2 = custDao.addOrUpdateCustomer(customer);
//				// "User Id: "+user2.getUserId()+"\n User Name"+
//				// user2.getUserName()+"\nEmail"+user2.getEmail();
//				updateCustomer.setMessage("Profile updated");
//				updateCustomer.setUser(customer2);
//				return updateCustomer;
//			}
//		} catch (Exception e) {
//			updateCustomer.setMessage(e.getMessage());
//			return updateCustomer;
//		}
//	}

//	@Override
//	public String customerAddAddress(CustomerAddress address) {
//		Customer customer = new Customer();
//		try {
//			custDao.addOrUpdateCustomerAddress(address);
//			return "Address added successfully.";
//		} catch (Exception e) {
//			return "Unexpected error occured. Address adding failed";
//		}
//	}

	@Override
	public String removeCustomerAddress(int addressId) {
		String message;
		try {
			 message = custDao.removeAddressById(addressId);
			return message;
		} catch (Exception e) {
			return message ="Unexpected error occured. Removal of address failed";
		}
	}

	@Override
	public List<CustomerAddress> viewAllAddreses(int addressId) {
		return custDao.fectchAllAddressesToWhichACustomerBelongs(addressId);
	}

	

	

}
