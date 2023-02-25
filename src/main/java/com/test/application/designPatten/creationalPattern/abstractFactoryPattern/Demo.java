package com.test.application.designPatten.creationalPattern.abstractFactoryPattern;

import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.app.Application;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.factories.GUIFactory;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.factories.MacOSFactory;
import com.test.application.designPatten.creationalPattern.abstractFactoryPattern.factories.WindowsFactory;
import com.test.infrastructure.constant.SystemConstant;

import java.util.Locale;

public class Demo {

    private static Application configureApplication(){
        Application app;
        GUIFactory factory;
        String osName = System.getProperty(SystemConstant.OS_NAME).toLowerCase(Locale.ROOT);
        if (osName.contains(SystemConstant.MAC)){
            factory = new MacOSFactory();
            app = new Application( factory);
        }else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
