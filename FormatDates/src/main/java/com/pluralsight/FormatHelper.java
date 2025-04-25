package com.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class FormatHelper {

    public static String formatMMDDYYYY(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }

    public static String formatISO(LocalDate date) {
        return date.toString();  // default format is ISO 8601
    }

    public static String formatFullMonth(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        return date.format(formatter);
    }

    public static String formatWithDayTimeGMT() {
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy  HH:mm");
        return gmtTime.format(formatter);
    }

    public static String formatLocalCustom(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm 'on' dd-MMM-yyyy");
        return dateTime.format(formatter);
    }
}
