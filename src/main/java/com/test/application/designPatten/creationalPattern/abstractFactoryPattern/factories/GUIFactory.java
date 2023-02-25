package com.test.application.designPatten.creationalPattern.abstractFactoryPattern.factories;

import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.buttons.Button;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.checkBoxes.CheckBox;

public interface GUIFactory {

    Button createButton();

    CheckBox createCheckBox();
}
