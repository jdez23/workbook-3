package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a Scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Log launch
        Logger logger = new Logger();

        // Start a loop to ask the user for search terms
        String userInput = "";

        while (true) {
            System.out.print("Enter a search term (X to exit): ");
            userInput = scanner.nextLine();  // read user input

            if (userInput.equalsIgnoreCase("X")) {
                logger.logAction("exit");  // log that the user is exiting
                System.out.println("Goodbye!");
                break;  // exit the loop and end the program
            } else {
                logger.logAction("search: " + userInput);  // log the search action
                System.out.println("Searching for: " + userInput);
            }
        }

        scanner.close();  // Always close the scanner
    }
}
