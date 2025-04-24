package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("employees.csv");
            // create a BufferedReader to manage input stream
            BufferedReader reader = new BufferedReader(fileReader);
            // Skip the first line (the header)
            reader.readLine();
            String line;

            // Read line-by-line
            while ((line = reader.readLine()) != null) {
                // Split the line into tokens using |
                String[] tokens = line.split("\\|");

                // Extract values
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                // Create an Employee object
                Employee employee = new Employee(id, name, hoursWorked, payRate);

                // Print employee info
                System.out.printf("ID: %d | Name: %s | Gross Pay: $%.2f\n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getGrossPay());
            }

            // Close the file
            reader.close();

        } catch (IOException e) {
            System.out.println("Error: Could not read the file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: Could not parse number from file.");
            e.printStackTrace();
        }
    }
}

