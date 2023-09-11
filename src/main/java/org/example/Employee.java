package org.example;

import java.util.ArrayList;

public class Employee {

    public String name;
    public int id;
    public String gender;
    public int salary;
    public String startDate;
    public String endDate;
    public String credentials;

    public Employee(String name, int id,String gender,int salary,String startDate){
        System.out.println("Object Created");
        setValuesWorker(name,id,gender,salary,startDate);
        System.out.println(getValuesWorker());
    }

    public Employee(String name, int id,String gender,String endDate,String credentials){
        System.out.println("Object Created");
        setValuesTrainee(name,id,gender,endDate,credentials);
        System.out.println(getValuesAll());
    }


    public Employee(){

    }

    public void setValuesWorker(String name, int id,String gender,int salary,String startDate){
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
    }

    public String getValuesWorker(){
        String info = "Employee name:"+name + ". Id:"+id+". Gender:"+gender +". Salary:" + salary+". Start Date:"+ startDate;
        return info;
    }

    public void setValuesTrainee(String name, int id,String gender,String endDate,String credentials){
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.endDate = endDate;
        this.credentials = credentials;
    }


    public int getSalary(){
        String info = "Salary Info: " + salary;
        return salary;
    }

    public String getValuesAll() {

        StringBuilder info = new StringBuilder("Employee name: " + name + ". Id:" + id + ". Gender:" + gender);

        if (salary != 0) {
            info.append(". Salary:" + salary);
        }

        if (startDate != null) {
            info.append(". Start Date:" + startDate);
        }

        if (endDate != null) {
            info.append(". End Date:" + endDate);
        }

        if (credentials != null) {
            info.append(". Credentials: " + credentials);
        }

        return info.toString();
    }

    public static int calculateAverageSalaryForWomen (ArrayList <Employee> employees) {
        int totalSalaryWomen = 0;
        int countWomen = 0;

        for (Employee employee : employees) {
            int infoSalary = employee.getSalary();
            if ("Female".equals(employee.gender) && infoSalary > 0) {
                totalSalaryWomen += infoSalary;
                countWomen++;
            }
        }


        if (countWomen == 0) {
            return 0;
        } else {
            return totalSalaryWomen / countWomen;
        }
    }

    public static int calculateAverageSalaryForMen(ArrayList<Employee> employees) {
        int totalSalaryMen = 0;
        int countMen = 0;

        for (Employee employee : employees) {
            int infoSalary = employee.getSalary();
            if ("Male".equals(employee.gender) && infoSalary > 0) {
                totalSalaryMen += infoSalary;
                countMen++;
            }
        }

        if (countMen == 0) {
            return 0;
        } else {
            return totalSalaryMen / countMen;
        }


        }


    }
