package com.test.application.designPatten.behavioralPattern.mementoPattern.editor;

import com.test.application.designPatten.behavioralPattern.mementoPattern.commands.Command;
import com.test.application.designPatten.behavioralPattern.mementoPattern.history.History;
import com.test.application.designPatten.behavioralPattern.mementoPattern.history.Memento;
import com.test.application.designPatten.behavioralPattern.mementoPattern.shapes.CompoundShape;
import com.test.application.designPatten.behavioralPattern.mementoPattern.shapes.Shape;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import javax.swing.*;
import java.io.*;
import java.util.Base64;

/**
 * 编辑器代码
 *
 * @author swzxsyh
 */
@Slf4j
public class Editor extends JComponent {

    private Canvas canvas;
    private CompoundShape allShapes = new CompoundShape();
    private History history;

    public Editor() {
        this.canvas = new Canvas(this);
        this.history = new History();
    }

    public void loadShapes(Shape... shapes) {
        allShapes.clear();
        allShapes.add(shapes);
        canvas.refresh();
    }

    public CompoundShape getShapes() {
        return allShapes;
    }

    public void execute(Command command) {
        history.push(command, new Memento(this));
        command.execute();
    }

    public void undo() {
        if (history.undo()) {
            canvas.repaint();
        }
    }

    public void redo() {
        if (history.redo()) {
            canvas.repaint();
        }
    }

    public String backup() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.allShapes);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            log.error("backup err:", e);
        }
        return Strings.EMPTY;
    }

    public void restore(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            this.allShapes = (CompoundShape) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException occurred:", e);
        } catch (IOException e) {
            log.error("IOException occurred:", e);
        }
    }
}
