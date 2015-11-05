package edu.avans.ivh5.shared.models;

//import com.itextpdf.text.pdf.PdfPTable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Treatment implements Serializable {

    //relaties
    public Treatment treatments;
    
    private String name;
    private String code;
    private BigDecimal priceSession;
    private int amountSessions;
    private String status; // trying
    private String nameClient; // trying
    private String BSNClient;  // trying

    public Treatment(String name, String code, BigDecimal priceSession, int amountSessions, String status, String nameClient, String BSNClient) {
        this.name = name;
        this.code = code;
        this.priceSession = priceSession;
        this.amountSessions = amountSessions;
        this.status = status; // trying
        this.nameClient = nameClient; //trying
        this.BSNClient = BSNClient; // trying
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


//    public void add(PdfPTable table) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    //trying
    public String getStatus() {
        return status;
    }
    //trying
    public String getNameClient() {
        return nameClient;  
    }
    //trying
    public String getBSNClient() {
        return BSNClient;
    }

    
    public List<Treatment> treatments(){
    List<Treatment> treatments1  = new ArrayList();
    treatments1.add(new Treatment("Test1", "TEST0101", new BigDecimal(50.50), 10, "open", "Pietje", "209000454"));
    treatments1.add(new Treatment("Test2", "TEST0101", new BigDecimal(50.50), 10, "closed", "Pietje", "209000454"));
    treatments1.add(new Treatment("Test3", "TEST0101", new BigDecimal(50.50), 10, "open",  "Pietje", "209000454"));
    treatments1.add(new Treatment("Test4", "TEST0101", new BigDecimal(50.50), 10, "closed", "Pietje", "209000454"));
    
    return treatments1;
    }
    

}
