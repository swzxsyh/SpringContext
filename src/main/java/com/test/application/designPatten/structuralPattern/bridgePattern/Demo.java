package com.test.application.designPatten.structuralPattern.bridgePattern;

import com.test.application.designPatten.structuralPattern.bridgePattern.devices.Device;
import com.test.application.designPatten.structuralPattern.bridgePattern.devices.Radio;
import com.test.application.designPatten.structuralPattern.bridgePattern.devices.Tv;
import com.test.application.designPatten.structuralPattern.bridgePattern.remotes.AdvancedRemote;
import com.test.application.designPatten.structuralPattern.bridgePattern.remotes.BasicRemote;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }


    public static void testDevice(Device device) {
        log.info("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        log.info("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();

    }
}
