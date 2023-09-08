package org.example;

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
        System.out.println(getValuesTrainee());
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

    public String getValuesTrainee(){
        String info = "Employee name:"+name + ". Id:"+id+". Gender:"+gender +". EndDate:" + endDate+". Credentials:"+ credentials;
        return info;
    }

}
