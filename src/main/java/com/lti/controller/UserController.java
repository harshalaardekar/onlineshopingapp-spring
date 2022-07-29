package com.lti.controller;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RetailerLoginDto;
import com.lti.dto.UpdateUser;
import com.lti.entity.User;
import com.lti.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
//	http://localhost:8181/UserManagementRestWebApp/myapp/users/signup
	@RequestMapping(value="/signup" , method=RequestMethod.POST)
	public String signup(@RequestBody User user) {
		String message=userService.signup(user);
		return message;
	}
	
	@PutMapping("/update")
	public UpdateUser updateProfile(@RequestBody User user) {
		return userService.updateProfile(user);
	}
	
//	@GetMapping("/user/{userId}")
	@GetMapping(value = "/user/{userId}",produces = MediaType.APPLICATION_XML_VALUE)
	public User searchUser(@PathVariable int userId) {
		return userService.findUser(userId);
	}
	
	@GetMapping("/viewall")
	public List<User> viewAllUsers(){
		return userService.viewAllUsers();
	}
	
	@PostMapping("/login")
	public String login(@RequestBody RetailerLoginDto loginData) {
		boolean res = userService.userLogin(loginData.getId(), loginData.getPassword());
		
		return res?"Login successful":"User Id or Password is incorrect";
	}
}