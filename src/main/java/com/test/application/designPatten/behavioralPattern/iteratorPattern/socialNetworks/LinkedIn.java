package com.test.application.designPatten.behavioralPattern.iteratorPattern.socialNetworks;

import com.test.application.designPatten.behavioralPattern.iteratorPattern.iterators.LinkedInIterator;
import com.test.application.designPatten.behavioralPattern.iteratorPattern.iterators.ProfileIterator;
import com.test.application.designPatten.behavioralPattern.iteratorPattern.profile.Profile;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 领英
 *
 * @author swzxsyh
 */
@Slf4j
public class LinkedIn implements SocialNetwork{

    private List<Profile> profiles;

    public LinkedIn(List<Profile> cache) {
        if (Objects.nonNull(cache)) {
            this.profiles = cache;
        } else {
            this.profiles = new ArrayList<>();
        }
    }

    public Profile requestProfileFromLinkedInApi(String profileEmail) {
        simulateNetworkLatency();
        log.info("LinkedIn: Loading profile {} over the network...", profileEmail);
        return findProfile(profileEmail);
    }

    public List<String> requestProfileFriendsFromLinkedInApi(String profileEmail, String contactType) {
        simulateNetworkLatency();
        log.info("LinkedIn: Loading {}  list of {} over the network...", contactType, profileEmail);
        Profile profile = findProfile(profileEmail);
        return Objects.nonNull(profile) ? profile.getContacts(contactType) : null;
    }

    private Profile findProfile(String profileEmail) {
        for (Profile profile : profiles) {
            if (profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            log.error("simulateNetworkLatency err:", ex);
        }
    }


    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new LinkedInIterator(this, "friends", profileEmail);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new LinkedInIterator(this, "coworkers", profileEmail);
    }
}
