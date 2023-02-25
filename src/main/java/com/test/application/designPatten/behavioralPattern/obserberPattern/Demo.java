package com.test.application.designPatten.behavioralPattern.obserberPattern;

import com.test.application.designPatten.behavioralPattern.obserberPattern.editor.Editor;
import com.test.application.designPatten.behavioralPattern.obserberPattern.listeners.EmailNotificationListener;
import com.test.application.designPatten.behavioralPattern.obserberPattern.listeners.LogOpenListener;
import lombok.extern.slf4j.Slf4j;

/**
 * 初始化代码
 *
 * @author swzxsyh
 */
@Slf4j
public class Demo {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("./file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.ext");
            editor.saveFile();
        } catch (Exception e) {
            log.error("save File err:", e);
        }
    }
}
