package com.qbutton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileReader {
    public static Optional<String> read(String stringPath) {
        try {
            Path path = Paths.get(stringPath);
            boolean exists = path.toFile().exists();
            return exists
                    ? Optional.of(String.join("", Files.readAllLines(path)))
                    : Optional.empty();

        } catch (IOException e) {
            System.out.println(e);
            return Optional.empty();
        }
    }
}
