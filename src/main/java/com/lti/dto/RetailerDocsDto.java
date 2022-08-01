package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class RetailerDocsDto {
	private int retailerId;
	private MultipartFile addharCard;
	private MultipartFile panCard;
	private MultipartFile retailerCertificate;
	
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public MultipartFile getAddharCard() {
		return addharCard;
	}
	public void setAddharCard(MultipartFile addharCard) {
		this.addharCard = addharCard;
	}
	public MultipartFile getPanCard() {
		return panCard;
	}
	public void setPanCard(MultipartFile panCard) {
		this.panCard = panCard;
	}
	public MultipartFile getRetailerCertificate() {
		return retailerCertificate;
	}
	public void setRetailerCertificate(MultipartFile retailerCertificate) {
		this.retailerCertificate = retailerCertificate;
	}
	
	
}
