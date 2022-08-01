package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@SequenceGenerator(name = "category_seq", initialValue = 101, allocationSize = 1)
	@GeneratedValue(generator = "category_seq", strategy = GenerationType.SEQUENCE)
	int categoryId;
	String categoryName;
	

//	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//	List<ProductType> productType;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


//	public List<ProductType> getProductType() {
//		return productType;
//	}
//
//	public void setProductType(List<ProductType> productType) {
//		this.productType = productType;
//	}
	
	
}
