package edu.avans.ivh5.shared.models;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice {

    private int invoiceNumber;
    private Date date, expirationDate;
    private BigDecimal VAT;
    
    //relaties
    private Treatment treatment;
    private InsuranceCompany company;

    public Invoice(int invoiceNumber, Date date, Date expirationDate, BigDecimal VAT) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.expirationDate = expirationDate;
        this.VAT = VAT;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public Date getDate() {
        return date;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public BigDecimal getVAT() {
        return VAT;
    }
    
    public long getTotalAmount() {
        return 0;
    }
}
