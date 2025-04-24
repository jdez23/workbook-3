package com.pluralsight;

import java.io.*;

public class PayrollProcessor {
    public void processPayroll(String inputFileName, String outputFileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            FileWriter writer = new FileWriter(outputFileName);

            // Skip header if present
            String header = reader.readLine();
            if (!header.matches("\\d+\\|.+\\|\\d+(\\.\\d+)?\\|\\d+(\\.\\d+)?")) {
                // not a data line, assume header
                writer.write("id|name|gross pay\n");
            } else {
                // rewind if first line is actual data
                reader = new BufferedReader(new FileReader(inputFileName));
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                writer.write(String.format("%d|%s|%.2f\n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getGrossPay()));
            }

            reader.close();
            writer.close();
            System.out.println("Payroll processing complete. Output saved to " + outputFileName);

        } catch (IOException e) {
            System.out.println("Error: An error occurred while processing the payroll.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid data format in input file.");
            e.printStackTrace();
        }
    }
}