package com.test.application.designPatten.behavioralPattern.mediatorPattern.components;

import com.test.application.designPatten.behavioralPattern.mediatorPattern.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveButton extends JButton implements Component{

    private Mediator mediator;

    public SaveButton() {
        super("Save");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        mediator.saveChanges();
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
