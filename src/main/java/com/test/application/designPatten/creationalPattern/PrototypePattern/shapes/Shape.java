package com.test.application.designPatten.creationalPattern.PrototypePattern.shapes;

import java.util.Objects;

public abstract class Shape {

    public int x;
    public int y;
    public String color;

    public Shape() {
    }

    public Shape(Shape target) {
        if(Objects.nonNull(target)){
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object object2) {
        if(!(object2 instanceof Shape)){
            return false;
        }
        Shape shape2 = (Shape) object2;
        return x == shape2.x && y == shape2.y && Objects.equals(color, shape2.color);
    }
}
