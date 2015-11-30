package com.ursideus.springaop;

/**
 * Created by dovw on 11/29/15.
 */
public interface ICamera {

    void snap();

    void snap(int waitTime);

    void snap(int waitTime, long focus);

    void exceptionalSnap() throws Exception;

    void snapPicWithLeans(Leans leanse);
}
