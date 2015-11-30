package com.ursideus.springaop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by dovw on 11/30/15.
 */

@Component
public class Leans {

    @Value("Wide")
    private String type;

    public void clickPic() {
        System.out.println("Taking picture with lease " + type);
    }
}
