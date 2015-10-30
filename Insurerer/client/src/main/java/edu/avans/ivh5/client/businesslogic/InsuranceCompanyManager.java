package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.shared.models.InsuranceCompany;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class InsuranceCompanyManager {

    String name = "";
    String city = "";
    String postcode = "";
    String address = "";
    String KVK = "";

    public InsuranceCompany getInsuranceCompany() {
        InsuranceCompany insuranceCompany = null;

        Document doc = null;

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            doc = db.parse("../server/src/main/java/edu/avans/ivh5/server/resources/InsuranceCompanies.xml");
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(InsuranceCompanyManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        Node n = doc.getDocumentElement();
        NodeList nl = n.getChildNodes();
        Node n2;

        for (int i = 0; i < nl.getLength(); i++) {
            if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                n2 = nl.item(i);
                Element el = (Element) nl.item(i);

                if (el.getNodeName().contains("company")) {
                    name = el.getElementsByTagName("name").item(0).getTextContent();
                    city = el.getElementsByTagName("city").item(0).getTextContent();
                    postcode = el.getElementsByTagName("postcode").item(0).getTextContent();
                    address = el.getElementsByTagName("address").item(0).getTextContent();
                    KVK = el.getElementsByTagName("KVK").item(0).getTextContent();
                }

                insuranceCompany = new InsuranceCompany(name, city, postcode, address, KVK);
            }
        }
        return insuranceCompany;
    }

    public boolean changeInsuranceCompany(InsuranceCompany insuranceCompany) throws TransformerException {
        Document doc = null;
        File f = new File("../server/src/main/java/edu/avans/ivh5/server/resources/InsuranceCompanies.xml");
        Element root = null;

        if (f.exists()) {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse("../server/src/main/java/edu/avans/ivh5/server/resources/InsuranceCompanies.xml");
                root = doc.getDocumentElement();
            } catch (SAXException | IOException | ParserConfigurationException ex) {
                Logger.getLogger(InsuranceCompanyManager.class.getName()).log(Level.SEVERE, null, ex);
            }

            Node n = doc.getDocumentElement();
            NodeList nl = n.getChildNodes();

            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nl.item(i);

                    if (el.getNodeName().contains("company")) {

                        el = (Element) nl.item(i);
                        NodeList test = el.getChildNodes();

                        el.getParentNode().removeChild(el);

                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(new File("../server/src/main/java/edu/avans/ivh5/server/resources/InsuranceCompanies.xml"));

                        transformer.transform(source, result);
                    }
                }
            }
            
            name = insuranceCompany.getName();
            city = insuranceCompany.getCity();
            postcode = insuranceCompany.getPostCode();
            address = insuranceCompany.getAddress();
            KVK = insuranceCompany.getKVK();
            
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                doc = documentBuilder.parse("../server/src/main/java/edu/avans/ivh5/server/resources/InsuranceCompanies.xml");
                root = doc.getDocumentElement();
            } catch (SAXException | IOException | ParserConfigurationException ex) {
                Logger.getLogger(InsuranceCompanyManager.class.getName()).log(Level.SEVERE, null, ex);
            }

            // server elements
            Element company = doc.createElement("company");

            // name elements
            Element eName = doc.createElement("name");
            eName.appendChild(doc.createTextNode(name));
            company.appendChild(eName);

            // city elements
            Element eCity = doc.createElement("city");
            eCity.appendChild(doc.createTextNode(city));
            company.appendChild(eCity);

            // postcode elements
            Element ePostcode = doc.createElement("postcode");
            ePostcode.appendChild(doc.createTextNode(postcode));
            company.appendChild(ePostcode);

            // address elements
            Element eAddress = doc.createElement("address");
            eAddress.appendChild(doc.createTextNode(address));
            company.appendChild(eAddress);

            // KVK elements
            Element eKVK = doc.createElement("KVK");
            eKVK.appendChild(doc.createTextNode(KVK));
            company.appendChild(eKVK);

            root.appendChild(company);

            DOMSource source = new DOMSource(doc);

            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                StreamResult result = new StreamResult("../server/src/main/java/edu/avans/ivh5/server/resources/InsuranceCompanies.xml");
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
                Element rootElement = doc.createElement("companies");
                doc.appendChild(rootElement);

                // member elements
                Element company = doc.createElement("company");
                rootElement.appendChild(company);

                // memberID elements
                Element eName = doc.createElement("name");
                eName.appendChild(doc.createTextNode(name));
                company.appendChild(eName);

                // city elements
                Element eCity = doc.createElement(city);
                eCity.appendChild(doc.createTextNode(city));
                company.appendChild(eCity);

                // postcode elements
                Element ePostcode = doc.createElement("postcode");
                ePostcode.appendChild(doc.createTextNode(postcode));
                company.appendChild(ePostcode);

                // address elements
                Element eAddress = doc.createElement("address");
                eAddress.appendChild(doc.createTextNode(address));
                company.appendChild(eAddress);

                // KVK elements
                Element eKVK = doc.createElement("KVK");
                eKVK.appendChild(doc.createTextNode(KVK));
                company.appendChild(eKVK);

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("../server/src/main/java/edu/avans/ivh5/server/resources/InsuranceCompanies.xml"));

                    // Output to console for testing
                // StreamResult result = new StreamResult(System.out);
                transformer.transform(source, result);

            } catch (TransformerException tfe) {
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(InsuranceCompanyManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
}
