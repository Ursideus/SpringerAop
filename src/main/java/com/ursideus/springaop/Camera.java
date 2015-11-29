package com.ursideus.springaop;

import org.springframework.stereotype.Component;

/**
 * Created by dovw on 11/25/15.
 */
@Component("camera")
public class Camera implements PhotographyDavide {

    public void snap() {
        System.out.println("SNAP");
    }

    public void exceptionalSnap() throws Exception {
        throw new Exception("Exception occurred");
    }

}
