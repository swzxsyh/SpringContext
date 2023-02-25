package com.test.application.designPatten.creationalPattern.buildedrPattern.builders;

import com.test.application.designPatten.creationalPattern.buildedrPattern.cars.CarType;
import com.test.application.designPatten.creationalPattern.buildedrPattern.cars.Manual;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.Engine;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.GPSNavigator;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.Transmission;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.TripComputer;

public class CarManualBuilder implements Builder {

    private CarType carType;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }


    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Manual getResult() {
        return new Manual(carType, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
