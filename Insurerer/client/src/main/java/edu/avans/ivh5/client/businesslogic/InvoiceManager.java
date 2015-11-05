package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.ClientDAO;
import edu.avans.ivh5.server.dao.InsuranceContractDAO;
import edu.avans.ivh5.server.dao.InvoiceDAO;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class InvoiceManager {

    //relaties
    private ClientManager clientManager;
    private InsuranceContractDAO insuranceContractDAO;
    private Treatment treatment;
    private ClientDAO clientDAO;
    private InvoiceDAO invoiceDAO;

    private static final String COMMA_DELIMITER = ",";

    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "Zorg4U ClieOp bestand";

    public InsuranceContract getInsuranceContract(Client client) {
        InsuranceContract insuranceContract;

        // client to BSN
        String BSN = client.getBSN();

        // New DAO
        try {
            insuranceContractDAO = new InsuranceContractDAO();
            invoiceDAO = new InvoiceDAO();
            clientDAO = new ClientDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }
        
        

        // get all data off insurancecontracts
        if (insuranceContractDAO.get(BSN).size() == 1) {
            insuranceContract = (InsuranceContract) insuranceContractDAO.get(BSN).get(0);
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
            insuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }

        // Add all members to XML
        insuranceContracts.stream().forEach(p -> insuranceContractDAO.add(p));

        return null;
    }

    public void deleteInsuranceContract(Client client) {
        Boolean insuranceContract;

        // new DAO
        try {
            insuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }

        // delete member from XML
        insuranceContract = insuranceContractDAO.delete(client.getBSN());
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
          
            Invoice invoice1 = new Invoice(1, date, date, iets2, "", treatment);

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

    public void generateInvoices() {
        System.out.println("generating invoices");

        System.out.println("Time now is -> " + new Date());

        //Creating timer which executes once after five seconds
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                Treatment treatment = new Treatment(null, null, null, 0, null, null, null);
                List<Treatment> treatments = treatment.treatments();
                for (Treatment t : treatments) {
                    System.out.println(t.getStatus());
                    if (t.getStatus().equals("closed")) {
                        System.out.println("found closed treatment with bsn " + t.getBSNClient());
                        for (Object o : clientDAO.get(t.getBSNClient())) {
                            Client client = (Client) o;
                            generateInvoice(t, client);
                        }
                    }
                }

                System.out.println("Time now is -> " + new Date());
            }
        }, 10000, 5000);
    }

    public void generateInvoice(Treatment t, Client c) {
        if (insuranceContractDAO != null) {
            List<Object> contracts = insuranceContractDAO.getInsuranceContract(c.getBSN());
            InsuranceContract contract = (InsuranceContract) contracts.get(0);
            printValues(t, c, contract);
            
        }
    }

    private void printValues(Treatment t, Client c, InsuranceContract i) {
        System.out.println(t.getAmountSessions());
        System.out.println("Treatment bsn = " + t.getBSNClient());
        System.out.println("Client bsn = " + c.getBSN());
        System.out.println("Contract bsn = " + i.getBSN() + "\n");
    }

}
