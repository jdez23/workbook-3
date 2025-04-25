package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("1. MM/DD/YYYY: " + FormatHelper.formatMMDDYYYY(date));
        System.out.println("2. ISO format: " + FormatHelper.formatISO(date));
        System.out.println("3. Full Month Format: " + FormatHelper.formatFullMonth(date));
        System.out.println("4. GMT Time: " + FormatHelper.formatWithDayTimeGMT());
        System.out.println("5. Custom Local Time: " + FormatHelper.formatLocalCustom(dateTime));
    }
}
