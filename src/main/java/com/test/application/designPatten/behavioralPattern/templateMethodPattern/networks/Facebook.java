package com.test.application.designPatten.behavioralPattern.templateMethodPattern.networks;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体社交网络
 *
 * @author swzxsyh
 */
@Slf4j
public class Facebook extends Network {

    public Facebook(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    boolean logIn(String userName, String password) {
        log.info("\nChecking user's parameters");
        log.info("Name: {}", this.userName);
        log.info("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            log.info("*");
        }
        simulateNetworkLatency();
        log.info("\n\nLogIn success on Facebook");
        return true;
    }

    @Override
    boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            log.info("Message: {} was posted on Facebook", new String(data));
            return true;
        } else {
            return false;
        }
    }

    @Override
    void logOut() {
        log.info("User: {} was logged out from Facebook", userName);
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            log.info("\n");
            while (i < 10) {
                log.info(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
