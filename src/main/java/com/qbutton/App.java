package com.qbutton;

import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        String today = DateProvider.today();
        Path todayPath = PathProvider.provide(today);
        Optional<String> todayFile = FileReader.read(todayPath);
        if (!todayFile.isPresent()) {
            throw new IllegalArgumentException("today's file should not be absent");
        }

        int previousDaysAllowedGap = 30;
        String lastDay = today;
        Optional<String> previousFile = Optional.empty();
        while (previousDaysAllowedGap > 0 && !previousFile.isPresent()) {
            String possibleFileName = DateProvider.dayBefore(lastDay);
            Path possiblePath = PathProvider.provide(possibleFileName);
            previousFile = FileReader.read(possiblePath);
            previousDaysAllowedGap--;
            lastDay = possibleFileName;
        }

        if (!previousFile.isPresent()) {
            System.out.println("No data for previous day. Aborting detection." );
            return;
        }

        Set<String> todayFollowers = HtmlFileParser.getFollowers(todayFile.get());
        Set<String> previousFollowers = HtmlFileParser.getFollowers(previousFile.get());

        SubscribersComparator.compare(previousFollowers, todayFollowers);
    }
}
