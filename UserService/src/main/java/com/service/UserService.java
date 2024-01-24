package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	
	//create user
	User saveUser(User user);
	
	//get all users
	List<User> getAllUsers();
	
	//get user by id
    User getByUserId(String userId);

}
