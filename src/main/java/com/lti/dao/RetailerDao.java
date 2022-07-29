package com.lti.dao;

import com.lti.entity.Retailer;
import com.lti.entity.RetailerDocs;

public interface RetailerDao {
	
	Retailer addOrUpdate(Retailer retailer);
	RetailerDocs addDocumentsForRetailer(RetailerDocs retailerDocs);
	Retailer viewProfile(int retailerId);
	
	Retailer login(int retailerId , String password);
	boolean retailerExist(String email);
	
	
}
