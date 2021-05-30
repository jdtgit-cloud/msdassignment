package com.jagadeesh.greetingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagadeesh.greetingservice.service.GreetingProviderService;

@RestController
@RequestMapping("/greeting")
public class GreetingServiceController {
	@Autowired
	private GreetingProviderService greetingService;
	
	@GetMapping("/fetch")
	public String fetch() {
		return greetingService.fetch();
	}
}
