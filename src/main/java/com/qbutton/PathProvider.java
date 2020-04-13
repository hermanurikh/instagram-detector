package com.qbutton;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathProvider {
    private static final String PATH = "/Users/gurikh/Documents/Instagram/Subscribers/%s/subscribers.txt";

    public static Path provide(String date) {
        String formattedPath = String.format(PATH, date);
        return Paths.get(formattedPath);
    }
}
