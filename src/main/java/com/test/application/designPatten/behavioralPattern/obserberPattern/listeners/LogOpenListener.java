package com.test.application.designPatten.behavioralPattern.obserberPattern.listeners;


import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * 收到通知后在日志中记录一条消息
 *
 * @author swzxsyh
 */
@Slf4j
public class LogOpenListener implements EventListener {

    private File file;

    public LogOpenListener(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        log.info("Save to log {}: Someone has performed {} operation with the following file: {}", log, eventType, file.getName());
    }
}
