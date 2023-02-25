package com.test.application.designPatten.behavioralPattern.obserberPattern.listeners;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * 收到通知后发送邮件
 *
 * @author swzxsyh
 */
@Slf4j
public class EmailNotificationListener implements EventListener {

    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        log.info("Email to {}: Someone has performed {} operation with the following file: {}", email, eventType, file.getName());
    }
}
