package com.test.application.designPatten.creationalPattern.buildedrPattern.builders;

import com.test.application.designPatten.creationalPattern.buildedrPattern.cars.CarType;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.Engine;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.GPSNavigator;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.Transmission;
import com.test.application.designPatten.creationalPattern.buildedrPattern.components.TripComputer;

public interface Builder {

    void setCarType(CarType carType);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
