package com.pluralsight;

import java.util.ArrayList;

public class Inventory {
    // Step 1: Create an ArrayList to hold Product objects
    private ArrayList<Product> products;

    // Step 2: Constructor initializes the ArrayList and adds products
    public Inventory() {
        products = new ArrayList<>();

        // Add at least 5 products to the inventory
        products.add(new Product(101, "Hammer", 19.99));
        products.add(new Product(102, "Screwdriver", 9.49));
        products.add(new Product(103, "Wrench", 14.79));
        products.add(new Product(104, "Drill", 49.99));
        products.add(new Product(105, "Tape Measure", 7.99));
    }

    // Step 3: Method to display all products
    public void displayProducts() {
        System.out.println("Store Inventory:");
        for (Product product : products) {
            System.out.printf("ID: %d | Name: %s | Price: $%.2f%n",
                    product.getId(), product.getName(), product.getPrice());
        }
    }
}
