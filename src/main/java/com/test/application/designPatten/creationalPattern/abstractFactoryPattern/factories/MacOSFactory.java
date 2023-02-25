package com.test.application.designPatten.creationalPattern.abstractFactoryPattern.factories;

import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.buttons.Button;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.buttons.MacOSButton;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.checkBoxes.CheckBox;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.checkBoxes.MacOSCheckBox;

public class MacOSFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
