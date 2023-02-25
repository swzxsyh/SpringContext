package com.test.application.designPatten.creationalPattern.factoryMethodPattern.factory;

import com.test.application.designPatten.creationalPattern.factoryMethodPattern.buttons.Button;
import com.test.application.designPatten.creationalPattern.factoryMethodPattern.buttons.HtmlButton;

public class HtmlDialog extends Dialog{
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
