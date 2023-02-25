package com.test.application.designPatten.structuralPattern.flyweightPattern;

import com.test.application.designPatten.structuralPattern.flyweightPattern.forest.Forest;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;

@Slf4j
public class Demo {

    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 1000000;
    static int TREE_TYPES = 2;

    public static void main(String[] args) {
        Forest forest = new Forest();

        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), "Summer Oak", Color.GREEN, "Oak texture stub");
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
        }

        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(Boolean.TRUE);

        log.info("{} trees drawn", TREES_TO_DRAW);
        log.info("---------------------");
        log.info("Memory usage:");
        log.info("Tree size (8 bytes) * {}", TREES_TO_DRAW);
        log.info("+ TreeTypes size (~30 bytes) * {}", TREE_TYPES);
        log.info("---------------------");
        log.info("Total: {} MB (instead of {} MB)", ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024), ((TREES_TO_DRAW * 38) / 1024 / 1024));

    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
