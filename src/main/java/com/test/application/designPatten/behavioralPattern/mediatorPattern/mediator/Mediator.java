package com.test.application.designPatten.behavioralPattern.mediatorPattern.mediator;

import com.test.application.designPatten.behavioralPattern.mediatorPattern.components.Component;

import javax.swing.*;

/**
 * 定义通用的中介者接口
 *
 * @author swzxsyh
 */
public interface Mediator {

    void addNewNote(Note note);

    void deleteNote();

    void getInfoFromList(Note note);

    void saveChanges();

    void markNote();

    void clear();

    void sendToFilter(ListModel listModel);

    void setElementsList(ListModel listModel);

    void registerComponent(Component component);

    void hideElements(Boolean flag);

    void createGUI();
}
