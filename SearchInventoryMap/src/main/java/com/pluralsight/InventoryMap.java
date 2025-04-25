package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class InventoryMap {
    private HashMap<String, Product> inventory;

    public InventoryMap() {
        inventory = new HashMap<>();
        loadInventory();
    }

    private void loadInventory() {
        try {
            // Open the Inventory.csv file
            BufferedReader reader = new BufferedReader(new FileReader("Inventory.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line into parts
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    // Parse the parts into correct types
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);

                    // Create a new Product and add it to the HashMap
                    Product product = new Product(id, name, price);
                    inventory.put(name, product);  // product name is the key
                }
            }

            reader.close();  // Always close the file

        } catch (IOException e) {
            System.out.println("ERROR: Could not read the inventory file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid number format in inventory file.");
            e.printStackTrace();
        }
    }

    public void searchProductByName(String name) {
        Product product = inventory.get(name);

        if (product != null) {
            System.out.printf("Found Product - ID: %d | Name: %s | Price: $%.2f%n",
                    product.getId(), product.getName(), product.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }
}
