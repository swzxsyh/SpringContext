package com.test.application.designPatten.structuralPattern.proxyPattern.proxy;

import com.test.application.designPatten.structuralPattern.proxyPattern.someCoolMediaLibrary.ThirdPartyYouTubeClass;
import com.test.application.designPatten.structuralPattern.proxyPattern.someCoolMediaLibrary.ThirdPartyYouTubeLib;
import com.test.application.designPatten.structuralPattern.proxyPattern.someCoolMediaLibrary.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Objects;

@Slf4j
public class YoutubeCacheProxy implements ThirdPartyYouTubeLib {

    private ThirdPartyYouTubeLib youTubeService;
    private HashMap<String, Video> cachePopular = new HashMap<>();
    private HashMap<String, Video> cacheAll = new HashMap<>();

    public YoutubeCacheProxy() {
        this.youTubeService = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (CollectionUtils.isEmpty(cachePopular)) {
            cachePopular = youTubeService.popularVideos();
        } else {
            log.info("Retrieved list from cache.");
        }

        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (Objects.isNull(video)) {
            video = youTubeService.getVideo(videoId);
        } else {
            log.info("Retrieved video {} from cache.", videoId);
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}
