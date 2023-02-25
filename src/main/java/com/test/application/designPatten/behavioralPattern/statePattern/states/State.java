package com.test.application.designPatten.behavioralPattern.statePattern.states;

import com.test.application.designPatten.behavioralPattern.statePattern.ui.Player;

/**
 * 通用状态接口
 *
 * @author swzxsyh
 */
public abstract class State {
    Player player;

    public State(Player player) {
        this.player = player;
    }

    public abstract String onLock();

    public abstract String onPlay();

    public abstract String onNext();

    public abstract String onPrevious();

}
