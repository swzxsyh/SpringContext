package com.test.application.designPatten.creationalPattern.PrototypePattern.shapes;

import java.util.Objects;

public class Rectangle extends Shape{

    public int width;
    public int height;

    public Rectangle(){}

    public Rectangle(Rectangle target){
        super(target);
        if(Objects.nonNull(target)){
            this.width = target.width;
            this.height = target.height;
        }
    }


    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if(!(object2 instanceof Rectangle) || !super.equals(object2)){
            return false;
        }
        Rectangle shape2 = (Rectangle) object2;
        return width == shape2.width && height == shape2.height;
    }
}
