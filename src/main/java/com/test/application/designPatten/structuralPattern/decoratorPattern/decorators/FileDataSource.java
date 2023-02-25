package com.test.application.designPatten.structuralPattern.decoratorPattern.decorators;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;

@Slf4j
public class FileDataSource implements DataSource {

    private String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = Files.newOutputStream(file.toPath())) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            log.error("write Data err:", ex);
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            log.error("readData err:", ex);
        }
        return new String(buffer);
    }
}
