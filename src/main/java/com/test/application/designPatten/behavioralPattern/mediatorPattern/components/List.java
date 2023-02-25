package com.test.application.designPatten.behavioralPattern.mediatorPattern.components;

import com.test.application.designPatten.behavioralPattern.mediatorPattern.mediator.Mediator;
import com.test.application.designPatten.behavioralPattern.mediatorPattern.mediator.Note;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

@Slf4j
public class List extends JList implements Component {

    private Mediator mediator;
    private final DefaultListModel LIST_MODEL;

    public List(DefaultListModel listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;
        setModel(listModel);
        this.setLayoutOrientation(JList.VERTICAL);
        Thread thread = new Thread(new Hide(this));
        thread.start();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addElement(Note note) {
        LIST_MODEL.addElement(note);
        int index = LIST_MODEL.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
        mediator.sendToFilter(LIST_MODEL);
    }

    public void deleteElement() {
        int index = this.getSelectedIndex();
        try {

            LIST_MODEL.remove(index);
            mediator.sendToFilter(LIST_MODEL);
        } catch (ArrayIndexOutOfBoundsException ex) {
            log.error("delete element err:", ex);
        }
    }

    public Note getCurrentElement() {
        return (Note) getSelectedValue();
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    private class Hide implements Runnable {

        private List list;

        public Hide(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    log.error("Hide run err:", e);
                }
                if (list.isSelectionEmpty()) {
                    mediator.hideElements(Boolean.TRUE);
                } else {
                    mediator.hideElements(Boolean.FALSE);
                }
            }
        }
    }
}
