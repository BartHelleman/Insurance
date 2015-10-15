package edu.avans.ivh5.shared.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InsuranceContract implements Serializable {

    private BigDecimal ownRisk;
    private String clientName;
    private int insuranceID;
    private Date startDate;
    private Date endDate;

    public InsuranceContract(BigDecimal ownRisk, String clientName, int insuranceID, Date startDate, Date endDate) {
        this.ownRisk = ownRisk;
        this.clientName = clientName;
        this.insuranceID = insuranceID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BigDecimal getOwnRisk() {
        return ownRisk;
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
    
}
