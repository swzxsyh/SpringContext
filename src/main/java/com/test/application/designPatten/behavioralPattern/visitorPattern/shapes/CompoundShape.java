package com.test.application.designPatten.behavioralPattern.visitorPattern.shapes;

import com.test.application.designPatten.behavioralPattern.visitorPattern.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合形状
 *
 * @author swzxsyh
 */
public class CompoundShape implements Shape {
    public int id;
    public List<Shape> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        // move shape
    }

    @Override
    public void draw() {
        // draw shape
    }

    public int getId() {
        return id;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundGraphic(this);
    }

    public void add(Shape shape) {
        children.add(shape);
    }
}
