/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.main;

import edu.avans.ivh5.server.dao.InvoiceDAO;
import edu.avans.ivh5.server.rmi.ClientImpl;
import edu.avans.ivh5.shared.models.*;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Burak
 */
public class InvoiceGeneratorTask {

    public InvoiceGeneratorTask() {
        //start();
    }

    private void start() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                /*Treatment treatment = new Treatment(null, null, null, 0, null, null, null);
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

                 System.out.println("Time now is -> " + new Date());*/
                ArrayList<SharedTreatment> toBeBilled = null;
                try {
                    if (Main.RMI) {
                        toBeBilled = Main.getPhysioInterface().getAllFinishedTreatments();
                    } else {
                        toBeBilled = new ArrayList<>();
                        toBeBilled.add(new SharedTreatment("209000454", "001behandelcode001", 5));
                    }
                } catch (RemoteException e) {
                    System.out.println("Problem has occured with RMI while trying to generate invoices...");
                }
                
                for(SharedTreatment treatment : toBeBilled)
                {
                    Client client = (Client)ClientImpl.getClientDAO().get(treatment.getBSN()).stream().filter(c -> ((Client)c).getBSN().matches(treatment.getBSN())).collect(Collectors.toList()).get(0);
                    TreatmentCode treatmentCode = (TreatmentCode)ClientImpl.getTreatmentCodeDAO().get(treatment.getTreatmentCode()).stream().filter(t -> ((TreatmentCode)t).getCode().equals(treatment.getTreatmentCode())).collect(Collectors.toList()).get(0);
                    InsuranceCompany company = (InsuranceCompany)ClientImpl.getInsuranceCompanyDAO().get("").get(0);
                    InsuranceContract contract = (InsuranceContract)ClientImpl.getInsuranceContractDAO().get(client.getBSN()).get(0);
                    Insurance insurance = (Insurance)ClientImpl.getInsuranceDAO().get(Integer.toString(contract.getInsuranceID())).get(0);
                    
                    Date beginDate = new Date();
                    Date endDate = null;
                    
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(beginDate);
                    calendar.add(Calendar.MONTH, 1);
                    endDate = calendar.getTime();
                    
                    BigDecimal amountToPay, amountReimbursed, remainingDeductible;
                    BigDecimal oldDeductible = ClientImpl.subtractDeductible(client, BigDecimal.ZERO)[1];
                    BigDecimal treatmentPrice =  treatmentCode.getPrice().multiply(new BigDecimal(treatment.getSessionAmount()));
                    
                    if(shouldBeReimbursed(insurance, treatmentCode))
                    {
                        BigDecimal[] remainder = ClientImpl.subtractDeductible(client, treatmentPrice);
                        remainingDeductible = remainder[1];
                        amountToPay = oldDeductible.subtract(remainingDeductible);
                        amountReimbursed = remainder[0];
                    }
                    else
                    {
                        amountToPay = treatmentPrice;
                        remainingDeductible = oldDeductible;
                        amountReimbursed = BigDecimal.ZERO;
                    }
                    int invoiceNumber = ((InvoiceDAO)ClientImpl.getInvoiceDAO()).generateInvoiceNumber();

                    Invoice invoice = new Invoice(invoiceNumber, beginDate, endDate, new BigDecimal("19"), "done", client.getBSN(), client.getFirstName() + " " + client.getName(), client.getAddress(), client.getPostcode() + " " +  client.getCity(), company.getName(), company.getAddress(), company.getPostCode() + " " + company.getCity(), company.getKVK(), Integer.toString(treatment.getSessionAmount()), treatmentCode.getPrice().toString(), treatmentCode.getCode(), remainingDeductible, amountToPay, false, oldDeductible, amountReimbursed);
                 
                    ClientImpl.getInvoiceDAO().add(invoice);
                    
                    if(client.isIncasso())
                    {
                        generateClieop(client, invoice, company);
                    }
                    
                    System.out.println("Retreived invoice: " + invoice.getInvoiceNumber());
                }

            }
        }, 10000, 5000);
    }
    
    private static boolean shouldBeReimbursed(Insurance insurance, TreatmentCode treatmentCode)
    {
        return insurance.getTreatments()
                .stream()
                .anyMatch(t -> t.equals(treatmentCode.getCode()));
    }
    
    public void generateClieop(Client client, Invoice invoice, InsuranceCompany company)
    {
        FileWriter fileWriter = null;
        final String NEW_LINE_SEPARATOR = System.getProperty("line.separator");
        try {
            //Set title
            fileWriter = new FileWriter(String.format("ClieOp - %s %s %s.csv", client.getFirstName(), client.getName(), getTimestamp()));

            //Write the CSV file header
            fileWriter.append(String.format("%s ClieOp bestand", company.getName()));
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write data to the CSV file

            fileWriter.append("Aanmaakdatum: " + invoice.getDate());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Betaaldatum: " + invoice.getExpirationDate());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Naam: " + client.getFirstName() + " " + client.getName());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Woonplaats: " + client.getCity());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Rekeningnummer: " + client.getIBAN());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Naam opdrachtgever:" + company.getName());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Incasso_Zakelijk: I");
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Valuta: EUR");
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Totaalbedrag: " + invoice.getTotalPrice());


            System.out.println("CSV file was created successfully");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter: " + e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter: " + e.getMessage());
            }
        }
    }
    
    public static String getTimestamp()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-SS");
        return dateFormat.format(new Date());
    }
}
