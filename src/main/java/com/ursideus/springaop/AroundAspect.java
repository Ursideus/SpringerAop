package com.ursideus.springaop;

/**
 * Created by dovw on 11/26/15.
 */
public class AroundAspect {

//    @Around("execution(* com.ursideus.springaop.*.*(..))")
//    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
//        System.out.println("Before invoking getName() method");
//        Object value = null;
//        try {
//            value = proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        System.out.println("After invoking getName() method. Return value="+value);
//        return value;
//    }

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
