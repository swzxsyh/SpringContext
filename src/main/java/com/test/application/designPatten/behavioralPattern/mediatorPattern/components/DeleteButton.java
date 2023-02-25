package com.test.application.designPatten.behavioralPattern.mediatorPattern.components;

import com.test.application.designPatten.behavioralPattern.mediatorPattern.mediator.Mediator;
import com.test.application.designPatten.behavioralPattern.mediatorPattern.mediator.Note;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteButton extends JButton implements Component{

    private Mediator mediator;

    public DeleteButton() {
        super("Del");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        mediator.deleteNote();
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
