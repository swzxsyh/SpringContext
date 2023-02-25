package com.test.application.designPatten.behavioralPattern.mediatorPattern.components;

import com.test.application.designPatten.behavioralPattern.mediatorPattern.mediator.Mediator;
import com.test.application.designPatten.behavioralPattern.mediatorPattern.mediator.Note;
import org.apache.logging.log4j.util.Strings;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Filter extends JTextField implements Component {

    private Mediator mediator;
    private ListModel listModel;

    public Filter() {
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setList(ListModel listModel) {
        this.listModel = listModel;
    }

    private void searchElements(String s) {
        if (Objects.isNull(listModel)) {
            return;
        }

        if (Objects.equals(Strings.EMPTY, s)) {
            mediator.setElementsList(listModel);
            return;
        }

        ArrayList<Note> noteList = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            noteList.add((Note) listModel.getElementAt(i));
        }

        DefaultListModel<Note> listModel = new DefaultListModel<>();
        for (Note note : noteList) {
            if (note.getName().contains(s)) {
                listModel.addElement(note);
            }
        }
        mediator.setElementsList(listModel);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
