package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.*;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class TreatmentDAO implements DAOInterface {

    private XMLParser XMLParser;
    
    public TreatmentDAO() throws ParserConfigurationException, SAXException, IOException {
        this.XMLParser = new XMLParser("Treatments.xml", "Treatments.xsd");
    }

    @Override
    public boolean add(Object item) {
        if(item instanceof Treatment) {
            Treatment treatment = (Treatment)item;
            Element treatmentNode = this.XMLParser.createElement("treatment");
            
            Element name = this.XMLParser.createElement("name");
            Text nameText = this.XMLParser.createTextNode(treatment.getName());
            name.appendChild(nameText);
            treatmentNode.appendChild(name);
            
            Element code = this.XMLParser.createElement("code");
            Text codeText = this.XMLParser.createTextNode(treatment.getCode());
            code.appendChild(codeText);
            treatmentNode.appendChild(code);
            
            Element priceSession = this.XMLParser.createElement("priceSession");
            Text priceText = this.XMLParser.createTextNode(treatment.getPrice().toString());
            priceSession.appendChild(priceText);
            treatmentNode.appendChild(priceSession);
            
            Element amountSessions = this.XMLParser.createElement("amountSessions");
            Text amountSessionsText = this.XMLParser.createTextNode(Integer.toString(treatment.getAmountSessions()));
            amountSessions.appendChild(amountSessionsText);
            treatmentNode.appendChild(amountSessions);
            
            this.XMLParser.addNode(treatmentNode);
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
        }
        return false;
    }

    @Override
    public List<Object> get(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean change(Object oldObject, Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
