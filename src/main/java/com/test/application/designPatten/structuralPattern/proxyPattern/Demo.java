package com.test.application.designPatten.structuralPattern.proxyPattern;

import com.test.application.designPatten.structuralPattern.proxyPattern.downloader.YoutubeDownloader;
import com.test.application.designPatten.structuralPattern.proxyPattern.proxy.YoutubeCacheProxy;
import com.test.application.designPatten.structuralPattern.proxyPattern.someCoolMediaLibrary.ThirdPartyYouTubeClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

    public static void main(String[] args) {
        YoutubeDownloader naiveDownloader = new YoutubeDownloader(new ThirdPartyYouTubeClass());
        YoutubeDownloader smartDownloader = new YoutubeDownloader(new YoutubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);

        log.info("Time saved by caching proxy: {}ms",naive - smart);
    }

    private static long test(YoutubeDownloader downloader){
        long startTime = System.currentTimeMillis();


        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        log.info("Time elapsed: {} ms\n",estimatedTime);
        return estimatedTime;
    }
}
