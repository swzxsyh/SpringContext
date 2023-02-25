package com.test.application.designPatten.behavioralPattern.statePattern;

import com.test.application.designPatten.behavioralPattern.statePattern.ui.Player;
import com.test.application.designPatten.behavioralPattern.statePattern.ui.UI;

public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
