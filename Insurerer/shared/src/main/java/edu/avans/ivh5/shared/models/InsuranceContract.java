package edu.avans.ivh5.shared.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class InsuranceContract implements Serializable {

    private String BSN;
    private BigDecimal ownRisk;
    private String clientName;
    private int insuranceID;
    private Date startDate;
    private Date endDate;
    private List<String> coveredTreatments;

    public InsuranceContract(String BSN, BigDecimal ownRisk, String clientName, int insuranceID, Date startDate, Date endDate, List<String> coveredTreatments) {
        this.BSN = BSN;
        this.ownRisk = ownRisk;
        this.clientName = clientName;
        this.insuranceID = insuranceID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coveredTreatments = coveredTreatments;
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

    public List<String> getCoveredTreatments() {
        return coveredTreatments;
    }
    
}
