package com.test.application.designPatten.behavioralPattern.statePattern.ui;


import com.test.application.designPatten.behavioralPattern.statePattern.states.ReadyState;
import com.test.application.designPatten.behavioralPattern.statePattern.states.State;

import java.util.ArrayList;
import java.util.List;

/**
 * 播放器的主要代码
 *
 * @author swzxsyh
 */
public class Player {

    private State state;
    private boolean playing = false;
    private List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        this.state = new ReadyState(this);
        setPlaying(Boolean.TRUE);
        for (int i = 0; i <= 12; i++) {
            playlist.add("Track" + i);
        }
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    public String startPlayback() {
        return "Playing" + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return "Playing" + playlist.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return "Playing" + playlist.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}
