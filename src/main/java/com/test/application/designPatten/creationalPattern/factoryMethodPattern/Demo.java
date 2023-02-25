package com.test.application.designPatten.creationalPattern.factoryMethodPattern;

import com.test.application.designPatten.creationalPattern.factoryMethodPattern.factory.Dialog;
import com.test.application.designPatten.creationalPattern.factoryMethodPattern.factory.HtmlDialog;
import com.test.application.designPatten.creationalPattern.factoryMethodPattern.factory.WindowsDialog;
import com.test.infrastructure.constant.SystemConstant;

public class Demo {

    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure(){
        if(System.getProperty(SystemConstant.OS_NAME).startsWith(SystemConstant.WINDOWS)){
            dialog = new WindowsDialog();
        }else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic(){
        dialog.renderWindow();
    }
}
