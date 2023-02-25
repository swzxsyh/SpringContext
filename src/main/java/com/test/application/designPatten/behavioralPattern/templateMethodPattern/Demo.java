package com.test.application.designPatten.behavioralPattern.templateMethodPattern;

import com.test.application.designPatten.behavioralPattern.templateMethodPattern.networks.Facebook;
import com.test.application.designPatten.behavioralPattern.templateMethodPattern.networks.Network;
import com.test.application.designPatten.behavioralPattern.templateMethodPattern.networks.Twitter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class Demo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        log.info("Input user name: ");
        String userName = reader.readLine();
        log.info("Input password: ");
        String password = reader.readLine();

        // Enter the message.
        log.info("Input message: ");
        String message = reader.readLine();

        log.info("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());

        // Create proper network object and send the message.
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);
    }
}
