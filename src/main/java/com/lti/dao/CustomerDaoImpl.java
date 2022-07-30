package com.lti.dao;

import java.util.List;

import javax.mail.Address;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.UpdatePassword;
import com.lti.entity.Customer;
import com.lti.entity.CustomerAddress;
import com.lti.entity.Retailer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	EntityManager em;

	// Tested
	@Transactional
	public Customer addOrUpdateCustomer(Customer customer) {
		Customer customerPersisted = em.merge(customer);
		return customerPersisted;
	}

	// Tested
	public boolean customerLogin(String emailId, String password) {
		String jpql = "select a from Customer a where a.emailId=:email and a.password=:pwd";
		TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
		query.setParameter("email", emailId);
		query.setParameter("pwd", password);

		Customer customer = null;
		try {
			customer = query.getSingleResult();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean customerExist(String emailId) {
		String jpql = "select a from Customer a where a.emailId=:email";
		TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
		query.setParameter("email", emailId);
		List<Customer> c = query.getResultList();

		if (c.isEmpty())
			return false;
		else
			return true;
	}
	
	public Customer viewCustomerDetails(int customerID) {
		return em.find(Customer.class, customerID);
	}
	
	public Customer searchByCustomerId(int customerId) {
		return em.find(Customer.class, customerId);
	}
	
	@Transactional
	@Override
	public Boolean updatePassword(UpdatePassword up) {
		Customer c=searchByCustomerId(up.getId());
		if(up.getOldPassword().equals(c.getPassword())) {
			c.setPassword(up.getNewPassword());
			em.merge(c);
			return true;
		}
		return false;
	}
	
	// Tested
		public CustomerAddress searchByAddressId(int addressId) {
			return em.find(CustomerAddress.class, addressId);
		}
	
		@Transactional
		@Override
		public CustomerAddress addOrUpdateCustomerAddress(CustomerAddress address) {
			return em.merge(address);
		}


		
	@Transactional
	@Override
	public void removeAddressById(int addressId) {
		CustomerAddress a = searchByAddressId(addressId);
		em.remove(a);
	}

	@Transactional
	@Override
	public CustomerAddress updateAddress(CustomerAddress address) {
		
		return em.merge(address);
	}

	@Override
	public Customer viewCustomerDetails(String emailId) {
		// TODO Auto-generated method stub
		String jpql = "select a from Customer a where a.emailId=:email";
		TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
		query.setParameter("email", emailId);
		Customer c = query.getSingleResult();
		return c;
	}
	


	
	
}
