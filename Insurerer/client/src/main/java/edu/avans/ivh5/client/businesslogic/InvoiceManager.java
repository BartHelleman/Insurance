package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.InsuranceContractDAO;
import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.InsuranceContract;
import edu.avans.ivh5.shared.models.Invoice;
import edu.avans.ivh5.shared.models.Treatment;
import java.io.FileWriter;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class InvoiceManager {

    //relaties
    private ClientManager clientManager;
    private InsuranceContractDAO InsuranceContractDAO;

    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "Zorg4U ClieOp bestand";

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
        if (InsuranceContractDAO.get(BSN).size() == 1) {
            insuranceContract = (InsuranceContract) InsuranceContractDAO.get(BSN).get(0);
        } else {
            insuranceContract = new InsuranceContract(null, null, BSN, 0, null, null);
        }

        return insuranceContract;
    }

    public InsuranceContract addInsuranceContract(InsuranceContract contract) {
        ArrayList<InsuranceContract> insuranceContracts = new ArrayList<>();
        insuranceContracts.add(contract);

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

    public Invoice getInvoice(Treatment treatment, Client client) {
        if(client.isIncasso() == true) {
            // Testing data
            // Treatment treatment1 = new Treatment("Treatment10", "9292309309", new BigDecimal(2), 2);
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            format.setLenient(false);
            String iets = "2000/03/03";
            Date date = null;
            BigDecimal iets2 = new BigDecimal("1");

            try {
                date = format.parse(iets);
            } catch (ParseException ex) {
                Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Create new students objects
          
            Invoice invoice1 = new Invoice(1, date, date, iets2, treatment);

            //Create a new list of student objects
            List<Invoice> invoice = new ArrayList();
            invoice.add(invoice1);

            FileWriter fileWriter = null;

            try {
                //Set title
                fileWriter = new FileWriter("ClieOp - " + client.getName());

                //Write the CSV file header
                fileWriter.append(FILE_HEADER);

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);

                //Write data to the CSV file
                for (Invoice invoices : invoice) {

                    fileWriter.append("Aanmaakdatum: " + invoices.getDate());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append("Betaaldatum: " + invoices.getExpirationDate());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append("Naam: " + client.getFirstName() + " " + client.getName());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append("Woonplaats: " + client.getCity());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append("Rekeningnummer: " + client.getIBAN());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append("Naam opdrachtgever: Zorg4U");
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append("Incasso_Zakelijk: I");
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append("Valuta: EUR");
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append("Totaalbedrag: " + invoices.getTotalAmount());
                }
               
                System.out.println("CSV file was created successfully");
            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter");
            } finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                }
            }
        System.out.println("Automatisch incasso is false");
        }
        return null;
    }

    public void printInvoice(InsuranceContract contract) {

    }
}
