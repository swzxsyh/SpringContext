package com.test.application.designPatten.creationalPattern.buildedrPattern.director;

import com.test.application.designPatten.creationalPattern.buildedrPattern.builders.Builder;
import com.test.application.designPatten.creationalPattern.buildedrPattern.cars.CarType;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.Engine;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.GPSNavigator;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.Transmission;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.TripComputer;

public class Director {

    public void constructSportsCar(Builder builder){
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder){
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSuv(Builder builder){
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}
