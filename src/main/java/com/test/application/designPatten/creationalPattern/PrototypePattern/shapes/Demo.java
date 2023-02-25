package com.test.application.designPatten.creationalPattern.PrototypePattern.shapes;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Demo {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";

        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                log.info("{}: Shapes are different objects (yay!)", i);
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    log.info("{}: And they are identical (yay!)", i);
                } else {
                    log.info("{}: But they are not identical (booo!)", i);
                }

            } else {
                log.info("{}: Shape objects are the same (booo!)", i);
            }
        }
    }
}
