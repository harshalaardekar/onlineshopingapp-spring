package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producttype")
public class ProductType {
	
	@Id
	@SequenceGenerator(name = "producttype_seq", initialValue = 501, allocationSize = 1)
	@GeneratedValue(generator = "producttype_seq", strategy = GenerationType.SEQUENCE)
	int productTypeId;

	String productTypeName;
	int categoryId;

//	@ManyToOne
//	@JoinColumn(name = "categoryId")
//	Category category;

//	@OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
//	List<Product> products;

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}

	
	
}
