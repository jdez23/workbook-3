package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class ProductReader {

    public static List<Product> readProductFromCSV(String fileName) {
        // Pseudocode is breaking prob down to steps in plain English

        List<Product> productList = new ArrayList<>();

        // Step 0 - Try/Catch method
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            // Skip the first line (it contains column names like id,name,price,stock)
            reader.readLine();

            String line;


            // Step 1 - Read File
            while ((line = reader.readLine()) != null) {
                // Split the line into parts, using comma as the separator
                String[] parts = line.split(",");

                // Check if the line has exactly 4 parts (id, name, price, stock)
                if (parts.length == 4) {
                    // Step 2 - Store data into variables
                    int id = Integer.parseInt(parts[0]);        // Convert the first part to an integer (ID)
                    String name = parts[1];                     // Get the name as text
                    double price = Double.parseDouble(parts[2]); // Convert price to a decimal number
                    int stock = Integer.parseInt(parts[3]);     // Convert stock to an integer

                    // Create a new Product object using the parts
                    // Step 3 Create product
                    Product p = new Product(id, name, price, stock);

                    // Add the product to the list
                    // Step 4 Add the product to the product list
                    productList.add(p);
                    System.out.println(p.getName() + "Product was added");
                }
            }
        } catch (IOException e) {
//          Print error message
            System.out.println("Something went wrong");
        }


        return productList;
    }
}
