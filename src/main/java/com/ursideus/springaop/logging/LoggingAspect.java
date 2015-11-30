package com.ursideus.springaop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by dovw on 11/26/15.
 */


@Component
///-- an Aspect
//@Aspect
public class LoggingAspect {


    ///-- Define dummy method as pointcut reference
    @Pointcut("execution(* com.ursideus.springaop.Camera.snap(..))")
    public void cameraSnapMethodPoitCut() {}

    @Pointcut("execution(* com.ursideus.springaop.Camera.*(..))")
    public void cameraMethodPoitCut() {}

    @Pointcut("execution(* com.ursideus.springaop.*.*(..))")
    public void fullPackageScopePoitCut() {}

    //@Bean
    ///-- an advice
    ///-- add point cut, before Camera.snap() method
    ///-- user pointcut ref method
    @Before("cameraSnapMethodPoitCut()")
    //@Before("execution(* com.ursideus.springaop.Camera.snap(..))")
    public void beforeTakingPhoto() {
        System.out.println("about to snap a pic");
    }

    ///-- Will be called after target execution always !!!
    @After("execution(* com.ursideus.springaop.Camera.snap(..))")
    //@Pointcut("execution(* Camera.snap(..))")
    public void afterTakingPhoto() {
        System.out.println("just took a pic");
    }

    ///-- Will be called after target execution except when exception was thrown !!!
    @AfterReturning("execution(* com.ursideus.springaop.Camera.snap(..))")
    //@Pointcut("execution(* Camera.snap(..))")
    public void afterReturningTakingPhoto() {
        System.out.println("after returning from taking a pic");
    }

    @AfterThrowing("cameraMethodPoitCut()")
    public void afterThrowingAdvice() {
        System.out.println("after throwing advice");
    }

    ///-- an advice
    ///-- add point cut, before any method execution
    @Before("fullPackageScopePoitCut()")
    //@Pointcut("execution(* *.*(..))")
        public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("executing method: " + joinPoint.getSignature().getName());
    }


    ///-- @Around advice overrides @AfterThrowing and catches exceptions instead
    @Around("fullPackageScopePoitCut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("LoggingAspect: Around advice - before execution:" + joinPoint.getSignature().getName());

        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            //throwable.printStackTrace();
            System.out.println("LoggingAspect: Around advice - caught exception" +
                    throwable.getMessage() + " in: " + joinPoint.getSignature().getName());
        }

        System.out.println("LoggingAspect: Around advice - after execution:" + joinPoint.getSignature().getName());
    }

}