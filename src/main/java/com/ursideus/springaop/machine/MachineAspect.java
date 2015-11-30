package com.ursideus.springaop.machine;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by dovw on 11/30/15.
 */
@Component
@Aspect
public class MachineAspect {

    @DeclareParents(value = "com.ursideus.springaop.*", defaultImpl = com.ursideus.springaop.machine.MachineBase.class)
    private IMachine machine;

    @Pointcut("within(com.ursideus.springaop.*)")
    public void allBeansInNamespace() {};

    @Before("allBeansInNamespace()")
    public void tunrMachineOn(JoinPoint joinPoint) {

    }

    @After("allBeansInNamespace()")
    public void turnMachineOff(JoinPoint joinPoint) {

    }

}
