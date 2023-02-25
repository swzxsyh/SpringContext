package com.test.application.designPatten.behavioralPattern.obserberPattern.editor;

import com.test.application.designPatten.behavioralPattern.obserberPattern.publisher.EventManager;

import java.io.File;
import java.util.Objects;

/**
 * 具体发布者， 由其他对象追踪
 *
 * @author swzxsyh
 */
public class Editor {

    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (Objects.nonNull(this.file)) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
