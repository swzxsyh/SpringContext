package com.test.application.designPatten.structuralPattern.flyweightPattern.forest;

import com.test.application.designPatten.structuralPattern.flyweightPattern.trees.Tree;
import com.test.application.designPatten.structuralPattern.flyweightPattern.trees.TreeFactory;
import com.test.application.designPatten.structuralPattern.flyweightPattern.trees.TreeType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {

    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeTypes(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }
}
