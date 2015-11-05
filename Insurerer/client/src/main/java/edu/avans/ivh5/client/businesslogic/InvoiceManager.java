package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.ClientDAO;
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
    private InsuranceContractDAO InsuranceContractDAO;
    private Treatment treatment;
    private ClientDAO clientDAO;

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "invoiceNumber,date,expirationDate,VAT";

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
        /*    DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
         format.setLenient(false);
         String iets = "2000-03-03";
         Date date = null;
         BigDecimal iets2 = new BigDecimal("1");
       
         try {
         date = format.parse(iets);
         } catch (ParseException ex) {
         Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         //Create new students objects
         Invoice invoice1 = new Invoice(1, date, date, iets2);

         //Create a new list of student objects
         List<Invoice> invoice = new ArrayList();
         invoice.add(invoice1);


         FileWriter fileWriter = null;

         try {
         fileWriter = new FileWriter("ClieOp");

         //Write the CSV file header
         fileWriter.append(FILE_HEADER.toString());

         //Add a new line separator after the header
         fileWriter.append(NEW_LINE_SEPARATOR);

         //Write a new student object list to the CSV file
         for (Invoice invoices : invoice) {
         fileWriter.append(String.valueOf(invoices.getDate()));
         fileWriter.append(COMMA_DELIMITER);
         fileWriter.append(String.valueOf(invoices.getExpirationDate()));
         fileWriter.append(COMMA_DELIMITER);
         fileWriter.append(String.valueOf(invoices.getInvoiceNumber()));
         fileWriter.append(COMMA_DELIMITER);
         fileWriter.append(String.valueOf(invoices.getTotalAmount()));
         fileWriter.append(COMMA_DELIMITER);
         fileWriter.append(String.valueOf(invoices.getVAT()));
         fileWriter.append(NEW_LINE_SEPARATOR);
         }
         System.out.println("CSV file was created successfully !!!");
         } catch (Exception e) {
         System.out.println("Error in CsvFileWriter !!!");
         e.printStackTrace();
         } finally {
         try {
         fileWriter.flush();
         fileWriter.close();
         } catch (IOException e) {
         System.out.println("Error while flushing/closing fileWriter !!!");
         e.printStackTrace();
         }
         } */
        return null;
    }

    public void printInvoice(InsuranceContract contract) {

    }

    public void generateInvoices() {

        System.out.println("Time now is -> " + new Date());

        //Creating timer which executes once after five seconds
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String firstName;
                
                List<Treatment> treatments = treatment.treatments();
                for (Treatment t : treatments) {
                    if (t.getStatus().equals("closed")) {
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
        InsuranceContractDAO dao = null;
        try {
            dao = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {}
        dao.getInsuranceContract(c.getBSN());
    }

}
