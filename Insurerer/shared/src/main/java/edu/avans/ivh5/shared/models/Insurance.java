package edu.avans.ivh5.shared.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Insurance implements Serializable {

    private String ID;
    private String name;
    private BigDecimal price;

    //relaties
    private List<String> treatments = new ArrayList<>();
    private ArrayList<InsuranceContract> contract = new ArrayList<>();
    private InsuranceCompany company;

    public Insurance(String ID, String name, BigDecimal price, List<String> treatments) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.treatments = treatments;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<String> getTreatments() {
        return treatments;
    }

}
