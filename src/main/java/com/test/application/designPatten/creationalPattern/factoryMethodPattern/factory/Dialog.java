package com.test.application.designPatten.creationalPattern.factoryMethodPattern.factory;

import com.test.application.designPatten.creationalPattern.factoryMethodPattern.buttons.Button;

public abstract class Dialog {

    public void renderWindow(){
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
