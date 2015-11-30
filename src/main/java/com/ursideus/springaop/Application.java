package com.ursideus.springaop;

import com.ursideus.springaop.machine.IMachine;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dovw on 11/25/15.
 */


public class Application {

    //@Bean
    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext appContext = null;
        try {
            appContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
            //ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");

            ICamera camera = (ICamera)appContext.getBean("camera");
            ((IMachine)camera).turnOn();
            camera.snap();
            camera.snap(10);
            camera.snap(3, 11);

            Leans leans = (Leans)appContext.getBean("leans");
            camera.snapPicWithLeans(leans);

            ((IMachine)camera).turnOff();

            //System.out.println("camera instance of Camera: " + (camera instanceof ICamera));
            //System.out.println("camera instance of PhotographyDevice: " + (camera instanceof PhotographyDevice));

            camera.exceptionalSnap();
        } catch (Exception ex) {
            System.out.println("caught exception: " + ex.getMessage());;
        }

        appContext.close();
    }
}
