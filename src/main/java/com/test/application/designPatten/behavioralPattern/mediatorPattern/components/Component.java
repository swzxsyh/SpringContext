package com.test.application.designPatten.behavioralPattern.mediatorPattern.components;

import com.test.application.designPatten.behavioralPattern.mediatorPattern.mediator.Mediator;

public interface Component {

    void setMediator(Mediator mediator);

    String getName();
}
