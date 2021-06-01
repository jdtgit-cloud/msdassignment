package com.jagadeesh.greetmeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jagadeesh.greetmeservice.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class FormatNameService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${name-format-service}")
	private String nameFormatService;
	
	@HystrixCommand(fallbackMethod = "fallbackFormat")
	public String format(User user) {
		ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://"+nameFormatService+"/api/format/", user, String.class);
		if(responseEntity.getStatusCode()!=HttpStatus.OK) {
			//throw an exception for fallback
			throw new RuntimeException();
		}
		return responseEntity.getBody();
	}
	
	@SuppressWarnings("unused")
	private String fallbackFormat(User user) {
		return user.getName() + user.getSurname();
	}
}
