package org.example;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Trainee extends Employee implements Serializable {

    public ArrayList<Trainee> trainees;

    public String endDate;
    public String credentials;



    public Trainee(String name, int id, String gender, String endDate, String credentials) {
        super(name, id, gender);
        this.endDate = endDate;
        this.credentials = credentials;
    }

    public String getValuesTrainee() {
        return super.getValues() + ". End Date: " + endDate + ". Credentials: " + credentials;
    }
    public String getDetails() {
        return getValuesTrainee();
    }

}
