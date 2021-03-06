package com.ursideus.springaop;

import com.ursideus.springaop.logging.LoggingAspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by dovw on 11/26/15.
 */
@Configuration
//@ComponentScan
@ComponentScan(basePackages = {"com.ursideus"})
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AppConfiguration {

    //@Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
//    @Bean
//    public AroundAspect aroundAspect(){
//        return new AroundAspect();
//    }
}
