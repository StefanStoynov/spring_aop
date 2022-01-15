package com.ss.spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class AfterAopAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // what kind of methods I want to intercept
    //execution(* Package.*.*(..))
    //execution(* in this Package.any class.any method(with any arguments))

    //After a method is executed successfully or throws an exception in both scenarios
    @After(value = "com.ss.spring_aop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void afterReturning(JoinPoint joinPoint) {
        //Advice - what to do
        logger.info("after execution of {}", joinPoint);
    }

    //After a method is executed successfully
    @AfterReturning(value = "com.ss.spring_aop.aspect.CommonJoinPointConfig.businessLayerExecution()",
            returning = "result")
    public void afterReturningSuccess(JoinPoint joinPoint, Object result) {
        //Advice - what to do
        logger.info("{} returned with value {}", joinPoint, result);
    }

    //After a method throws an exception
    @AfterThrowing(value = "com.ss.spring_aop.aspect.CommonJoinPointConfig.businessLayerExecution()",
            throwing =  "exception")
    public void afterReturningException(JoinPoint joinPoint, Exception exception) {
        //Advice - what to do
        logger.info("after execution of {} throw exception {}", joinPoint, exception);
    }

}
