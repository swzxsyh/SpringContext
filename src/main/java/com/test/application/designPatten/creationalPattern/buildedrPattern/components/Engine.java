package com.test.application.designPatten.creationalPattern.buildedrPattern.components;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Engine {

    private final double volume;
    private double mileage;
    private boolean started;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    public void on(){
        started = Boolean.TRUE;
    }

    public void off(){
        started = Boolean.FALSE;
    }

    public boolean isStarted(){
        return started;
    }

    public void go(double mileage){
        if (started){
            this.mileage += mileage;
        }else {
            log.info("Cannot go(), you must start engine first!");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getMileage() {
        return mileage;
    }
}
