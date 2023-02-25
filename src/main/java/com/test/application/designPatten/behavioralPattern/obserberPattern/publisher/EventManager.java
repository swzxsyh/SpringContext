package com.test.application.designPatten.behavioralPattern.obserberPattern.publisher;

import com.test.application.designPatten.behavioralPattern.obserberPattern.listeners.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础发布者
 *
 * @author swzxsyh
 */
public class EventManager {

    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener eventListener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(eventListener);
    }

    public void unsubscribe(String eventType, EventListener eventListener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(eventListener);
    }

    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
