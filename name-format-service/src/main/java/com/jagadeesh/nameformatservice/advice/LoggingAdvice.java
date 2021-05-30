package com.jagadeesh.nameformatservice.advice;

import static java.util.stream.Collectors.joining;

import java.util.stream.Stream;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Around(value="execution(* com.jagadeesh.nameformatservice.*.*.*(..))")
	public Object methodInOutLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getName();
		LOGGER.info("{}.{}({}) invoked", className, methodName, Stream.of(joinPoint.getArgs()).map(String::valueOf).collect(joining(", ")));
		Object response = joinPoint.proceed();
		LOGGER.info("{}.{}({}) response {}", className, methodName, Stream.of(joinPoint.getArgs()).map(String::valueOf).collect(joining(", ")), response);
		return response;
	}
}
