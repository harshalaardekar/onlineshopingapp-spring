package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Product;


@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Product addOrUpdateProduct(Product product) {
		Product productPersisted = em.merge(product);
		return productPersisted;
	}

	@Override
	public Product searchProductById(int productId) {
		return em.find(Product.class, productId);
	}

	public List<Product> viewAllProducts() {
		String jpql = "select p from Product p";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		return query.getResultList();
	}

}
