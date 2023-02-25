package com.test.application.designPatten.structuralPattern.facadePattern.someComplexMediaLibrary;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class AudioMixer {

    public File fix(VideoFile result){
        log.info("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}
