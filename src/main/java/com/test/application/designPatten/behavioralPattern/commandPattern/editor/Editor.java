package com.test.application.designPatten.behavioralPattern.commandPattern.editor;

import com.test.application.designPatten.behavioralPattern.commandPattern.commands.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * 文字编辑器的 GUI
 *
 * @author swzxsyh
 */
public class Editor {
    public JTextArea textField;
    public String clipboard;
    private CommandHistory history = new CommandHistory();

    public void init() {
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textField = new JTextArea();
        textField.setLineWrap(Boolean.TRUE);
        content.add(textField);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");

        Editor editor = this;

        ctrlC.addActionListener(e -> executeCommand(new CopyCommand(editor)));

        ctrlX.addActionListener(e -> executeCommand(new CutCommand(editor)));

        ctrlV.addActionListener(e -> executeCommand(new PasteCommand(editor)));

        ctrlZ.addActionListener(e -> undo());

        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        content.add(buttons);

        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(Boolean.TRUE);
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    private void undo() {
        if (history.isEmpty()) {
            return;
        }

        Command command = history.pop();
        if (Objects.nonNull(command)) {
            command.undo();
        }
    }
}
