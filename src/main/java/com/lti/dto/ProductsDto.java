package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductsDto {
	private int productId;
	private MultipartFile productImage;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
}