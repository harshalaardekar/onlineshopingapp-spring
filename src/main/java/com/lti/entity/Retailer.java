package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_retailer")
public class Retailer {
	
	@Id
	@SequenceGenerator(name = "retailerseq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "retailerseq",strategy = GenerationType.SEQUENCE)
	int retailerId;
	String retailerName;
	String password;
	String email;
	String phoneNo;
	boolean isApproved;
	String GstnNo;
	
	@OneToOne(mappedBy = "retailer",cascade = CascadeType.ALL)
	RetailerDocs retailerdocs;
	
//	@OneToMany(mappedBy = "retailer" , cascade = CascadeType.ALL)
//	List<Product> products;
	
	public RetailerDocs getRetailerdocs() {
		return retailerdocs;
	}
	public void setRetailerdocs(RetailerDocs retailerdocs) {
		this.retailerdocs = retailerdocs;
	}
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public String getRetailerName() {
		return retailerName;
	}
	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public String getGstnNo() {
		return GstnNo;
	}
	public void setGstnNo(String gstnNo) {
		GstnNo = gstnNo;
	}
	@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", retailerName=" + retailerName + ", password=" + password
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", isApproved=" + isApproved + ", GstnNo=" + GstnNo
				+ "]";
	}
	

}
