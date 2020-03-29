package com.qbutton;

import java.util.Optional;
import java.util.Set;

public class App {

    private static final String PATH = "/Users/gurikh/Documents/Instagram/Subscribers/%s/subscribers.txt";

    public static void main(String[] args) {

        String today = DateProvider.today();
        String yesterday = DateProvider.yesterday();

        String todayPath = String.format(PATH, today);
        String yesterdayPath = String.format(PATH, yesterday);

        Optional<String> todayFile = FileReader.read(todayPath);
        if (!todayFile.isPresent()) {
            throw new IllegalArgumentException("today's file should not be absent");
        }

        Optional<String> yesterdayFile = FileReader.read(yesterdayPath);

        if (!yesterdayFile.isPresent()) {
            System.out.println("No data for yesterday. Aborting detection." );
            return;
        }

        Set<String> todayFollowers = HtmlFileParser.getFollowers(todayFile.get());
        Set<String> yesterdayFollowers = HtmlFileParser.getFollowers(yesterdayFile.get());

        SubscribersComparator.compare(yesterdayFollowers, todayFollowers);
    }
}
