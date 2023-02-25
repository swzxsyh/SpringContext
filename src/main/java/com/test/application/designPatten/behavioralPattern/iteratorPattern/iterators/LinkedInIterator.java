package com.test.application.designPatten.behavioralPattern.iteratorPattern.iterators;

import com.test.application.designPatten.behavioralPattern.iteratorPattern.profile.Profile;
import com.test.application.designPatten.behavioralPattern.iteratorPattern.socialNetworks.Facebook;
import com.test.application.designPatten.behavioralPattern.iteratorPattern.socialNetworks.LinkedIn;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 在领英档案上实现迭代
 *
 * @author swzxsyh
 */
public class LinkedInIterator implements ProfileIterator {


    private LinkedIn linkedIn;
    private String type;
    private String email;
    private int currentPosition = 0;
    private List<String> emails = new ArrayList<>();
    private List<Profile> profiles = new ArrayList<>();

    public LinkedInIterator(LinkedIn linkedIn, String type, String email) {
        this.linkedIn = linkedIn;
        this.type = type;
        this.email = email;
    }

    private void lazyLoad() {
        if (CollectionUtils.isEmpty(emails)) {
            List<String> profiles = linkedIn.requestProfileFriendsFromLinkedInApi(this.email, this.type);
            if (CollectionUtils.isEmpty(profiles)) {
                return;
            }
            for (String profile : profiles) {
                this.emails.add(profile);
                this.profiles.add(null);
            }

        }
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition < emails.size();
    }

    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }
        String friendEmail = emails.get(currentPosition);
        Profile friendProfile = profiles.get(currentPosition);
        if (Objects.isNull(friendProfile)) {
            friendProfile = linkedIn.requestProfileFromLinkedInApi(friendEmail);
            profiles.set(currentPosition, friendProfile);
        }
        currentPosition++;
        return friendProfile;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
