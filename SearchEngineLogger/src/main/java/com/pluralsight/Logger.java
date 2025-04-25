package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private String logFileName = "logs.txt";  // name of the file where logs will be stored
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  // format for the timestamp

    // Constructor - runs when a Logger object is created
    public Logger() {
        logAction("launch");  // When we start the app, we log that the app was launched
    }

    // Method to write an action into the log file
    public void logAction(String action) {
        try {
            // Open the log file in append mode
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFileName, true));

            // Get the current date and time
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(formatter);

            // Write the log entry
            writer.write(timestamp + " " + action);
            writer.newLine();  // go to a new line

            // Always close the writer when finished
            writer.close();

        } catch (IOException e) {
            System.out.println("Error: Could not write to log file.");
            e.printStackTrace();
        }
    }
}
