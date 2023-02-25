package com.test.application.designPatten.structuralPattern.bridgePattern.devices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Radio implements Device {

    private boolean on = false;

    private int volume = 30;

    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = Boolean.TRUE;
    }

    @Override
    public void disable() {
        on = Boolean.FALSE;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else {
            this.volume = Math.max(volume, 0);
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        log.info("------------------------------------");
        log.info("| I'm radio.");
        log.info("| I'm {}", (on ? "enabled" : "disabled"));
        log.info("| Current volume is {}%", volume);
        log.info("| Current channel is {}", channel);
        log.info("------------------------------------\n");
    }
}
