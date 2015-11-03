package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.Insurance;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class InsuranceDAO implements DAOInterface {

    private XMLParser XMLParser;

    public InsuranceDAO() throws ParserConfigurationException, SAXException, IOException {
        this.XMLParser = new XMLParser("Insurances.xml", "Insurances.xsd");
    }

    @Override
    public boolean add(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> get(Object value) {
        if (value instanceof String) {
            return getInsurances((String) value);
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean change(Object oldObject, Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object searchPattern) {
        List<Insurance> insurances = new ArrayList<>();
        List<Object> result = get(searchPattern);
        insurances.clear();
        
        for (Object o : result) {
            insurances.add((Insurance) o);
        }
        for (Insurance i : insurances){
            if(searchPattern.equals(i.getID())){
                
            List<Node> nodes = this.XMLParser.findElementsByName("insurance", i.getID());
            for (Node node : nodes) {
                this.XMLParser.deleteNode(node);
            }
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;    
            }
        }
        return false;
    }

    private List<Object> getInsurances(String searchPattern) {
        List<Object> insurances = new ArrayList<>();
        List<Node> insuranceNodes = this.XMLParser.findElementsByName("insurance", searchPattern);

        insuranceNodes.stream().forEach((insuranceNode) -> {
            String id = (this.XMLParser.getValueByNodeName(insuranceNode, "ID"));
            String name = this.XMLParser.getValueByNodeName(insuranceNode, "name");
            BigDecimal price = new BigDecimal(this.XMLParser.getValueByNodeName(insuranceNode, "price"));

            List<String> treatmentCodes = this.XMLParser.getSubnodeValuesByName(insuranceNode, "treatment");

            insurances.add(new Insurance(id, name, price, treatmentCodes));
        });

        return insurances;
        
    }
}
