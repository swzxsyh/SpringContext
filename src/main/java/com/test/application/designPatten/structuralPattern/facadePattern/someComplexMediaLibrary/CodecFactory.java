package com.test.application.designPatten.structuralPattern.facadePattern.someComplexMediaLibrary;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class CodecFactory {

    public static Codec extract(VideoFile file) {
        final String mp4 = "mp4";
        String type = file.getCodecType();

        if (Objects.equals(type, mp4)) {
            log.info("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        log.info("CodecFactory: extracting ogg audio...");
        return new OggCompressionCodec();
    }
}
