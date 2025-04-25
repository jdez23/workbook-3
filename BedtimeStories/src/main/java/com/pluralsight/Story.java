package com.pluralsight;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Story {
    Scanner sc = new Scanner(System.in);

    public String menu() {
        System.out.println("Pick a story from the options below:");
        System.out.println("a) Goldi Locks");
        System.out.println("b) Hansel and Gretel");
        System.out.println("c) Mary Had a Little Lamb");

        return sc.nextLine();
    }

    public void getStory(String choice) {
        try
        {
            if (Objects.equals(choice, "a")) {
                choice = "goldilocks.txt";
            } else if (Objects.equals(choice, "b")) {
                choice = "hansel_and_gretel.txt";
            } else {
                choice = "mary_had_a_little_lamb.txt";
            }

            // create a FileInputStream object pointing to
            // a specific file
            FileInputStream fis = new FileInputStream(choice);
            // create a Scanner to reference the file to be read
            Scanner scanner = new Scanner(fis);
            String input;

            // read until there is no more data
            while(scanner.hasNextLine()) {
                input = scanner.nextLine();
                System.out.println(input);
            }
            // close the scanner and release the resources
            scanner.close();
        }
        catch(IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }

    }
}
