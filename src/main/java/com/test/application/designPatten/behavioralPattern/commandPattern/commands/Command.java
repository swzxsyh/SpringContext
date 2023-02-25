package com.test.application.designPatten.behavioralPattern.commandPattern.commands;

import com.test.application.designPatten.behavioralPattern.commandPattern.editor.Editor;

public abstract class Command {

    public Editor editor;
    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    void backup(){
        backup = editor.textField.getText();
    }

    public void undo(){
        editor.textField.setText(backup);
    }

    public abstract boolean execute();
}
