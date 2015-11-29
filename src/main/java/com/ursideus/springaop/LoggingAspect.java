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


    ///-- Define dummy method as pointcut reference
    @Pointcut("execution(* com.ursideus.springaop.Camera.snap(..))")
    public void cameraMethodPoitCut() {

    }

    //@Bean
    ///-- an advice
    ///-- add point cut, before Camera.snap() method
    ///-- user pointcut ref method
    @Before("cameraMethodPoitCut()")
    //@Before("execution(* com.ursideus.springaop.Camera.snap(..))")
    public void beforeTakingPhoto() {
        System.out.println("about to snap a pic");
    }

    ///-- Will be called after target execution always
    @After("execution(* com.ursideus.springaop.Camera.snap(..))")
    //@Pointcut("execution(* Camera.snap(..))")
    public void afterTakingPhoto() {
        System.out.println("just took a pic");
    }

    ///-- Will be called after target execution except when exception thrown
    @AfterReturning("execution(* com.ursideus.springaop.Camera.snap(..))")
    //@Pointcut("execution(* Camera.snap(..))")
    public void afterReturningTakingPhoto() {
        System.out.println("after returning from taking a pic");
    }

    ///-- an advice
    ///-- add point cut, before any method
//    @Before("execution(* com.ursideus.springaop.*.*(..))")
//    //@Pointcut("execution(* *.*(..))")
//    public void logBeforeMethod(JoinPoint joinPoint) {
//        System.out.println("executing method: " + joinPoint.getSignature().getName());
//    }
}
