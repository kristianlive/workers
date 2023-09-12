package org.example;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Worker("Kristian Shneltser", 1, "Male", 50000, "2022-05-05"));
        employees.add(new Worker("Max Bayern", 2, "Male", 20000, "2022-05-05"));
        employees.add(new Worker("Iva Mårtensson",3,"Female",40000,"2022-05-05"));
        employees.add(new Worker("Alexa Mårtensson",4,"Female",45000,"2022-05-05"));
        employees.add(new Trainee("Anna Svensson", 5, "Female",  "2024-05-05","Bra Person"));
        employees.add(new Trainee("Clementin Citrunsson",6,"Male","2025-05-05","Så där Person"));
        employees.add(new Worker("Boss",7,"Male",70000,"2020-05-05"));

        Menu menu = new Menu(employees);

    }
}