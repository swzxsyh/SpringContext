package com.test.application.designPatten.behavioralPattern.commandPattern.commands;

import com.test.application.designPatten.behavioralPattern.commandPattern.editor.Editor;

import java.util.Objects;

public class PasteCommand extends Command {

    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (Objects.isNull(editor.clipboard) || editor.clipboard.isEmpty()) {
            return false;
        }


        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}
