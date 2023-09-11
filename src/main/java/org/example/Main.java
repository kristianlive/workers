package org.example;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Kristian Shneltser", 1, "Male", 50000, "2022-05-05"));
        employees.add(new Employee("Max Bayern", 1, "Male", 20000, "2022-05-05"));
        employees.add(new Employee("Anna Svensson", 2, "Female",  "2024-05-05","Bra Person"));
        employees.add(new Employee("Iva Mårtensson",3,"Female",40000,"2022-05-05"));
        employees.add(new Employee("Alexa Mårtensson",3,"Female",45000,"2022-05-05"));

        Menu menu = new Menu(employees);
    }
}