package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.Category;
import com.lti.entity.ProductType;
import com.lti.entity.Retailer;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	EntityManager em;

	
	@Transactional
	public Admin addOrUpdateAdmin(Admin admin) {
		Admin userPersisted = em.merge(admin);
		return userPersisted;
	}

	public boolean adminLogin(String username, String password) {

		String jpql = "select u from Admin u where u.username=:uid and u.password=:pwd";
		TypedQuery<Admin> query = em.createQuery(jpql, Admin.class);
		query.setParameter("uid", username);
		query.setParameter("pwd", password);

		Admin admin = null;
		try {
			admin = query.getSingleResult();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Retailer serachRetailer(int retailerId) {
		return em.find(Retailer.class,retailerId);
	}

	public List<Retailer> approvedRetailers() {
		String jpql="select a from Retailer a where a.isApproved=:val";
		TypedQuery<Retailer> query=em.createQuery(jpql, Retailer.class);
		query.setParameter("val", true);
		List<Retailer> rdata = query.getResultList();
		return rdata;
	}

	public List<Retailer> nonApprovedRetailers() {
		String jpql="select a from Retailer a where a.isApproved=:val";
		TypedQuery<Retailer> query=em.createQuery(jpql, Retailer.class);
		query.setParameter("val", false);
		List<Retailer> rdata = query.getResultList();
		return rdata;
	}

	public Retailer viewRetailerDetails(int retailerId) {
		return em.find(Retailer.class, retailerId);
	}
	
	@Transactional
	public Retailer approveReailer(Retailer retailer) {
		return em.merge(retailer);
	}

	public Retailer searchRetailer(int retailerId) {
		return em.find(Retailer.class, retailerId);
	}

	@Transactional
	public void removeRetailer(int retailerId) {
		Retailer retailer = em.find(Retailer.class,retailerId);
		em.remove(retailer);
	}

	@Transactional
	public Category addOrUpdateCategory(Category category) {
		return em.merge(category);
	}

	@Transactional
	public void removeCategory(int categoryId) {
		Category c=findCategory(categoryId);
		em.remove(c);
		
	}

	public Category findCategory(int categoryId) {
		return em.find(Category.class, categoryId);
	}
	@Transactional
	public ProductType addOrUpdateProductType(ProductType productType) {
		return em.merge(productType);
	}

	@Transactional
	public void revoveProductType(ProductType productType) {
		ProductType p=em.find(ProductType.class, productType);
		em.remove(p);
	}

	

	public ProductType findProducttype(int ptypeId) {
		// TODO Auto-generated method stub
		return em.find(ProductType.class, ptypeId);
	}
	
	public List<Admin> viewadmins() {
		String jpql="select a from Admin a";
		TypedQuery<Admin> query=em.createQuery(jpql, Admin.class);
		List<Admin> rdata = query.getResultList();
		return rdata;
	}

	public List<Category> viewAllCategories() {
		String jpql="select c from Category c";
		TypedQuery<Category> query=em.createQuery(jpql,Category.class);
		List<Category> data = query.getResultList();
		return data;
	}

	public List<ProductType> viewPtypeByCategory(int categoryId) {
		String jpql="select c from ProductType c where c.categoryId=:cid";
		TypedQuery<ProductType> query=em.createQuery(jpql,ProductType.class);
		query.setParameter("cid", categoryId);
		List<ProductType> data = query.getResultList();
		return data;
	}
	
}
