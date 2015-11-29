package com.ursideus.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by dovw on 11/26/15.
 */

@Aspect
@Component
public class AroundAspect {

    @Pointcut("within(com.ursideus.springaop..*)")
    public void fullPackageScopePoitCut() {}

    ///-- Can use interface but no wildcards allowed in target
    @Pointcut("target(com.ursideus.springaop.ICamera)")
    public void cameraClassScopePoitCut() {}

    //@Around("fullPackageScopePoitCut()")
    @Around("cameraClassScopePoitCut()")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("AroundAspect: Before invoking getName() method");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable ex) {
            System.out.println("AroundAspect: caught exception" +
                    ex.getMessage() + " in: " + proceedingJoinPoint.getSignature().getName());
        }
        System.out.println("AroundAspect: After invoking getName() method. Return value = " + value);
        return value;
    }

//    @Around("execution(* *(..)) && @annotation(Loggable)")
//    public Object around(ProceedingJoinPoint point) {
//        long start = System.currentTimeMillis();
//        Object result = point.proceed();
//        Logger.info(
//                "#%s(%s): %s in %[msec]s",
//                MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
//                point.getArgs(),
//                result,
//                System.currentTimeMillis() - start
//        );
//        return result;
//    }

}
