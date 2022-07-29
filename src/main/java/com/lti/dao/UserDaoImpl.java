package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.User;

//@Component
@Repository
public class UserDaoImpl implements UserDao {

//	EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
//	EntityTransaction tx;
	
	@Transactional
	public User addOrUpdateUser(User user) {

		User userPersisted = em.merge(user);
		return userPersisted;
	}

	public User searchUserById(int userId) {
		return em.find(User.class, userId);
	}

	public List<User> viewAllUsers() {
		String jpql ="select u from User u";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		return query.getResultList();
	}

	public boolean login(int userId, String password) {
		String jpql = "select u from User u where u.userId=:uid and u.password=:pwd";
		TypedQuery<User> query=em.createQuery(jpql, User.class);
		query.setParameter("uid",userId);
		query.setParameter("pwd", password);
		
		User user = query.getSingleResult();
		return user!=null?true:false;
	}

	@Transactional
	public Admin addOrUpdateAdmin(Admin admin) {

		Admin userPersisted = em.merge(admin);
		return userPersisted;
	}
public boolean adminLogin(String username, String password) {
		
	String jpql = "select u from Admin u where u.username=:uid and u.password=:pwd";
	TypedQuery<Admin> query=em.createQuery(jpql, Admin.class);
	query.setParameter("uid",username);
	query.setParameter("pwd", password);
	
	Admin user = query.getSingleResult();
	return user!=null?true:false;

	}

public Admin searchAdminById(String userId) {
	// TODO Auto-generated method stub
	return em.find(Admin.class, userId);
}

public List<Admin> viewAllAdmins() {
	String jpql ="select u from Admin u";
	TypedQuery<Admin> query = em.createQuery(jpql,Admin.class);
	return query.getResultList();
}
}
