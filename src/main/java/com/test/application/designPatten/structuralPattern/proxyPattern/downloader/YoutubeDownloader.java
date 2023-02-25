package com.test.application.designPatten.structuralPattern.proxyPattern.downloader;

import com.test.application.designPatten.structuralPattern.proxyPattern.someCoolMediaLibrary.ThirdPartyYouTubeLib;
import com.test.application.designPatten.structuralPattern.proxyPattern.someCoolMediaLibrary.Video;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class YoutubeDownloader {

    private ThirdPartyYouTubeLib api;

    public YoutubeDownloader(ThirdPartyYouTubeLib api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);
        log.info("\n-------------------------------");
        log.info("Video page (imagine fancy HTML)");
        log.info("ID: {}", video.id);
        log.info("Title: {}", video.title);
        log.info("Video: {}", video.data);
        log.info("-------------------------------\n");
    }

    public void renderPopularVideos() {
        HashMap<String, Video> list = api.popularVideos();

        log.info("\n-------------------------------");
        log.info("Most popular videos on YouTube (imagine fancy HTML)");
        for (Video video : list.values()) {
            log.info("ID: {}  / Title: {}", video.id, video.title);
        }
        log.info("-------------------------------\n");
    }
}
