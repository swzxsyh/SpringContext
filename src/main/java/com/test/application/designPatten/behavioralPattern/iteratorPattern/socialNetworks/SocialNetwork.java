package com.test.application.designPatten.behavioralPattern.iteratorPattern.socialNetworks;

import com.test.application.designPatten.behavioralPattern.iteratorPattern.iterators.ProfileIterator;

/**
 * 定义通用的社交网络接口
 *
 * @author swzxsyh
 */
public interface SocialNetwork {

    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
