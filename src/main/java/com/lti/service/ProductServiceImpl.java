package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ProductDao;
import com.lti.dao.RetailerDao;
import com.lti.dto.UpdateProduct;
import com.lti.dto.UpdateRetailer;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.exception.UserIdMissingException;
import com.lti.exception.UserNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	RetailerDao retailerDao;

	@Override
	public boolean addProduct(Product product) {
		try {
//			Retailer r =product.getRetailer();
//			Retailer retailer = retailerDao.searchRetailerById(r.getRetailerId());
//			product.setRetailer(retailer);
			Product product2 = productDao.addOrUpdateProduct(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Product findProduct(int productId) {
		return productDao.searchProductById(productId);
	}

	public List<Product> viewAllProducts() {

		return productDao.viewAllProducts();
	}

	public UpdateProduct updateProfile(Product product) {
		UpdateProduct updateProduct = new UpdateProduct();
		try {
			if (product.getProductId() == 0) {
				throw new UserIdMissingException("Please mention your product id.");
			} else if (productDao.searchProductById(product.getProductId()) == null) {
				throw new UserNotFoundException("Product not found.");
			} else {
				Product product2 = productDao.addOrUpdateProduct(product);
//                return "User ID: " + user2.getUserId() + "\nUser Name: " + user2.getUserName() + "\nEmail: "
//                        + user2.getEmail();
				updateProduct.setMessage("Product updated.");
				updateProduct.setProduct(product);
				return updateProduct;
			}
		} catch (Exception e) {
			updateProduct.setMessage(e.getMessage());
			return updateProduct;
		}
	}

}
