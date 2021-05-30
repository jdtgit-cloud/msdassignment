package com.jagadeesh.greetmeservice.advice;

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
	
	@Around(value="execution(* com.jagadeesh.greetmeservice.*.*.*(..))")
	public Object methodInOutLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("AOP invoked :: " + joinPoint);
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getName();
		String args = "";
		if(joinPoint.getArgs()!=null && joinPoint.getArgs().length!=0) {
			args = Stream.of(joinPoint.getArgs()).map(String::valueOf).collect(joining(", "));
		}
		LOGGER.info("{}.{}({}) invoked", className, methodName, args);
		Object response = joinPoint.proceed();
		LOGGER.info("{}.{}({}) response {}", className, methodName, args, response);
		return response;
	}
}
