package com.test.application.designPatten.creationalPattern.abstractFactoryPattern.buttons;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MacOSButton implements Button{
    @Override
    public void paint() {
        log.info("You have created MacOSButton.");
    }
}
