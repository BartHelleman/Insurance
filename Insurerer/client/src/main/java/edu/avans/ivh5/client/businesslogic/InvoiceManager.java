package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.InsuranceContractDAO;
import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.InsuranceContract;
import edu.avans.ivh5.shared.models.Invoice;
import edu.avans.ivh5.shared.models.Treatment;

import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class InvoiceManager {

    //relaties
    private ClientManager clientManager;
    private InsuranceContractDAO InsuranceContractDAO;
    
    

    public InsuranceContract getInsuranceContract(Client client) {
        InsuranceContract insuranceContract;

        // client to BSN
        String BSN = client.getBSN();
   
        // New DAO
        try {
            InsuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }
        
        
        // get all data off insurancecontracts
        if(InsuranceContractDAO.get(BSN).size() == 1) {
            insuranceContract = (InsuranceContract) InsuranceContractDAO.get(BSN).get(0);
        } else {
            insuranceContract = new InsuranceContract(null, null, BSN, 0, null, null);
            System.out.println("Persoon heeft geen polis");
        }
     
        return insuranceContract;
    }

    public InsuranceContract addInsuranceContract(InsuranceContract contract) {
        ArrayList<InsuranceContract> insuranceContracts = new ArrayList<>();
        insuranceContracts.add(contract);
        
        insuranceContracts.stream().forEach((insuranceContract1) -> {
            System.out.println("TEST" + insuranceContract1.getClientName() + insuranceContract1.getOwnRisk() + insuranceContract1.getInsuranceID() + insuranceContract1.getStartDate() + insuranceContract1.getEndDate());
        });
        
        // new DAO
        try {
           InsuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }

        // Add all members to XML
        insuranceContracts.stream().forEach(p -> InsuranceContractDAO.add(p));

        return null;
    }

    public void deleteInsuranceContract(Client client) {
        Boolean insuranceContract;    
        
        // new DAO
        try {
            InsuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }
        
        // delete member from XML
        insuranceContract = InsuranceContractDAO.delete(client.getBSN());
    }

    public Invoice getInvoice(Treatment treatment) {
        return null;
    }

    public void printInvoice(InsuranceContract contract) {

    }
}
