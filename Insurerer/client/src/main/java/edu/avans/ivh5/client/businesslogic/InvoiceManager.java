package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.InsuranceContract;
import edu.avans.ivh5.shared.models.Invoice;
import edu.avans.ivh5.shared.models.Treatment;

import java.io.File;
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

    public InsuranceContract getInsuranceContract(Client client) {
        Document doc = null;
        File f = new File("InsuranceContract.xml");
        InsuranceContract ic = null;
        
        if(f.exists()) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse("InsuranceContract.xml");
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println(e);
        }
        Node n = doc.getDocumentElement();
        NodeList nl = n.getChildNodes();
        Node n2;

            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    n2 = nl.item(i);
                    if ("2".equals(n2.getFirstChild().getTextContent())) {
                        Element el = (Element) nl.item(i);

                        if (el.getNodeName().contains("member")) {
                            String eigenRisico = el.getElementsByTagName("eigenRisico").item(0).getTextContent();
                            String clientName = el.getElementsByTagName("clientNaam").item(0).getTextContent();
                            String verzekeringID = el.getElementsByTagName("verzekeringID").item(0).getTextContent();
                            String startDatum = el.getElementsByTagName("startDatum").item(0).getTextContent();
                            String eindDatum = el.getElementsByTagName("eindDatum").item(0).getTextContent();

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
        } else {
            ic = null;
        }
        return ic;
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
        } catch (SAXException ex) {
            Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
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

    public void deleteInsuranceContract(InsuranceContract contract) {
        
        Document doc = null;
        File f = new File("InsuranceContract.xml");
        Element root = null;
        
        
        
        if (f.exists()) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse("InsuranceContract.xml");
            
            Node n = doc.getDocumentElement();
            NodeList nl = n.getChildNodes();
            Node n2;

            for (int i = 0; i < nl.getLength(); i++) {      
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    n2 = nl.item(i);
                    if ("2".equals(n2.getFirstChild().getTextContent())) {
                        System.out.println("found child node");
  
                        Element el = (Element) nl.item(i);  
                        NodeList test = el.getChildNodes();
                        
                            el.getParentNode().removeChild(el);
                        
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(new File("InsuranceContract.xml"));

                    // Output to console for testing
                // StreamResult result = new StreamResult(System.out);
                transformer.transform(source, result);
                    }
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException ex) {
                Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(InvoiceManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("file bestaat niet");
        }
    }

    public Invoice getInvoice(Treatment treatment) {
        return null;
    }

    public void printInvoice(InsuranceContract contract) {

    }

}
