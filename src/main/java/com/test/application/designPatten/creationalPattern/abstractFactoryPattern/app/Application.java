package com.test.application.designPatten.creationalPattern.abstractFactoryPattern.app;

import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.buttons.Button;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.checkBoxes.CheckBox;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.factories.GUIFactory;

public class Application {
    private Button button;
    private CheckBox checkBox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void paint(){
        button.paint();
        checkBox.paint();
    }
}
