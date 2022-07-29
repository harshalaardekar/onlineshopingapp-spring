package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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

	// Tested
	@Transactional
	public CustomerAddress addOrUpdateCustomerAddress(CustomerAddress address,int customerId) {
		Customer customer = new Customer();
		customer= searchByCustomerId(customerId);
	
		CustomerAddress addressPersisted = em.merge(address);
		return addressPersisted;
	}

	// Tested
	public CustomerAddress searchByAddressId(int addressId) {
		return em.find(CustomerAddress.class, addressId);
	}

	@Transactional
	public String removeAddressById(int addressId) {
		CustomerAddress address = searchByAddressId(addressId);
		em.remove(address);
		String message = "Address deleted";
		return message;
	}

	// Tested
	public List<CustomerAddress> viewAllAddress() {
		return em.createQuery("select addr from CustomerAddress addr", CustomerAddress.class).getResultList();
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

	public Customer searchByCustomerId(int customerId) {
		return em.find(Customer.class, customerId);
	}

	@Override
	public List<CustomerAddress> fectchAllAddressesToWhichACustomerBelongs(int addressId) {
		CustomerAddress address;
		address = searchByAddressId(addressId);
		Customer customer = address.getCustomer();
		List<CustomerAddress> addresses = customer.getAddress();
		return addresses;
	}
	
}
