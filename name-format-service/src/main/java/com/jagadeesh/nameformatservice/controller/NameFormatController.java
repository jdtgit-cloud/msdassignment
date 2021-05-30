package com.jagadeesh.nameformatservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagadeesh.nameformatservice.model.User;
import com.jagadeesh.nameformatservice.service.NameFormatService;

@RestController
@RequestMapping("/api")
public class NameFormatController {

	@Autowired
	private NameFormatService nameFormatService;
	
	@PostMapping("/format")
	public String format(@Valid @RequestBody User user) {
		return nameFormatService.format(user);
	}
}
