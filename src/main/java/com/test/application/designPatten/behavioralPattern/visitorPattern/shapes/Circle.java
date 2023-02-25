package com.test.application.designPatten.behavioralPattern.visitorPattern.shapes;

import com.test.application.designPatten.behavioralPattern.visitorPattern.visitor.Visitor;

/**
 * 圆形
 *
 * @author swzxsyh
 */
public class Circle extends Dot {
    private int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }

    public int getRadius() {
        return radius;
    }
}
