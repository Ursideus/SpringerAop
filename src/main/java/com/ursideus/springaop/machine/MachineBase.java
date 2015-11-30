package com.ursideus.springaop.machine;

/**
 * Created by dovw on 11/30/15.
 */
public class MachineBase implements IMachine {
    @Override
    public void turnOn() {
        System.out.println("MachineBase: Turning On...");
    }

    @Override
    public void turnOff() {
        System.out.println("MachineBase: Turning Off...");
    }
}
