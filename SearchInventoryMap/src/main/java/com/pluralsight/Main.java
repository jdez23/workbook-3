package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InventoryMap inventory = new InventoryMap();

        String userInput = "";

        while (true) {
            System.out.print("Enter a product name to search (X to exit): ");
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("X")) {
                System.out.println("Goodbye!");
                break;
            } else {
                inventory.searchProductByName(userInput);
            }
        }

        scanner.close();
    }
}
