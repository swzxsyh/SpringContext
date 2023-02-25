package com.test.application.designPatten.behavioralPattern.mementoPattern.history;

import com.test.application.designPatten.behavioralPattern.mementoPattern.editor.Editor;

/**
 * 备忘录类
 *
 * @author swzxsyh
 */
public class Memento {

    private String backup;
    private Editor editor;

    public Memento(Editor editor) {
        this.backup = editor.backup();
        this.editor = editor;
    }

    public void restore() {
        editor.restore(backup);
    }
}
