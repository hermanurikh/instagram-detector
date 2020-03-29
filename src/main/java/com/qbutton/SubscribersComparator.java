package com.qbutton;

import java.util.HashSet;
import java.util.Set;

public class SubscribersComparator {
    public static void compare(Set<String> before, Set<String> after) {
        if (before.equals(after)) {
            System.out.format("No difference detected. You have the same %d followers.", after.size());
            return;
        }

        Set<String> unsubscribed = difference(before, after);
        Set<String> newFollowers = difference(after, before);

        if (unsubscribed.isEmpty()) {
            System.out.println("Congrats, no one has unsubscribed!");
        } else {
            System.out.format("%d people have unsubscribed: %s\n", unsubscribed.size(), unsubscribed);
        }

        if (newFollowers.isEmpty()) {
            System.out.println("No new followers.");
        } else {
            System.out.format("%d new followers: %s\n", newFollowers.size(), newFollowers);
        }
    }

    /**
     * Returns all elements present in first set which are not present in second one.
     * @param first first set
     * @param second second set
     * @return elements present in first set which are not present in second one
     */
    private static Set<String> difference(Set<String> first, Set<String> second) {
        Set<String> res = new HashSet<>();

        for (String s : first) {
            if (!second.contains(s)) {
                res.add(s);
            }
        }

        return res;
    }
}
