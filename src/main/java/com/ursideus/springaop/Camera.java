package com.ursideus.springaop;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by dovw on 11/25/15.
 */
@Component("camera")
public class Camera {

    public void snap() {
        System.out.println("SNAP");
    }

}
