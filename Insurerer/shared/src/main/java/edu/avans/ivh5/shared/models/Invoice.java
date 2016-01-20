package edu.avans.ivh5.shared.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Invoice implements Serializable {

    private int invoiceNumber;
    private Date date, expirationDate;
    private BigDecimal VAT;
    private String treatmentStatus;
    
    private String BSN;
    private String clientName;
    private String clientAddress;
    private String clientPostcodeCity;
    
    private String companyName;
    private String companyAddress;
    private String companyPostcodeCity;
    private String companyKVK;
    
    private String amountSessions;
    private String pricePerSession;
    private String treatmentCode;
    private BigDecimal totalPrice;
    
    private BigDecimal deductible;
    private BigDecimal amountToPay;
    
    private boolean paid;

    public Invoice(int invoiceNumber, Date date, Date expirationDate, BigDecimal VAT, String treatmentStatus, Treatment treatment) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.expirationDate = expirationDate;
        this.VAT = VAT;
        this.treatmentStatus = treatmentStatus;
    }

    public Invoice(int invoiceNumber, Date date, Date expirationDate, BigDecimal VAT, String treatmentStatus, String BSN, String clientName, String clientAddress, String clientPostcodeCity, String companyName, String companyAddress, String companyPostcodeCity, String companyKVK, String amountSessions, String pricePerSession, String treatmentCode, BigDecimal deductible, BigDecimal amountToPay, boolean paid) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.expirationDate = expirationDate;
        this.VAT = VAT;
        this.treatmentStatus = treatmentStatus;
        this.BSN = BSN;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientPostcodeCity = clientPostcodeCity;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPostcodeCity = companyPostcodeCity;
        this.companyKVK = companyKVK;
        this.amountSessions = amountSessions;
        this.pricePerSession = pricePerSession;
        this.treatmentCode = treatmentCode;
        this.deductible = deductible;
        this.amountToPay = amountToPay;
        this.paid = paid;
        
        BigDecimal vatPercentage = VAT.divide(new BigDecimal("100"));
        vatPercentage = vatPercentage.add(new BigDecimal("1"));
        this.totalPrice = new BigDecimal(amountSessions).multiply(new BigDecimal(pricePerSession));
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
    
    public String getTreatmentStatus(){
        return treatmentStatus;
    }
    
    /*public BigDecimal getTotalAmount() {
        BigDecimal treatmentPrice = treatment.getPrice();
        BigDecimal treatmentAmount = new BigDecimal(treatment.getAmountSessions());
        
     //   BigDecimal treatmentPrice = new BigDecimal(2);
     //   BigDecimal treatmentAmount = new BigDecimal(3);
        System.out.println("Told you so: " + treatmentPrice + " " + treatmentAmount);
        // Price * amount * vat
        return treatmentPrice.multiply(treatmentAmount).multiply(VAT);
    }*/

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientPostcodeCity() {
        return clientPostcodeCity;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyPostcodeCity() {
        return companyPostcodeCity;
    }

    public String getCompanyKVK() {
        return companyKVK;
    }

    public String getAmountSessions() {
        return amountSessions;
    }

    public String getPricePerSession() {
        return pricePerSession;
    }

    public String getTreatmentCode() {
        return treatmentCode;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public String getBSN() {
        return BSN;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BigDecimal getDeductible() {
        return deductible;
    }

    public BigDecimal getAmountToPay() {
        return amountToPay;
    }

    public boolean isPaid() {
        return paid;
    }
    
}
