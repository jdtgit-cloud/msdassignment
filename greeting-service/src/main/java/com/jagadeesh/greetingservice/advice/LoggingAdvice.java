package com.jagadeesh.greetingservice.advice;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Around(value = "execution(* com.jagadeesh.greetingservice.*.*.*(..))")
	public Object logMethodInOut(ProceedingJoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		String argStr = Stream.of(args).map(String::valueOf).collect(Collectors.joining(", "));
		LOGGER.info("{}.{}({}) invoked", className, methodName, argStr);
		Object response = joinPoint.proceed();
		LOGGER.info("{}.{}({}) response {}", className, methodName, argStr, response);
		return response;
	}
}
