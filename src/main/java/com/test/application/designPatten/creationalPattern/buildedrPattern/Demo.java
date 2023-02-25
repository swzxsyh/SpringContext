package com.test.application.designPatten.creationalPattern.buildedrPattern;

import com.test.application.designPatten.creationalPattern.buildedrPattern.builders.CarBuilder;
import com.test.application.designPatten.creationalPattern.buildedrPattern.builders.CarManualBuilder;
import com.test.application.designPatten.creationalPattern.buildedrPattern.cars.Car;
import com.test.application.designPatten.creationalPattern.buildedrPattern.cars.Manual;
import com.test.application.designPatten.creationalPattern.buildedrPattern.director.Director;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Demo {

    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();

        director.constructSportsCar(builder);

        Car car = builder.getResult();
        log.info("Car built:{}\n", car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        log.info("\nCar manual built:{}\n", carManual.print());
    }
}
