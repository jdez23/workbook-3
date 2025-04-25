package com.pluralsight;

public class Product {
    // Step 1: Fields (variables) to hold product details
    private int id;
    private String name;
    private double price;

    // Step 2: Constructor (builds a product when we give id, name, and price)
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Step 3: Getter methods to allow reading the private fields

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
