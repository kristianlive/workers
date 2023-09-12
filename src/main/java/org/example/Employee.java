package org.example;

import java.util.ArrayList;

public class Employee {

    public ArrayList<Employee> employees;

    public String name;
    public int id;
    public String gender;
    public int salary;
    public String startDate;
    public String endDate;
    public String credentials;


    public Employee(String name, int id, String gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public String getValues() {
        return "Employee name: " + name + ". Id: " + id + ". Gender: " + gender;
    }


    public Employee(){

    }

    public void setValuesEmployee (String name, int id,String gender){
        this.name = name;
        this.id = id;
        this.gender = gender;

    }

    public String getValuesEmployee(){
        String info = "Employee name:"+name + ". Id:"+id+". Gender:"+gender;
        return info;
    }

    public void setValuesWorker(String name, int id,String gender,int salary,String startDate){
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
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
    public String getDetails() {
        return getValues();
    }


    }
