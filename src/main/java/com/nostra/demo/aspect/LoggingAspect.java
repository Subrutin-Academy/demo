package com.nostra.demo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.google.common.base.Stopwatch;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

	// pointcut
	@Pointcut("execution(* com.nostra.demo.web.*.*(..))")
	private void webPointcut() {
	}

	// advice
	@Around("webPointcut()")
	public Object executionTimeLogging(ProceedingJoinPoint jointPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		try {
			log.info("************* start execution method {} {} *************************",
					jointPoint.getTarget().getClass().getName(), jointPoint.getSignature().getName());
			stopWatch.start();

			return jointPoint.proceed();
		} finally {
			stopWatch.stop();
			log.info("************* finish execution method {} {}. execution time {} ms  *************************",
					jointPoint.getTarget().getClass().getName(), jointPoint.getSignature().getName()
					, stopWatch.getTotalTimeMillis());
		}

	}
	
	
	

}
