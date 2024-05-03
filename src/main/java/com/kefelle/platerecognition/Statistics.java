package com.kefelle.platerecognition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Statistics {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static LocalDateTime today = LocalDateTime.now();

    public static void printCurrDate() {
        System.out.println(formatter.format(today));
    }
}
