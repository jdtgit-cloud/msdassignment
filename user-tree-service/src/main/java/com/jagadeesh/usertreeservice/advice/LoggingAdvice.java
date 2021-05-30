package com.jagadeesh.usertreeservice.advice;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Before(value = "@annotation(com.jagadeesh.usertreeservice.advice.LogMethodParam)")
	public void logMethodIn(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		String args = Stream.of(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", "));
		LOGGER.info("{}.{}({}) invoked", className, methodName, args);
	}
}
