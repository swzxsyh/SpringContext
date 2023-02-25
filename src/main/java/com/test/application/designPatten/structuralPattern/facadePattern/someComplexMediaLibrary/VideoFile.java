package com.test.application.designPatten.structuralPattern.facadePattern.someComplexMediaLibrary;

public class VideoFile {

    private String name;
    private String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf("x") + 1);
    }

    public String getName() {
        return name;
    }

    public String getCodecType() {
        return codecType;
    }
}
