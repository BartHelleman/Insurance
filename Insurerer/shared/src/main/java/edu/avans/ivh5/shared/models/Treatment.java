package edu.avans.ivh5.shared.models;

import com.itextpdf.text.pdf.PdfPTable;
import java.io.Serializable;
import java.math.BigDecimal;

public class Treatment implements Serializable {

    private String name;
    private String code;
    private BigDecimal priceSession;
    private int amountSessions;

    public Treatment(String name, String code, BigDecimal priceSession, int amountSessions) {
        this.name = name;
        this.code = code;
        this.priceSession = priceSession;
        this.amountSessions = amountSessions;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getAmountSessions() {
        return amountSessions;
    }

    public BigDecimal getPrice() {
        return priceSession;
    }

    public void add(PdfPTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
