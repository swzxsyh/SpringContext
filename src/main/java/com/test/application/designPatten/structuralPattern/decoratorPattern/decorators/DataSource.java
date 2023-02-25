package com.test.application.designPatten.structuralPattern.decoratorPattern.decorators;

public interface DataSource {

    void writeData(String data);

    String readData();
}
