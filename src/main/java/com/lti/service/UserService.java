package com.lti.service;

import java.util.List;

import com.lti.dto.UpdateUser;
import com.lti.entity.User;

public interface UserService {
	String signup(User user);
	
	UpdateUser updateProfile(User user);

	User findUser(int userId);

	List<User> viewAllUsers();

	boolean userLogin(int userId, String password);
	
	String getUserName(int userId);
}
