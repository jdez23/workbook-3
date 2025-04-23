package com.pluralsight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Product p1 = new Product(1, "Laptop", 99.99, 10);

        List<Product> products = ProductReader.readProductFromCSV("product.csv");

        for (Product p : products){
            System.out.println("Product: " + p.getName());
        }

    }
}