
package edu.avans.ivh5.shared.models;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author startklaar
 */
public class TreatmentCode implements Serializable {

    private String name;
    private String treatmentCode;
    private BigDecimal priceSession;

    public TreatmentCode(String name, String code, BigDecimal priceSession) {
        this.name = name;
        this.treatmentCode = code;
        this.priceSession = priceSession;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return treatmentCode;
    }

    public BigDecimal getPrice() {
        return priceSession;
    }
}
