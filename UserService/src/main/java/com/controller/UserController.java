package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//create user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	//getAll users
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok().body(userService.getAllUsers());
		
	}
	
	//get user by id
	@GetMapping("/{userId}")
	public ResponseEntity<User> getByUserId(@PathVariable("userId") String usserId){
		User user = userService.getByUserId(usserId);
		return ResponseEntity.ok().body(user);
	}

}
