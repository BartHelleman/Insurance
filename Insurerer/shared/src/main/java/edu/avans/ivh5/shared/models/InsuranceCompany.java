package edu.avans.ivh5.shared.models;

import java.io.Serializable;

public class InsuranceCompany implements Serializable {

    private String name;
    private String city;
    private String postcode;
    private String address;
    private String KVK;

    public InsuranceCompany(String name, String city, String postcode, String address, String KVK) {
        this.name = name;
        this.city = city;
        this.postcode = postcode;
        this.address = address;
        this.KVK = KVK;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postcode;
    }

    public String getAddress() {
        return address;
    }

    public String getKVK() {
        return KVK;
    }

}
