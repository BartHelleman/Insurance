package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class TreatmentCodeDAO implements DAOInterface {

    private XMLParser XMLParser;

    public TreatmentCodeDAO() throws ParserConfigurationException, SAXException, IOException {
        this.XMLParser = new XMLParser("TreatmentCodes.xml", "TreatmentCodes.xsd");
    }

    @Override
    public boolean add(Object item) {
        if (item instanceof TreatmentCode) {
            Treatment treatment = (Treatment) item;
            Element treatmentNode = this.XMLParser.createElement("treatmentCode");

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

            this.XMLParser.addNode(treatmentNode);
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;
        }
        return false;
    }

    @Override
    public List<Object> get(Object value) {

        if (value instanceof String) {
            return getTreatments((String) value);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Object> getTreatments(String searchPattern) {
        List<Object> treatmentCodes = new ArrayList<>();
        List<Node> treatmentCodeNodes = this.XMLParser.findElementsByName("treatmentCode", searchPattern);

        treatmentCodeNodes.stream().forEach((treatmentCodeNode) -> {
            String treatmentCode = (this.XMLParser.getValueByNodeName(treatmentCodeNode, "code"));
            String name = this.XMLParser.getValueByNodeName(treatmentCodeNode, "name");
            BigDecimal price = new BigDecimal(this.XMLParser.getValueByNodeName(treatmentCodeNode, "priceSession"));

            //List<String> treatmentCodess = this.XMLParser.getSubnodeValuesByName(treatmentCodeNode, "treatment");

            treatmentCodes.add(new TreatmentCode(name, treatmentCode, price));
        });

        return treatmentCodes;

    }

@Override
        public boolean change(Object oldObject, Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public boolean delete(Object searchPattern) {
        List<TreatmentCode> treatmentCodes = new ArrayList<>();
        List<Object> result = get(searchPattern);
        treatmentCodes.clear();
        
        for (Object o : result) {
            treatmentCodes.add((TreatmentCode) o);
        }
        for (TreatmentCode t : treatmentCodes){
            if(searchPattern.equals(t.getCode())){
                
            List<Node> nodes = this.XMLParser.findElementsByName("treatmentCode", t.getCode());
            for (Node node : nodes) {
                this.XMLParser.deleteNode(node);
            }
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;    
            }
        }
        return false;
    }
}
