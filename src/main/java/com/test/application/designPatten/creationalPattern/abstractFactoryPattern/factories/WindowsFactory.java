package com.test.application.designPatten.creationalPattern.abstractFactoryPattern.factories;

import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.buttons.Button;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.buttons.MacOSButton;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.buttons.WindowsButton;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.checkBoxes.CheckBox;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.checkBoxes.MacOSCheckBox;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.checkBoxes.WindowsCheckBox;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
