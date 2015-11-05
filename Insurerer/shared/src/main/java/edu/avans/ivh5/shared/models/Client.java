package edu.avans.ivh5.shared.models;

import com.itextpdf.text.pdf.PdfPTable;
import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {

    public static String getName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String BSN, tel;
    private String name, firstName, city, postcode, address, IBAN, email;
    private boolean incasso;
    
    //relaties
    private ArrayList<Invoice> invoice;
    private InsuranceContract contract;
    
    public Client(String BSN, String name, String firstName, String city, String postcode, String address, String IBAN, Boolean incasso, String email, String tel){
        this.BSN = BSN;
        this.name = name;
        this.firstName = firstName;
        this.city = city;
        this.postcode = postcode;
        this.address = address;
        this.IBAN = IBAN;
        this.incasso = incasso;
        this.email = email;
        this.tel = tel;
    }

    public String getBSN() {
        return BSN;
    }

    public String getTel() {
        return tel;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getAddress() {
        return address;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getEmail() {
        return email;
    }

    public boolean isIncasso() {
        return incasso;
    }

    public void add(PdfPTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
