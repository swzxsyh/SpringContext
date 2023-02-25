package com.test.application.designPatten.structuralPattern.decoratorPattern;

import com.test.application.designPatten.structuralPattern.decoratorPattern.decorators.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class Demo {

    public static void main(String[] args) throws IOException {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        String filePath = "./OutputDemo.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("./OutputDemo.txt")));

        encoded.writeData(salaryRecords);

        DataSource plain = new FileDataSource("./OutputDemo.txt");

        log.info("- Input ----------------");
        log.info(salaryRecords);
        log.info("- Encoded --------------");
        log.info(plain.readData());
        log.info("- Decoded --------------");
        log.info(encoded.readData());
    }
}
