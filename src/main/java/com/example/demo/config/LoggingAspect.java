package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void logRequest(JoinPoint joinPoint) throws Throwable {
        String args = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(joinPoint.getArgs());
        logger.info("Request: " + joinPoint.getSignature().toShortString() + "\nWith args: " + args);
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.controller.*.*(..))", returning = "result")
    public void logResponse(Object result) throws Throwable {
        String prettyResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        logger.info("Response: \n" + prettyResponse);
    }
}