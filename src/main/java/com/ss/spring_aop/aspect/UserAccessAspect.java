package com.ss.spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class UserAccessAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // what kind of methods I want to intercept
    //execution(* Package.*.*(..))
    //execution(* in this Package.any class.any method(with any arguments))

    //defined in CommonJoinPointConfig
    @Before("com.ss.spring_aop.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void before(JoinPoint joinPoint) {
        //Advice - what to do
        logger.info("Check for User access");
        logger.info("Allowed execution for {}", joinPoint);
    }

}
