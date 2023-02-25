package com.test.application.designPatten.structuralPattern.compositePattern.shapes;

import java.awt.*;

public interface Shape {

    int getX();

    int getY();

    int getWidth();

    int getHeight();

    void move(int x,int y);

    boolean isInsideBounds(int x,int y);

    void select();

    void unSelect();

    boolean isSelect();

    void paint(Graphics graphics);
}
