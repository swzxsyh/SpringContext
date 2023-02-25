package com.test.application.designPatten.behavioralPattern.commandPattern.commands;

import com.test.application.designPatten.behavioralPattern.commandPattern.editor.Editor;

public class CopyCommand extends Command{

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
