package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Employee {
    private ArrayList<Employee> employees;

    public Menu (ArrayList<Employee>employees){


        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Show All Employees");
            System.out.println("2. Salary Information");
            System.out.println("3. Option 3");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Showing all Employees(Total: "+employees.size() + ")" );
                        for (Employee employee : employees){
                            System.out.println(employee.getValuesAll());
                        }

                    System.out.println("********************--------------*******************");
                    break;
                case 2:
                    System.out.println("Showing Salary Information:");

                    int averageSalaryWomen = Employee.calculateAverageSalaryForWomen(employees);
                    int averageSalaryMen = Employee.calculateAverageSalaryForMen(employees);
                    System.out.println("Average Salary for Women: " + averageSalaryWomen +
                            "\nAverage Salary for Man: " + averageSalaryMen  );

                    System.out.println("********************--------------*******************");
                    break;
                case 3:
                    System.out.println("You chose Option 3");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
