package com.test.application.designPatten.creationalPattern.factoryMethodPattern.factory;

import com.test.application.designPatten.creationalPattern.factoryMethodPattern.buttons.Button;
import com.test.application.designPatten.creationalPattern.factoryMethodPattern.buttons.WindowsButton;

public class WindowsDialog extends Dialog{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
