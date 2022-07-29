package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="retailerdocs")
public class RetailerDocs {
	
	@Id
	@SequenceGenerator(name="doc_seq",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "doc_seq",strategy = GenerationType.SEQUENCE)
	int docId;
	
	String addharCard;
	String panCard;

	@OneToOne
	@JoinColumn(name="retailerId")
	Retailer retailer;

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

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

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	@Override
	public String toString() {
		return "RetailerDocs [docId=" + docId + ", addharCard=" + addharCard + ", panCard=" + panCard + ", retailer="
				+ retailer + "]";
	}
	
	
}
