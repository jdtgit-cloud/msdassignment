package com.jagadeesh.greetmeservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagadeesh.greetmeservice.model.GreetResult;
import com.jagadeesh.greetmeservice.model.User;
import com.jagadeesh.greetmeservice.service.GreetingMakerService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/greetme")
public class GreetMeController {
	private static final String HEALTH = "Up";
	
	@Autowired
	private GreetingMakerService greetingMakerService;
	
	@GetMapping("/health")
	@ApiOperation(value = "Indicates the service availability. Up if available",
		response = String.class)
	public String health() {
		return HEALTH;
	}
	
	@PostMapping("/greet")
	@ApiOperation(value = "Greets the given user with composed and formatted message",
		notes ="Provide the user name, surname for successful processing",
		response = GreetResult.class
		)
	public GreetResult greet(@Valid @RequestBody User user) {
		return new GreetResult( greetingMakerService.composeGreeting(user) );
	}
}
