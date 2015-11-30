package com.ursideus.springaop;

import com.ursideus.springaop.security.Secured;
import org.springframework.stereotype.Component;

/**
 * Created by dovw on 11/25/15.
 */
@Component("camera")
public class Camera implements PhotographyDevice, ICamera {

    private String type;

    @Secured
    @Override
    public void snap() {
        System.out.println("SNAP");
    }

    public void snap(int waitTime) {
        System.out.println("SNAP with wait time " + waitTime);
    }

    public void snap(int waitTime, long focus) {
        System.out.println("SNAP with wait time " + waitTime + " focus " + focus);
    }

    @Override
    public void exceptionalSnap() throws Exception {
        throw new Exception("Exception occurred");
    }

    public void snapPicWithLeans(Leans leans) {
        leans.clickPic();
    }

}
