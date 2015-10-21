package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.InsuranceContract;
import edu.avans.ivh5.shared.models.Invoice;
import edu.avans.ivh5.shared.models.Treatment;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;

public class InvoiceManager {
    
        //relaties
    private ClientManager clientManager;
    
    public InsuranceContract getInsuranceContract(Client client) {

        String xml = "<company>"+
                 "<member>"+
                      "<memberID>1</memberID>"+
                      "<eigenRisico>100</eigenRisico>"+
                      "<clientNaam>Tom Jansen</clientNaam>"+
                      "<verzekeringID>1</verzekeringID>"+
                      "<startDatum>20-03-2010</startDatum>"+
                      "<eindDatum>30-06-2014</eindDatum>"+
                  "</member>"+
                  "<member>"+
                      "<memberID>2</memberID>"+
                      "<eigenRisico>200</eigenRisico>"+
                      "<clientNaam>Jan Tomsen</clientNaam>"+
                      "<verzekeringID>1</verzekeringID>"+
                      "<startDatum>30-03-2011</startDatum>"+
                      "<eindDatum>03-06-2013</eindDatum>"+
                  "</member>"+
                "</company>";
        
        Document doc = null;
        
        try {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        ByteArrayInputStream bis = new ByteArrayInputStream(xml.getBytes());
        doc = db.parse(bis);
        } catch(SAXException | IOException | ParserConfigurationException e) {
            System.out.println(e);
        }
        Node n = doc.getDocumentElement();
        NodeList nl = n.getChildNodes();
        Node n2;
        
        InsuranceContract ic = null;

         for (int i = 0; i < nl.getLength(); i++) {
            if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                n2 = nl.item(i);
                    if("2".equals(n2.getFirstChild().getTextContent())) {
                        Element el = (Element) nl.item(i);

                        if (el.getNodeName().contains("member")) {
                            String eigenRisico = el.getElementsByTagName("eigenRisico").item(0).getTextContent();
                            String clientName = el.getElementsByTagName("clientNaam").item(0).getTextContent();
                            String verzekeringID = el.getElementsByTagName("verzekeringID").item(0).getTextContent();
                            String startDatum = el.getElementsByTagName("startDatum").item(0).getTextContent();
                            String eindDatum = el.getElementsByTagName("eindDatum").item(0).getTextContent();
                        //    System.out.println(eigenRisico + verzekeringID + startDatum + eindDatum);
                            
                            BigDecimal ownRisk = new BigDecimal(eigenRisico);
                            Integer insuranceID = Integer.parseInt(verzekeringID);

                            DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                            Date startDate = null;
                            Date endDate = null;
                            
                            try {
                                startDate = format.parse(startDatum);
                                endDate = format.parse(eindDatum);
                            } catch (ParseException e) {
                                System.out.println(e);
                            }
                            
                        //    System.out.println(insuranceID + " " + ownRisk + " " + startDate + " " + endDate);
                            ic = new InsuranceContract(ownRisk, clientName, insuranceID, startDate, endDate);
                        }
                    }               
                }
            }
        return ic;
    }
    
    public InsuranceContract addInsuranceContract(Client client){
    //    String BSN = client.getBSN();
        return null;
    }
    
    public void deleteInsuranceContract(InsuranceContract contract){
        
    }
    
    public Invoice getInvoice(Treatment treatment){
        return null;
    }
    
    public void printInvoice(InsuranceContract contract){
        
    }
    

}
