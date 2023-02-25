package com.test.application.designPatten.behavioralPattern.iteratorPattern;

import com.test.application.designPatten.behavioralPattern.iteratorPattern.profile.Profile;
import com.test.application.designPatten.behavioralPattern.iteratorPattern.socialNetworks.Facebook;
import com.test.application.designPatten.behavioralPattern.iteratorPattern.socialNetworks.LinkedIn;
import com.test.application.designPatten.behavioralPattern.iteratorPattern.socialNetworks.SocialNetwork;
import com.test.application.designPatten.behavioralPattern.iteratorPattern.spammer.SocialSpammer;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Slf4j
public class Demo {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        log.info("Please specify social network to target spam tool (default:Facebook):");
        log.info("1. Facebook");
        log.info("2. LinkedIn");

        String choice = scanner.nextLine();

        SocialNetwork network = Objects.equals("2", choice) ? new LinkedIn(createTestProfiles()) : new Facebook(createTestProfiles());

        SocialSpammer spammer = new SocialSpammer(network);
        spammer.sendSpamToFriends("anna.smith@bing.com", "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?");
        spammer.sendSpamToCoworkers("anna.smith@bing.com", "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].");
    }

    public static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));
        return data;
    }
}
