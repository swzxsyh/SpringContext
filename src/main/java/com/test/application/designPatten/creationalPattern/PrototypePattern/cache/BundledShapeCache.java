package com.test.application.designPatten.creationalPattern.PrototypePattern.cache;

import com.test.application.designPatten.creationalPattern.PrototypePattern.shapes.Circle;
import com.test.application.designPatten.creationalPattern.PrototypePattern.shapes.Rectangle;
import com.test.application.designPatten.creationalPattern.PrototypePattern.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

public class BundledShapeCache {

    private Map<String, Shape> cache = new HashMap<>(8);

    public BundledShapeCache() {
        Circle circle = new Circle();
        circle.x = 5;
        circle.y = 7;
        circle.radius = 45;
        circle.color = "Green";

        Rectangle rectangle = new Rectangle();
        rectangle.x = 7;
        rectangle.y = 9;
        rectangle.width = 8;
        rectangle.height = 10;
        rectangle.color = "Blue";

        cache.put("Big green circle", circle);
        cache.put("Medium blue rectangle", rectangle);
    }

    public Shape put(String key, Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key) {
        return cache.get(key).clone();
    }
}
