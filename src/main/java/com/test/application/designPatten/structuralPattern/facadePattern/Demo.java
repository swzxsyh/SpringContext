package com.test.application.designPatten.structuralPattern.facadePattern;

import com.test.application.designPatten.structuralPattern.facadePattern.facade.VideoConversionFacade;

import java.io.File;

public class Demo {

    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubeVideo.ogg", "mp4");
    }
}
