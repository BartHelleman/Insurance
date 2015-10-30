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
        InsuranceContract insuranceContract = null;

        // client omzetten naar String clientName
        // Waarschijnlijk iets als String clientName = client.getName();
        String clientName = "Je Moeder2";
   
        try {
            InsuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }
        
        if(InsuranceContractDAO.get(clientName) == null) {
            insuranceContract = new InsuranceContract(null, clientName, 0, null, null);
            System.out.println("Persoon heeft geen polis");
        } else {
            insuranceContract = (InsuranceContract) InsuranceContractDAO.get(clientName).get(0);
        }
     
        return insuranceContract;
    }

    public InsuranceContract addInsuranceContract(InsuranceContract contract) {
        ArrayList<InsuranceContract> insuranceContracts = new ArrayList<>();
        insuranceContracts.add(contract);
        
        insuranceContracts.stream().forEach((insuranceContract1) -> {
            System.out.println("TEST" + insuranceContract1.getClientName() + insuranceContract1.getOwnRisk() + insuranceContract1.getInsuranceID() + insuranceContract1.getStartDate() + insuranceContract1.getEndDate());
        });
        
        try {
           InsuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }

        insuranceContracts.stream().forEach(p -> InsuranceContractDAO.add(p));

        return null;
    }

    public void deleteInsuranceContract(String clientName) {
        Boolean insuranceContract = null;
        
        try {
            InsuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }

            insuranceContract = InsuranceContractDAO.delete(clientName);
    }

    public Invoice getInvoice(Treatment treatment) {
        return null;
    }

    public void printInvoice(InsuranceContract contract) {

    }
}
