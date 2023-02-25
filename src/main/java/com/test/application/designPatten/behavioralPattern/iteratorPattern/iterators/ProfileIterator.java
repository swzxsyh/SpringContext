package com.test.application.designPatten.behavioralPattern.iteratorPattern.iterators;

import com.test.application.designPatten.behavioralPattern.iteratorPattern.profile.Profile;

/**
 * 定义档案接口
 *
 * @author swzxsyh
 */
public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();

    void reset();
}
