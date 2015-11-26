package com.ursideus.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dovw on 11/25/15.
 */


public class Application {

    //@Bean
    public static void main(String[] args) {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfiguration.class);

        Camera camera = (Camera)appContext.getBean("camera");
        camera.snap();

        appContext.close();
    }
}
