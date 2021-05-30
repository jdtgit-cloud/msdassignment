package com.jagadeesh.greetmeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jagadeesh.greetmeservice.model.User;


@Service
public class GreetingMakerService {
	
	@Autowired
	private GreetingFetcherService greetingFetcherService;
	
	@Autowired
	private FormatNameService formatNameService;
	
	public String composeGreeting(User user) {
		String greeting = greetingFetcherService.fetchGreeting();
		String formattedName = formatNameService.format(user);
		return new StringBuilder(greeting).append(" ").append(formattedName).toString();
	}

}
