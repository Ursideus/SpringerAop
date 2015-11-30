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
@Aspect
public class LoggingAspect {


    ///-- Define dummy method as pointcut reference
    @Pointcut("execution(* com.ursideus.springaop.Camera.snap(..))")
    public void cameraSnapMethodPointCut() {}

    @Pointcut("execution(* com.ursideus.springaop.Camera.*(..))")
    public void cameraMethodPointCut() {}

    @Pointcut("execution(* com.ursideus.springaop.*.*(..))")
    public void fullPackageScopePointCut() {}

    @Pointcut("args()")
    public void allNoArgsMethods() {}

    @Pointcut("args(..)")
    public void allMethods() {}

    @Pointcut("args(exposure, focus)")
    public void methodsWithArgsIntLong(int exposure, long focus) {}

    @Pointcut("target(com.ursideus.springaop.Camera)")
    public void targetCamera() {}

    //@Bean
    ///-- an advice
    ///-- add point cut, before Camera.snap() method
    ///-- user pointcut ref method
//    @Before("cameraSnapMethodPoitCut()")
//    //@Before("execution(* com.ursideus.springaop.Camera.snap(..))")
//    public void beforeTakingPhoto() {
//        System.out.println("about to snap a pic");
//    }
//
//    ///-- Will be called after target execution always !!!
//    @After("execution(* com.ursideus.springaop.Camera.snap(..))")
//    //@Pointcut("execution(* Camera.snap(..))")
//    public void afterTakingPhoto() {
//        System.out.println("just took a pic");
//    }
//
//    ///-- Will be called after target execution except when exception was thrown !!!
//    @AfterReturning("execution(* com.ursideus.springaop.Camera.snap(..))")
//    //@Pointcut("execution(* Camera.snap(..))")
//    public void afterReturningTakingPhoto() {
//        System.out.println("after returning from taking a pic");
//    }

    @AfterThrowing("allMethods()")
    public void afterThrowingAdvice() {
        System.out.println("logging aspect: after throwing advice");
    }

    ///-- an advice
    ///-- add point cut, before any method execution
//    @Before("allMethods()")
//        public void logBeforeMethod(JoinPoint joinPoint) {
//        System.out.println("executing method: " + joinPoint.getSignature().getName());
//        System.out.println(">method args: ");
//
//        for (Object arg : joinPoint.getArgs()) {
//            System.out.println(">arg - " + arg );
//        }
//    }

    @Before("targetCamera() && methodsWithArgsIntLong(exposure, focus)")
    public void logBeforeMethod(JoinPoint joinPoint, int exposure, long focus) {
        System.out.println("executing method: " + joinPoint.getSignature().getName());
        System.out.println(">method args: ");
        System.out.println("> exposure args - " + exposure);
        System.out.println("> focus args - " + focus);
    }


    ///-- @Around advice overrides @AfterThrowing and catches exceptions instead
    //@Around("")
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
