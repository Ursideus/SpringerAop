package com.ursideus.springaop;

/**
 * Created by dovw on 11/29/15.
 */
public interface ICamera {

    void snap();

    void exceptionalSnap() throws Exception;

    void snapPicWithLeans(Leans leanse);
}
