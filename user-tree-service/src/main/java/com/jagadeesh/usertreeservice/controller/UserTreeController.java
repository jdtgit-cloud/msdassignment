package com.jagadeesh.usertreeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagadeesh.usertreeservice.advice.LogMethodParam;
import com.jagadeesh.usertreeservice.data.UserDetails;
import com.jagadeesh.usertreeservice.data.UserNest;
import com.jagadeesh.usertreeservice.service.UserNotFoundException;
import com.jagadeesh.usertreeservice.service.UserTreeService;

@RestController
@RequestMapping("/tree")
public class UserTreeController {
	
	@Autowired
	private UserTreeService service;
	
	@GetMapping("/fetch/{userId}")
	@LogMethodParam
	public UserDetails fetchUserDetails(@PathVariable int userId) throws UserNotFoundException {
		return service.fetchUserDetails(userId);
	}
	
	@GetMapping("/fetchall")
	public List<UserNest> fetchAll() {
		return service.fetchUserNest();
	}
}
