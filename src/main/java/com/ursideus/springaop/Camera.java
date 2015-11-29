package com.ursideus.springaop;

import com.ursideus.springaop.security.Secured;
import org.springframework.stereotype.Component;

/**
 * Created by dovw on 11/25/15.
 */
@Component("camera")
public class Camera implements PhotographyDevice, ICamera {

    @Secured
    @Override
    public void snap() {
        System.out.println("SNAP");
    }

    @Override
    public void exceptionalSnap() throws Exception {
        throw new Exception("Exception occurred");
    }

}
