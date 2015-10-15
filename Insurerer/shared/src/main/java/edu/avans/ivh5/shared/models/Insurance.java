package edu.avans.ivh5.shared.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Insurance implements Serializable{

    private int ID, sessionsReimbursed;
    private String name;
    private BigDecimal price;

    //relaties
    private ArrayList<Treatment> treatment = new ArrayList<>();
    private ArrayList<InsuranceContract> contract = new ArrayList<>();
    private InsuranceCompany company;

    public Insurance(int ID, int sessionsReimbursed, String name, BigDecimal price) {
        this.ID = ID;
        this.sessionsReimbursed = sessionsReimbursed;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public int getSessionsReimbursed() {
        return sessionsReimbursed;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
