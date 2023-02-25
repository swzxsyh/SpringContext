package com.test.application.designPatten.structuralPattern.facadePattern.facade;

import com.test.application.designPatten.structuralPattern.facadePattern.someComplexMediaLibrary.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Objects;

@Slf4j
public class VideoConversionFacade {

    public File convertVideo(String fileName, String format) {
        log.info("VideoConversionFacade: conversion started.");

        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);

        final String mp4 = "mp4";
        Codec destinationCodec = Objects.equals(format, format) ? new MPEG4CompressionCodec() : new OggCompressionCodec();

        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);

        File result = new AudioMixer().fix(intermediateResult);

        log.info("VideoConversionFacade: conversion completed.");
        return result;
    }
}
