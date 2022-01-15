package com.ss.spring_aop.aspect;

import org.aspectj.lang.annotation.Pointcut;
//This class is used to define a common points.
// Something like defining a fina variables or enums but for Points
public class CommonJoinPointConfig {

    @Pointcut("execution(* com.ss.spring_aop.data.*.*(..))")
    public void dataLayerExecution(){
    }

    @Pointcut("execution(* com.ss.spring_aop.business.*.*(..))")
    public void businessLayerExecution(){
    }
    //Defining a point cut for two packages
    @Pointcut("execution(* com.ss.spring_aop.business.*.*(..)) && execution(* com.ss.spring_aop.data.*.*(..))")
    public void allLayerExecution(){
    }

    //Defining a point cut for bean starting whit dao.
    //Defining what to search (Dao*) - using regX
    @Pointcut("bean(dao*)")
    public void beanStartingWithDao(){
    }

    //Defining a point cut for bean containing whit dao.
    @Pointcut("bean(*dao*)")
    public void beanContainingDao(){
    }

    //Defining a point cut within data
    @Pointcut("within(com.ss.spring_aop.data..*)")
    public void dataLayerExecutionWithWithin(){
    }

    //Defining a point cut for custom annotation
    @Pointcut("@annotation(com.ss.spring_aop.aspect.TrackTime)")
    public void trackTimeAnnotation(){
    }

}
