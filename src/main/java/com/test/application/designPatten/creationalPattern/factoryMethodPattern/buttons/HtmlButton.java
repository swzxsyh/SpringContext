package com.test.application.designPatten.creationalPattern.factoryMethodPattern.buttons;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HtmlButton implements Button {

    @Override
    public void render() {
        log.info("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        log.info("Click! Button says - 'Hello World!'");
    }
}
