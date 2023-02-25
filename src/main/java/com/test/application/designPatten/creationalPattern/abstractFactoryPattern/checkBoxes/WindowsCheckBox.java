package com.test.application.designPatten.creationalPattern.abstractFactoryPattern.checkBoxes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WindowsCheckBox implements CheckBox{
    @Override
    public void paint() {
        log.info("You have created WindowsButton.");
    }
}
