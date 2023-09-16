package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.List;




public class Menu {
    private ArrayList<Employee> employees;

    public Menu(ArrayList<Employee> employees) {

        this.employees = employees;
        startMenu();
    }

    public void startMenu() {


        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("------------ Employee Management System ------------");
            System.out.println("1. Show All Employees");
            System.out.println("2. Average Salary Information");
            System.out.println("3. Show Earliest-Latest Worker");
            System.out.println("4. Admin Panel");
            System.out.println("5. Save & Exit");

            System.out.print("Enter your choice(1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Showing all Employees(Total: " + employees.size() + ")...");
                    for (Employee employee : employees) {
                        System.out.println(employee.getDetails());
                    }

                    System.out.println("----------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Showing Salary Information...");

                    int averageSalaryWomen = Employee.calculateAverageSalaryForWomen(employees);
                    int averageSalaryMen = Employee.calculateAverageSalaryForMen(employees);
                    System.out.println("Average Salary for Women: " + averageSalaryWomen +
                            "\nAverage Salary for Man: " + averageSalaryMen);

                    System.out.println("----------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("Showing Earliest-Latest Worker...");

                    List<Employee> workerList = employees.stream()
                            .filter(e -> e instanceof Worker)
                            .collect(Collectors.toList());

                    workerList.sort((e1, e2) -> {
                        if (((Worker) e1).getStartDate() == null) return -1;
                        if (((Worker) e2).getStartDate() == null) return 1;
                        return ((Worker) e1).getStartDate().compareTo(((Worker) e2).getStartDate());
                    });
                    for (Employee worker : workerList) {
                        System.out.println(worker.getDetails());
                    }

                    System.out.println("----------------------------------------------------------");

                    break;
                case 4:
                    int adminChoice;
                    do {
                        System.out.println("Admin Panel:");
                        System.out.println("1. Add Employee");
                        System.out.println("2. Remove Employee");
                        System.out.println("3. Modify Employee Details");
                        System.out.println("4. Back to Main Menu");

                        System.out.print("Enter your choice: ");
                        adminChoice = scanner.nextInt();

                        switch(adminChoice) {
                            case 1:
                                addEmployee();
                                break;
                            case 2:
                                System.out.println("Remove Employee:");
                                removeEmployee();
                                break;
                            case 3:
                                System.out.println("Modify Employee Details:");
                                modifyEmployeeDetails();
                                break;
                            case 4:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }

                    } while(adminChoice != 4);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();

    }

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the type of Employee (Employee/Worker/Trainee): ");
        String type = scanner.next();

        System.out.print("Enter name: ");
        String name = scanner.next();

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter gender: ");
        String gender = scanner.next();

        if ("Worker".equalsIgnoreCase(type)) {
            System.out.print("Enter salary: ");
            int salary = scanner.nextInt();

            System.out.print("Enter start date (YYYY-MM-DD): ");
            LocalDate startDate = LocalDate.parse(scanner.next());

            employees.add(new Worker(name, id, gender, salary, startDate));
        } else if ("Trainee".equalsIgnoreCase(type)) {
            System.out.print("Enter end date (YYYY-MM-DD): ");
            String endDate = scanner.next();

            System.out.print("Enter credentials: ");
            String credentials = scanner.next();

            employees.add(new Trainee(name, id, gender, endDate, credentials));
        } else {
            employees.add(new Employee(name, id, gender));
        }

        System.out.println(type + " added successfully!");
    }

    public void removeEmployee() {
        Scanner scanner = new Scanner(System.in);

        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName());
        }

        System.out.print("Enter the ID of the employee to remove: ");
        int idToRemove = scanner.nextInt();

        boolean removed = employees.removeIf(employee -> employee.getId() == idToRemove);

        if (removed) {
            System.out.println("Employee with ID " + idToRemove + " has been removed.");
        } else {
            System.out.println("No employee found with ID " + idToRemove);
        }
    }

    public void modifyEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);

        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName());
        }

        System.out.print("Enter the ID of the employee you want to modify: ");
        int idToModify = scanner.nextInt();
        Employee foundEmployee = null;

        for (Employee employee : employees) {
            if (employee.getId() == idToModify) {
                foundEmployee = employee;
                break;
            }
        }

        if (foundEmployee != null) {
            System.out.println("Which details would you like to modify for " + foundEmployee.getName() + "?");
            System.out.println("1. Name");
            System.out.println("2. Gender");
            if (foundEmployee instanceof Worker) {
                System.out.println("3. Salary");
                System.out.println("4. Start Date (YYYY-MM-DD)");
            } else if (foundEmployee instanceof Trainee) {
                System.out.println("3. End Date (YYYY-MM-DD)");
                System.out.println("4. Credentials");
            }
            int detailChoice = scanner.nextInt();

            switch (detailChoice) {
                case 1:
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    foundEmployee.name = newName;
                    break;
                case 2:
                    System.out.print("Enter new gender: ");
                    String newGender = scanner.next();
                    foundEmployee.gender = newGender;
                    break;
                case 3:
                    if (foundEmployee instanceof Worker) {
                        System.out.print("Enter new salary: ");
                        int newSalary = scanner.nextInt();
                        ((Worker) foundEmployee).salary = newSalary;
                    } else if (foundEmployee instanceof Trainee) {
                        System.out.print("Enter new end date: ");
                        String newEndDate = scanner.next();
                        ((Trainee) foundEmployee).endDate = newEndDate;
                    }
                    break;
                case 4:
                    if (foundEmployee instanceof Worker) {
                        System.out.print("Enter new start date (YYYY-MM-DD): ");
                        LocalDate newStartDate = LocalDate.parse(scanner.next());
                        ((Worker) foundEmployee).startDate = newStartDate;
                    } else if (foundEmployee instanceof Trainee) {
                        System.out.print("Enter new credentials: ");
                        String newCredentials = scanner.next();
                        ((Trainee) foundEmployee).credentials = newCredentials;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. No changes made.");
                    break;
            }

            System.out.println("Details updated successfully!");

        } else {
            System.out.println("No employee found with ID " + idToModify);
        }
    }

}


