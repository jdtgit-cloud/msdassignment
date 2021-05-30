package com.jagadeesh.nameformatservice.service;

import org.springframework.stereotype.Service;

import com.jagadeesh.nameformatservice.model.User;

@Service
public class NameFormatService {
	public String format(User user) {
		return new StringBuilder(user.getName()).append(" ").append(user.getSurname()).toString();
	}
}
