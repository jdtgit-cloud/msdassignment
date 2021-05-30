package com.jagadeesh.greetingservice.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingProviderService {
	
	public String fetch() {
		return "Hello";
	}
}
