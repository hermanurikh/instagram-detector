package com.qbutton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateProvider {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd_MM_yyyy");

    public static String today() {
        LocalDate today = LocalDate.now();
        return FORMATTER.format(today);
    }

    public static String yesterday() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return FORMATTER.format(yesterday);
    }

    public static String dayBefore(String day) {
        LocalDate current = LocalDate.parse(day, FORMATTER);
        return FORMATTER.format(current.minusDays(1));
    }
}
