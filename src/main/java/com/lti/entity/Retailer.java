package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_retailer")
public class Retailer {

    @Id
    @SequenceGenerator(name = "r_seq",initialValue = 1001,allocationSize = 1)
    @GeneratedValue(generator = "r_seq",strategy = GenerationType.SEQUENCE)
    int retailerId;
    String retailerName;
    String password;
    String email;
    String phoneNo;
    boolean isApproved;
    String gstnNo;
    String addharCard;
    String panCard;
    String retailerCertificate;


    @OneToMany(mappedBy = "retailer" , cascade = CascadeType.ALL)
    List<Product> products;


    public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
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
    
    
    
    
    
@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", retailerName=" + retailerName + ", password=" + password
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", isApproved=" + isApproved + ", gstnNo=" + gstnNo
				+ ", addharCard=" + addharCard + ", panCard=" + panCard + ", retailerCertificate=" + retailerCertificate
				+ "]";
	}
public String getGstnNo() {
		return gstnNo;
	}
	public void setGstnNo(String gstnNo) {
		this.gstnNo = gstnNo;
	}
	//    public String getGstnNo() {
//        return GstnNo;
//    }
//    public void setGstnNo(String gstnNo) {
//        GstnNo = gstnNo;
//    }
//    @Override
//    public String toString() {
//        return "Retailer [retailerId=" + retailerId + ", retailerName=" + retailerName + ", password=" + password
//                + ", email=" + email + ", phoneNo=" + phoneNo + ", isApproved=" + isApproved + ", GstnNo=" + GstnNo
//                + "]";
//    }
    public String getAddharCard() {
        return addharCard;
    }
    public void setAddharCard(String addharCard) {
        this.addharCard = addharCard;
    }
    public String getPanCard() {
        return panCard;
    }
    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }
    public String getRetailerCertificate() {
        return retailerCertificate;
    }
    public void setRetailerCertificate(String retailerCertificate) {
        this.retailerCertificate = retailerCertificate;
    }

}