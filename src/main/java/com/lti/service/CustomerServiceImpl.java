package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.dto.UpdatePassword;
import com.lti.dto.addAddressDto;
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

	@Override
	public boolean customerAddAddress(addAddressDto a) {
		 try {
			Customer c = custDao.searchByCustomerId(a.getCustomerId()); 
			if(c!=null) {
			CustomerAddress a1 = new CustomerAddress();
			a1.setHouseNo(a.getHouseNo());
			a1.setStreet(a.getStreet());
			a1.setCity(a.getCity());
			a1.setCountry(a.getCountry());
			a1.setPinCode(a.getPinCode());
			a1.setState(a.getState());
			a1.setCustomer(c);
			
			custDao.addOrUpdateCustomerAddress(a1);
			
			return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	@Override
	public boolean updateAddress(CustomerAddress address) {
		// TODO Auto-generated method stub
		CustomerAddress a = custDao.addOrUpdateCustomerAddress(address);
		if(a!=null)
			return true;
		else
			return false;
	}

	@Override
	public List<CustomerAddress> viewAllAddreses(int customerId) {
		Customer c = custDao.searchByCustomerId(customerId);
		return c.getAddress();
	}

	@Override
	public boolean removeCustomerAddress(int addressId) {
		try {
			custDao.removeAddressById(addressId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	

	@Override
	public Customer viewDetails(String emailId) {
		// TODO Auto-generated method stub
		return custDao.viewCustomerDetails(emailId);
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
//	public String removeCustomerAddress(int addressId) {
//		String message;
//		try {
//			 message = custDao.removeAddressById(addressId);
//			return message;
//		} catch (Exception e) {
//			return message ="Unexpected error occured. Removal of address failed";
//		}
//	}
//
//	@Override
//	public List<CustomerAddress> viewAllAddreses(int addressId) {
//		return custDao.fectchAllAddressesToWhichACustomerBelongs(addressId);
//	}

	

	

}
