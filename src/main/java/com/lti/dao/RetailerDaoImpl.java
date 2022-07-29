package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Retailer;
import com.lti.entity.RetailerDocs;

@Repository
public class RetailerDaoImpl implements RetailerDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Retailer addOrUpdate(Retailer retailer) {
		Retailer retailerPersisted= em.merge(retailer);
		return retailerPersisted;
	}
	@Transactional
	public RetailerDocs addDocumentsForRetailer(RetailerDocs retailerDocs) {
		return em.merge(retailerDocs);
	}
	
	
	
	
	public Retailer login(int retailerId, String password) {
		
		String jpql="select a from Retailer a where a.retailerId=:rid and a.password=:pwd";
		TypedQuery<Retailer> query=em.createQuery(jpql,Retailer.class);
		query.setParameter("rid",retailerId);
		query.setParameter("pwd",password);
		
		Retailer retailer=null;
		try {
			retailer = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return retailer;
	}

	public boolean retailerExist(String email) {
		String jpql="select a from Retailer a where a.email=:email";
		TypedQuery<Retailer> query = em.createQuery(jpql, Retailer.class);
		query.setParameter("email", email);
		List<Retailer> r=query.getResultList();
		
		if(r.isEmpty()) 
			return false;
		else
			return true;
	}
	public Retailer viewProfile(int retailerId) {
		// TODO Auto-generated method stub
		return em.find(Retailer.class, retailerId);
	}
	
	
}
