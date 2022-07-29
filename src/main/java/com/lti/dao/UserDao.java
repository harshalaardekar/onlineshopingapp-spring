package com.lti.dao;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.User;

public interface UserDao {
	User addOrUpdateUser(User user);
	User searchUserById(int userId);
	boolean login(int userId,String password);
	List<User> viewAllUsers();
	
	Admin addOrUpdateAdmin(Admin admin);
	 boolean adminLogin(String username, String password);
	 Admin searchAdminById(String userId);
	List<Admin> viewAllAdmins();
}
