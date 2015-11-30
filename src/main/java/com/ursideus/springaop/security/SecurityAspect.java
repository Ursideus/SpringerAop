package com.ursideus.springaop.security;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by dovw on 11/29/15.
 */

@Aspect
@Component
public class SecurityAspect {

    @Pointcut("within(@Secured com.ursideus..*)")
    public void securedMethods() {}

    @Pointcut("@target(Secured)")
    public void securedMethodsWithAnnotations() {}

    @Pointcut("@annotation(Secured)")
    public void annotatedSecured() {}

    @Pointcut("@args(org.springframework.stereotype.Component)")
    public void allArgTypesComponent() {}

    @Pointcut("bean(*leans)")
    public void allBeansById() {}

    @Before("allBeansById()")
    public void authorizedBefore(JoinPoint joinPoint) {
        System.out.println("SecurityAspect: method " + joinPoint.getSignature().getName() + " is authorized");
    }

//    @Around("securedMethodsWithAnnotations()")
//    public void authorized(ProceedingJoinPoint joinPoint) {
//        System.out.println("SecurityAspect: method " + joinPoint.getSignature().getName() + " is authorized");
//
//    }

}
