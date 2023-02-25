package com.test.application.designPatten.creationalPattern.PrototypePattern.cache;

import com.test.application.designPatten.creationalPattern.PrototypePattern.shapes.Shape;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

    public static void main(String[] args) {
        BundledShapeCache cache = new BundledShapeCache();

        Shape shape1 = cache.get("Big green circle");
        Shape shape2 = cache.get("Medium blue rectangle");
        Shape shape3 = cache.get("Medium blue rectangle");

        if (shape1 != shape2 && !shape1.equals(shape2)) {
            log.info("Big green circle != Medium blue rectangle (yay!)");
        } else {
            log.info("Big green circle == Medium blue rectangle (booo!)");
        }

        if (shape2 != shape3) {
            log.info("Medium blue rectangles are two different objects (yay!)");
            if (shape2.equals(shape3)) {
                log.info("And they are identical (yay!)");
            } else {
                log.info("But they are not identical (booo!)");
            }
        } else {
            log.info("Rectangle objects are the same (booo!)");
        }
    }
}
