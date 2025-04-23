package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, pick a story!");

        Story story = new Story();

        String choice = story.menu();
        story.getStory(choice);

    }
}