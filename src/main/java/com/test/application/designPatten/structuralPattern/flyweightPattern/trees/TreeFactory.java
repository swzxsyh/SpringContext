package com.test.application.designPatten.structuralPattern.flyweightPattern.trees;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TreeFactory {

    static Map<String, TreeType> treeTypeMap = new HashMap<>();

    public static TreeType getTreeTypes(String name, Color color, String otherTreeData) {
        TreeType result = treeTypeMap.get(name);
        if (Objects.isNull(result)) {
            result = new TreeType(name, color, otherTreeData);
            treeTypeMap.put(name, result);
        }
        return result;
    }
}
