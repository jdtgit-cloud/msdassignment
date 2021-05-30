package com.jagadeesh.greetmeservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GreetMeExceptionControllerAdvice {
	
	@ExceptionHandler(value=HttpMessageNotReadableException.class)
	public ResponseEntity<Object> exception(HttpMessageNotReadableException ex){
		return new ResponseEntity<>("Required Input is not available in the request", HttpStatus.BAD_REQUEST);
	}
}
