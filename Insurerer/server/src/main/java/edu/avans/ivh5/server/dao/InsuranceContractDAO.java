package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.InsuranceContract;
import edu.avans.ivh5.shared.util.DateFormatter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class InsuranceContractDAO implements DAOInterface {

    private XMLParser XMLParser;

    public InsuranceContractDAO() throws ParserConfigurationException, SAXException, IOException {
        this.XMLParser = new XMLParser("InsuranceContracts.xml", "InsuranceContracts.xsd");
    }

    @Override
    public boolean add(Object item) {
        if (item != null) {
            return addInsuranceContract(item);
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public List<Object> get(Object value) {
        if (value instanceof String) {
            return getInsuranceContract((String) value);
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public boolean change(Object oldObject, Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object value) {
        if (value instanceof String) {
            return deleteInsuranceContract((String) value);
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private List<Object> getInsuranceContract(String searchPattern) {
        List<Object> insuranceContracts = new ArrayList<>();
        List<Node> insuranceContractNodes = this.XMLParser.findElementsByName("contract", searchPattern);

        if(!insuranceContractNodes.isEmpty()) {
            for (Node insuranceContractNode : insuranceContractNodes) {
                String clientName = this.XMLParser.getValueByNodeName(insuranceContractNode, "clientName");
                BigDecimal ownRisk = new BigDecimal(this.XMLParser.getValueByNodeName(insuranceContractNode, "ownRisk"));         
                int insuranceID = Integer.parseInt(this.XMLParser.getValueByNodeName(insuranceContractNode, "insuranceID"));
                Date startDate = DateFormatter.stringToDate(this.XMLParser.getValueByNodeName(insuranceContractNode, "startDate"));
                Date endDate = DateFormatter.stringToDate(this.XMLParser.getValueByNodeName(insuranceContractNode, "endDate"));

                insuranceContracts.add(new InsuranceContract(ownRisk, clientName, insuranceID, startDate, endDate));
            }
        } else {
            insuranceContracts = null;
        }
        return insuranceContracts;
    }
    
    private boolean addInsuranceContract(Object searchPattern) {
        try {
            List<Object> insuranceContract = new ArrayList<>();
            insuranceContract.add(searchPattern);
            NodeList idk = null;
            Element node = null;
            node.
            
            for (Object insuranceContract1 : insuranceContract) {
                node = DocumentBuilderFactory
                        .newInstance()
                        .newDocumentBuilder().parse(new ByteArrayInputStream(insuranceContract1.getBytes())).getDocumentElement();
            }
            
          //  Node iets = searchPattern;
            this.XMLParser.addNode((Node) insuranceContract);
            
            return false;
        } catch (SAXException | IOException ex) {
            Logger.getLogger(InsuranceContractDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(InsuranceContractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean deleteInsuranceContract(String searchPattern) {
        List<Node> insuranceContractNodes = this.XMLParser.findElementsByName("contract", searchPattern);
        boolean deleteContract = false;
        Document doc = null;
        
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse("InsuranceContract.xml");
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(InsuranceContractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!insuranceContractNodes.isEmpty()) {
            Element test = (Element) insuranceContractNodes.get(0);
            test.getParentNode().removeChild(test);
            deleteContract = true;
            try {
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer t = tf.newTransformer();
                t.transform(new DOMSource(doc), new StreamResult(new File("InsuranceContract.xml")));
            } catch (TransformerException ex) {
                Logger.getLogger(InsuranceContractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            deleteContract = false;
        }
        return deleteContract;
    }

}
