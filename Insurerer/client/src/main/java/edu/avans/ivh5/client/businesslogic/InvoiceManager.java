package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.InsuranceContractDAO;
import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.InsuranceContract;
import edu.avans.ivh5.shared.models.Invoice;
import edu.avans.ivh5.shared.models.Treatment;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;

public class InvoiceManager {

    //relaties
    private ClientManager clientManager;
    private InsuranceContractDAO InsuranceContractDAO;

    public InsuranceContract getInsuranceContract(Client client) {
        InsuranceContract insuranceContract = null;
        
        // client omzetten naar String clientName
        // Waarschijnlijk iets als String clientName = client.getName();
        String clientName = "Burak2";
   
        try {
            InsuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }
        
        if(InsuranceContractDAO.get(clientName) == null) {
            System.out.println("Persoon heeft geen polis");
        } else {
            insuranceContract = (InsuranceContract) InsuranceContractDAO.get(clientName).get(0);
        }
     
        return insuranceContract;
    }

    public InsuranceContract addInsuranceContract(Client client) {
        //    String BSN = client.getBSN();
        Document doc = null;
        File f = new File("InsuranceContract.xml");
        Element root = null;

        if (f.exists()) {
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                doc = documentBuilder.parse("InsuranceContract.xml");
                root = doc.getDocumentElement();
            } catch (ParserConfigurationException e) {
                System.out.println(e);
            } catch (SAXException | IOException ex) {
                Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("File gevonden");

            // server elements
            Element member = doc.createElement("member");

            // memberID elements
            Element memberID = doc.createElement("memberID");
            memberID.appendChild(doc.createTextNode("2"));
            member.appendChild(memberID);

            // eigenRisico elements
            Element eigenRisico = doc.createElement("eigenRisico");
            eigenRisico.appendChild(doc.createTextNode("200"));
            member.appendChild(eigenRisico);

            // clientNaam elements
            Element clientNaam = doc.createElement("clientNaam");
            clientNaam.appendChild(doc.createTextNode("Bart"));
            member.appendChild(clientNaam);

            // verzekeringID elements
            Element verzekeringID = doc.createElement("verzekeringID");
            verzekeringID.appendChild(doc.createTextNode("304"));
            member.appendChild(verzekeringID);

            // startDatum elements
            Element startDatum = doc.createElement("startDatum");
            startDatum.appendChild(doc.createTextNode("27-02-2013"));
            member.appendChild(startDatum);

            // eindDatum elements
            Element eindDatum = doc.createElement("eindDatum");
            eindDatum.appendChild(doc.createTextNode("31-06-2015"));
            member.appendChild(eindDatum);

            root.appendChild(member);

            DOMSource source = new DOMSource(doc);

            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                StreamResult result = new StreamResult("InsuranceContract.xml");
                transformer.transform(source, result);
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                doc = docBuilder.newDocument();

                // root elements
                Element rootElement = doc.createElement("company");
                doc.appendChild(rootElement);

                // member elements
                Element member = doc.createElement("member");
                rootElement.appendChild(member);

                // shorten way
                // staff.setAttribute("id", "1");
                // memberID elements
                Element memberID = doc.createElement("memberID");
                memberID.appendChild(doc.createTextNode("2"));
                member.appendChild(memberID);

                // eigenRisico elements
                Element eigenRisico = doc.createElement("eigenRisico");
                eigenRisico.appendChild(doc.createTextNode("303"));
                member.appendChild(eigenRisico);

                // clientNaam elements
                Element clientNaam = doc.createElement("clientNaam");
                clientNaam.appendChild(doc.createTextNode("Iemand"));
                member.appendChild(clientNaam);

                // verzekeringID elements
                Element verzekeringID = doc.createElement("verzekeringID");
                verzekeringID.appendChild(doc.createTextNode("305"));
                member.appendChild(verzekeringID);

                // startDatum elements
                Element startDatum = doc.createElement("startDatum");
                startDatum.appendChild(doc.createTextNode("01-01-2015"));
                member.appendChild(startDatum);

                // eindDatum elements
                Element eindDatum = doc.createElement("eindDatum");
                eindDatum.appendChild(doc.createTextNode("31-04-2015"));
                member.appendChild(eindDatum);

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("InsuranceContract.xml"));

                // Output to console for testing
                // StreamResult result = new StreamResult(System.out);
                transformer.transform(source, result);

                System.out.println("File saved!");

            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public InsuranceContract test() {
        Boolean insuranceContract = null;
        List<Object> insuranceContracts = new ArrayList<>();
        BigDecimal ownRisk = new BigDecimal(0.35);
        Date date = null;
        Date date2 = null;
        
        Integer value = 20150303;
        Integer value2 = 20160304;
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            date = originalFormat.parse(value.toString());
            date2 = originalFormat.parse(value.toString());
        } catch (ParseException ex) {
            Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        insuranceContracts.add(new InsuranceContract(ownRisk, "Niels", 004, date, date2));
        
        try {
           InsuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }
        
      //  if(InsuranceContractDAO.add("Burak") == false) {
     //       System.out.println("Test");
     //   } else {
            insuranceContract = InsuranceContractDAO.add(insuranceContracts);
     //   }  
            return null;
    }

    public void deleteInsuranceContract(InsuranceContract contract) {
        Boolean insuranceContract = null;
        
        try {
            InsuranceContractDAO = new InsuranceContractDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }
        
        if(InsuranceContractDAO.delete("Burak") == false) {
            System.out.println("Persoon kon niet worden verwijderd");
        } else {
            insuranceContract = InsuranceContractDAO.delete("Burak");
        }
    }

    public Invoice getInvoice(Treatment treatment) {
        return null;
    }

    public void printInvoice(InsuranceContract contract) {

    }

}
