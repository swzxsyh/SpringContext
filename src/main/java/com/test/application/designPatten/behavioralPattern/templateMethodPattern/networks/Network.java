package com.test.application.designPatten.behavioralPattern.templateMethodPattern.networks;

import java.nio.charset.StandardCharsets;

/**
 * 基础社交网络类
 *
 * @author swzxsyh
 */
public abstract class Network {
    String userName;
    String password;

    public Network() {
    }

    public boolean post(String message) {
        if (logIn(this.userName, this.password)) {
            boolean result = sendData(message.getBytes(StandardCharsets.UTF_8));
            logOut();
            return result;
        }
        return Boolean.FALSE;
    }

    abstract boolean logIn(String userName, String password);

    abstract boolean sendData(byte[] data);

    abstract void logOut();
}
