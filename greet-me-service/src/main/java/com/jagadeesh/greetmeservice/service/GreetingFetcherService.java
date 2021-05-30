package com.jagadeesh.greetmeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GreetingFetcherService {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallbackFetchGreeting")
	public String fetchGreeting() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://greeting-service/greeting/fetch", String.class);
		if(responseEntity.getStatusCode()!=HttpStatus.OK) {
			//throw an exception for fallback
			throw new RuntimeException();
		}
		return responseEntity.getBody();
	}
	
	@SuppressWarnings("unused")
	private String fallbackFetchGreeting() {
		return "Fallback Greeting";
	}
}
