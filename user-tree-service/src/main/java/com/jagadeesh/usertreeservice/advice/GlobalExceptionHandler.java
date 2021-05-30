package com.jagadeesh.usertreeservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jagadeesh.usertreeservice.service.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<String> exception(UserNotFoundException unfe) {
		return new ResponseEntity<String>("User does not exist with the supplied userId", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> exception(Exception e){
		return new ResponseEntity<String>("We are fixing it. Please retry in sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
