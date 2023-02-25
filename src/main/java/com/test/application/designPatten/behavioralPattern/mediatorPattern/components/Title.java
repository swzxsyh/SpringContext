package com.test.application.designPatten.behavioralPattern.mediatorPattern.components;

import com.test.application.designPatten.behavioralPattern.mediatorPattern.mediator.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Title extends JTextArea implements Component{

    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

}
