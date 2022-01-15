package com.ss.spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class MethodExecutionCalculatingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //what kind of methods I want to intercept
    //execution(* Package.*.*(..))
    //execution(* in this Package.any class.any method(with any arguments))

    //Allow execution of a method and intercept execution time
    //will track only methods whit custom annotation TrackTime
    @Around(value = "com.ss.spring_aop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //startTime = x
        //allow execution of the method
        //end time = y
        //calculate (y - x)
        long startTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time taken by {} is {}", proceedingJoinPoint, timeTaken);
    }

}
