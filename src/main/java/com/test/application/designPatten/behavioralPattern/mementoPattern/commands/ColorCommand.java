package com.test.application.designPatten.behavioralPattern.mementoPattern.commands;

import com.test.application.designPatten.behavioralPattern.mementoPattern.editor.Editor;
import com.test.application.designPatten.behavioralPattern.mementoPattern.shapes.Shape;

import java.awt.*;

/**
 * 修改已选形状的颜色
 *
 * @author swzxsyh
 */
public class ColorCommand implements Command {
    private Editor editor;
    private Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
