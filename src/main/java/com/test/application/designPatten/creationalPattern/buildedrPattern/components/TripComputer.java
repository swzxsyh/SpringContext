package com.test.application.designPatten.creationalPattern.buildedrPattern.components;

import com.test.application.designPatten.creationalPattern.buildedrPattern.cars.Car;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TripComputer {

    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        log.info("Fuel level: " + car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()){
            log.info("Car is started");
        }else {
            log.info("Car isn't started");
        }
    }
}
