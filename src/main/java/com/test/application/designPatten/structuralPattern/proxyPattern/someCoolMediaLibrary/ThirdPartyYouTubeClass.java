package com.test.application.designPatten.structuralPattern.proxyPattern.someCoolMediaLibrary;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {


    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com" + videoId);
        return getSomeVideo(videoId);
    }

    private int random(int min, int max) {
        return min + (int) (Math.random() * (max - min) + 1);
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                log.error("experienceNetworkLatency err:", ex);
            }
        }
    }

    private void connectToServer(String server) {
        log.info("Connecting to {} ... ", server);
        experienceNetworkLatency();
        log.info("Connected! \n");
    }

    private HashMap<String, Video> getRandomVideos() {

        experienceNetworkLatency();
        HashMap<String, Video> hmap = new HashMap<>(8);
        hmap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
        hmap.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
        hmap.put("dancesvideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
        hmap.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
        hmap.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

        log.info("Done! \n");
        return hmap;
    }

    private Video getSomeVideo(String videoId) {
        log.info("Downloading video... ");

        experienceNetworkLatency();
        Video video = new Video(videoId, "Some video title");

        log.info("Done! \n");
        return video;

    }
}
