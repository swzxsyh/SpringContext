package com.test.application.designPatten.behavioralPattern.iteratorPattern.spammer;

import com.test.application.designPatten.behavioralPattern.iteratorPattern.iterators.ProfileIterator;
import com.test.application.designPatten.behavioralPattern.iteratorPattern.profile.Profile;
import com.test.application.designPatten.behavioralPattern.iteratorPattern.socialNetworks.SocialNetwork;
import lombok.extern.slf4j.Slf4j;

/**
 * 消息发送应用
 *
 * @author swzxsyh
 */
@Slf4j
public class SocialSpammer {

    public SocialNetwork network;
    public ProfileIterator iterator;

    public SocialSpammer(SocialNetwork network) {
        this.network = network;
    }

    public void sendSpamToFriends(String profileEmail, String message) {
        log.info("\nIterating over friends...\n");
        iterator = network.createFriendsIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendSpamToCoworkers(String profileEmail, String message) {
        log.info("\nIterating over coworkers...\n");
        iterator = network.createCoworkersIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendMessage(String email, String message) {
        log.info("Sent message to: {}. Message body: {}", email, message);
    }
}
