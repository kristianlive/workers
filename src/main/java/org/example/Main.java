package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = EmployeeDataStorage.loadEmployees();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> { // Hjälper att spara data om man råkat glömma spara data
            EmployeeDataStorage.saveEmployees(employees);
        }));

        if (employees.isEmpty()){ // Den läggs till bara om Local Storage är tom

            employees.add(new Worker("Kristian Shneltser", 1, "Male", 50000, LocalDate.of(2017,5,5)));
            employees.add(new Worker("Max Bayern", 2, "Male", 20000, LocalDate.of(2018,5,5)));
            employees.add(new Worker("Iva Mårtensson",3,"Female",40000,LocalDate.of(2021,5,5)));
            employees.add(new Worker("Alexa Mårtensson",4,"Female",45000,LocalDate.of(2019,5,5)));
            employees.add(new Trainee("Anna Svensson", 5, "Female",  "2024-05-05","Bra Person"));
            employees.add(new Trainee("Clementin Citrunsson",6,"Male","2025-05-05","Så där Person"));
            employees.add(new Worker("Boss",7,"Male",70000, LocalDate.of(2020,5,5)));

        }


        Menu menu = new Menu(employees);
        EmployeeDataStorage.saveEmployees(employees);


    }
}