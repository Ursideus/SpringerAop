package com.ursideus.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by dovw on 11/26/15.
 */


@Component
///-- an Aspect
@Aspect
public class LoggingAspect {

    //@Bean
    ///-- an advice
    ///-- add point cut, before Camera.snap() method
    @Before("execution(* com.ursideus.springaop.Camera.snap(..))")
    //@Pointcut("execution(* Camera.snap(..))")
    public void beforeTakingPhoto() {
        System.out.println("about to snap a pic");
    }

    @After("execution(* com.ursideus.springaop.Camera.snap(..))")
    //@Pointcut("execution(* Camera.snap(..))")
    public void afterTakingPhoto() {
        System.out.println("just took a pic");
    }

    @AfterReturning("execution(* com.ursideus.springaop.Camera.snap(..))")
    //@Pointcut("execution(* Camera.snap(..))")
    public void afterReturningTakingPhoto() {
        System.out.println("afr. returning from taking a pic");
    }

    //@Bean
    ///-- an advice
    ///-- add point cut, before any method
    @Before("execution(* com.ursideus.springaop.*.*(..))")
    //@Pointcut("execution(* *.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("executing method: " + joinPoint.getSignature().getName());
    }
}
