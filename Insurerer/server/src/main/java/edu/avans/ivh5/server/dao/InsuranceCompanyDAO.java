package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.InsuranceCompany;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class InsuranceCompanyDAO implements DAOInterface {

    private XMLParser XMLParser;

    public InsuranceCompanyDAO() throws ParserConfigurationException, SAXException, IOException {
        this.XMLParser = new XMLParser("InsuranceCompanies.xml", "InsuranceCompanies.xsd");
    }

    @Override
    public boolean add(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> get(Object value) {
        if (value instanceof String) {
            return getCompanies((String) value);
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean change(Object oldObject, Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<Object> getCompanies(String searchPattern) {
        List<Object> companies = new ArrayList<>();
        List<Node> companyNodes = this.XMLParser.findElementsByName("company", searchPattern);

        companyNodes.stream().forEach((companyNode) -> {
            String name = this.XMLParser.getValueByNodeName(companyNode, "name");
            String city = this.XMLParser.getValueByNodeName(companyNode, "city");
            String postcode = this.XMLParser.getValueByNodeName(companyNode, "postcode");
            String address = this.XMLParser.getValueByNodeName(companyNode, "address");
            String KVK = this.XMLParser.getValueByNodeName(companyNode, "KVK");

            companies.add(new InsuranceCompany(name, city, postcode, address, KVK));
        });

        return companies;
    }

}
