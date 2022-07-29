package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer")
public class Customer {
	@Id
	@SequenceGenerator(name = "customer_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "customer_seq", strategy = GenerationType.SEQUENCE)
 	int customerId;
	String customerName;
	String emailId;
	String password;
	String phoneNo;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch= FetchType.EAGER)
	List<CustomerAddress> address;
	
//	@OneToOne(mappedBy = "customer")
//	Cart cart;
//	
//	@OneToOne(mappedBy = "customer")
//	Wishlist wishlist;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<CustomerAddress> getAddress() {
		return address;
	}

	public void setAddress(List<CustomerAddress> address) {
		this.address = address;
	}

//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
//
//	public Wishlist getWishlist() {
//		return wishlist;
//	}
//
//	public void setWishlist(Wishlist wishlist) {
//		this.wishlist = wishlist;
//	}
//	
	
	
}
