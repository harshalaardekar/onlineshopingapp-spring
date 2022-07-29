package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.dto.UpdateUser;
import com.lti.entity.User;
import com.lti.exception.UserIdMissingException;
import com.lti.exception.UserNotFoundException;

//@Component
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public String signup(User user) {
		// validate user object data
		try {
			User user2 = userDao.addOrUpdateUser(user);
			return "Sign up successful. Your userid is:" + user2.getUserId();
		} catch (Exception e) {
			return "Unexpected error occured. Signup failed";
		}
	}

	public UpdateUser updateProfile(User user) {
		UpdateUser updateUser = new UpdateUser();
		try {
			if(user.getUserId()==0) {
				throw new UserIdMissingException("Please mention your userId");
			}
			else if(userDao.searchUserById(user.getUserId())==null) {
				throw new UserNotFoundException("User not found");
			}
			else {
			User user2 = userDao.addOrUpdateUser(user);
//			return "User ID : "+user2.getUserId()+"\nUser Name : "+user2.getUserName()+"\nEmail : "+user2.getEmail();
			updateUser.setMessage("Profile Updated");
			updateUser.setUser(user2);
			return updateUser;
			}
		} catch (Exception e) {
			updateUser.setMessage(e.getMessage());
			return updateUser;
		}
	}

	public User findUser(int userId) {
//		User user2 = userDao.searchUserById(userId);
//		try {
//		if(user2 == null) {
//			throw new UserNotFoundException("User not found");
//		}
//		else {
//			return "User ID : "+user2.getUserId()+"\nUser Name : "+user2.getUserName()+"\nEmail : "+user2.getEmail();
//		}
//		}catch (Exception e) {
//			return e.getMessage();
//		}
		return  userDao.searchUserById(userId);
	}

	public List<User> viewAllUsers() {

		return userDao.viewAllUsers();
	}

	public boolean userLogin(int userId, String password) {

		return userDao.login(userId, password);
	}

	public String getUserName(int userId) {

		return null;
	}


}
