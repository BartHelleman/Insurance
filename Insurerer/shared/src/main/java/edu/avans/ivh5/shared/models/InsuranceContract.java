package edu.avans.ivh5.shared.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InsuranceContract implements Serializable {

    private String BSN;
    private BigDecimal ownRisk;
    private String clientName;
    private int insuranceID;
    private Date startDate;
    private Date endDate;

    public InsuranceContract(String BSN, BigDecimal ownRisk, String clientName, int insuranceID, Date startDate, Date endDate) {
        this.BSN = BSN;
        this.ownRisk = ownRisk;
        this.clientName = clientName;
        this.insuranceID = insuranceID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public InsuranceContract(InsuranceContract contract) {
        this.BSN = contract.BSN;
        this.ownRisk = contract.ownRisk;
        this.clientName = contract.clientName;
        this.insuranceID = contract.insuranceID;
        this.startDate = contract.startDate;
        this.endDate = contract.endDate;
    }
    
    
    
    public String getBSN() {
        return BSN;
    }

    public InsuranceContract(BigDecimal ownRisk, String clientName, Integer insuranceID, Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public BigDecimal getOwnRisk() {
        return ownRisk;
    }
    
    public void setOwnRisk(BigDecimal newValue)
    {
        this.ownRisk = newValue;
    }

    public String getClientName() {
        return clientName;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    
    
}
