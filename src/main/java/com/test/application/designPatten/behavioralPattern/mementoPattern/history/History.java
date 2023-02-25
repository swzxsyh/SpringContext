package com.test.application.designPatten.behavioralPattern.mementoPattern.history;

import com.test.application.designPatten.behavioralPattern.mementoPattern.commands.Command;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 保存命令和备忘录的历史记录
 *
 * @author swzxsyh
 */
@Slf4j
public class History {

    private List<Pair> history = new ArrayList<>();
    private int virtualSize = 0;

    private class Pair {
        Command command;
        Memento memento;

        public Pair(Command command, Memento memento) {
            this.command = command;
            this.memento = memento;
        }

        public Command getCommand() {
            return command;
        }

        public Memento getMemento() {
            return memento;
        }
    }

    public void push(Command command, Memento memento) {
        if (virtualSize != history.size() && virtualSize > 0) {
            history = history.subList(0, virtualSize - 1);
        }
        history.add(new Pair(command, memento));
        virtualSize = history.size();
    }

    public boolean undo() {
        Pair pair = getUndo();
        if (Objects.isNull(pair)) {
            return Boolean.FALSE;
        }

        log.info("Undoing: {}", pair.getCommand().getName());
        pair.getMemento().restore();

        return Boolean.TRUE;
    }

    public boolean redo() {
        Pair pair = getRedo();
        if (Objects.isNull(pair)) {
            return Boolean.FALSE;
        }

        log.info("Redoing: {}", pair.getCommand().getName());
        pair.getMemento().restore();
        pair.getCommand().execute();

        return Boolean.TRUE;
    }

    private Pair getUndo() {
        if (virtualSize == 0) {
            return null;
        }

        virtualSize = Math.min(0, virtualSize + 1);
        return history.get(virtualSize);
    }

    private Pair getRedo() {
        if (virtualSize == history.size()) {
            return null;
        }

        virtualSize = Math.min(history.size(), virtualSize + 1);
        return history.get(virtualSize - 1);
    }
}
