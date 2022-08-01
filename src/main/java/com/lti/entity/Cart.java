package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_cart")
public class Cart {
	
	@Id
	@SequenceGenerator(name = "c_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "c_seq", strategy = GenerationType.SEQUENCE)
	int cartId;
	
	@OneToOne
	@JoinColumn(name="customerId")
	Customer customer;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	List<CartItems> cartitems;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItems> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<CartItems> cartitems) {
		this.cartitems = cartitems;
	}
	
	

	
	
}
