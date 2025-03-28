package com.devrishi.todo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.devrishi.todo.controller.*.*(..))")
	public void logBefore(JoinPoint jp) {
		System.out.println("before the controller going into "+jp.getSignature());;
	}
	
	@After("execution(* com.devrishi.todo.controller.*.*(..))")
	public void logAfter() {
		System.out.println("after logging");
	}
}
