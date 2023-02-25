package com.test.application.designPatten.behavioralPattern.obserberPattern.listeners;

import java.io.File;

/**
 * 通用观察者接口
 *
 * @author swzxsyh
 */
public interface EventListener {

    void update(String eventType, File file);
}
