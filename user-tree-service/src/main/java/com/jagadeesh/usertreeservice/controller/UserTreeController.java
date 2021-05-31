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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tree")
public class UserTreeController {
	
	@Autowired
	private UserTreeService service;
	
	@GetMapping("/fetch/{userId}")
	@LogMethodParam
	@ApiOperation(value = "Fetches the user details by userId",
	response = UserDetails.class)
	public UserDetails fetchUserDetails(@PathVariable int userId) throws UserNotFoundException {
		return service.fetchUserDetails(userId);
	}
	
	@GetMapping("/fetchall")
	@ApiOperation(value = "Fetches the realationship among all the users")
	public List<UserNest> fetchAll() {
		return service.fetchUserNest();
	}
}
