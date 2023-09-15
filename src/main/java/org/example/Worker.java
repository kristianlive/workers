package org.example;
import java.io.Serializable;
import java.util.ArrayList;

import java.time.LocalDate;
public class Worker extends Employee implements Serializable {


    public ArrayList<Worker> workers;

    public int salary;
    public LocalDate startDate;
    private static final long serialVersionUID = 1L;



    public Worker(String name, int id,String gender,int salary,LocalDate startDate){
        super(name, id, gender);
        this.salary = salary;
        this.startDate = startDate;
    }

    public String getValuesWorker(){
        String info = "Employee name:"+name + ". Id:"+id+". Gender:"+gender +". Salary:" + salary+". Start Date:"+ startDate;
        return info;
    }
    public String getDetails() {
        return getValuesWorker();
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public LocalDate getStartDate() {
        return startDate; // or some default value if desired
    }

}
