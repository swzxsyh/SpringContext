package com.test.application.designPatten.structuralPattern.compositePattern;

import com.test.application.designPatten.structuralPattern.compositePattern.editor.ImageEditor;
import com.test.application.designPatten.structuralPattern.compositePattern.shapes.Circle;
import com.test.application.designPatten.structuralPattern.compositePattern.shapes.CompoundShape;
import com.test.application.designPatten.structuralPattern.compositePattern.shapes.Dot;
import com.test.application.designPatten.structuralPattern.compositePattern.shapes.Rectangle;

import java.awt.*;

public class Demo {

    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),
                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)),
                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)));
    }
}
