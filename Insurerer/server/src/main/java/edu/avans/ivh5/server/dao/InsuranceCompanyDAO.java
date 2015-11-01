package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.InsuranceCompany;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class InsuranceCompanyDAO implements DAOInterface {

    private XMLParser XMLParser;

    public InsuranceCompanyDAO() throws ParserConfigurationException, SAXException, IOException {
        this.XMLParser = new XMLParser("InsuranceCompanies.xml", "InsuranceCompanies.xsd");
    }

    @Override
    public boolean add(Object item) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(item instanceof InsuranceCompany)
        {
            InsuranceCompany company = (InsuranceCompany)item;
            Element companyNode = this.XMLParser.createElement("company");
            
            Element name = this.XMLParser.createElement("name");
            Text nameText = this.XMLParser.createTextNode(company.getName());
            name.appendChild(nameText);
            companyNode.appendChild(name);
            
            Element city = this.XMLParser.createElement("city");
            Text cityText = this.XMLParser.createTextNode(company.getCity());
            city.appendChild(cityText);
            companyNode.appendChild(city);
            
            Element postcode = this.XMLParser.createElement("postcode");
            Text postcodeText = this.XMLParser.createTextNode(company.getPostCode());
            postcode.appendChild(postcodeText);
            companyNode.appendChild(postcode);
            
            Element address = this.XMLParser.createElement("address");
            Text addressText = this.XMLParser.createTextNode(company.getAddress());
            address.appendChild(addressText);
            companyNode.appendChild(address);
            
            Element KVK = this.XMLParser.createElement("KVK");
            Text KVKText = this.XMLParser.createTextNode(company.getKVK());
            KVK.appendChild(KVKText);
            companyNode.appendChild(KVK);
            
            this.XMLParser.addNode(companyNode);
            
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;
        }
        
        return false;
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
        if(!(oldObject instanceof InsuranceCompany) || !(newObject instanceof InsuranceCompany))
            throw new RuntimeException("Old and new insurancecompanies have to be of type: InsuranceCompany");
        
        InsuranceCompany oldCompany = (InsuranceCompany)oldObject;
        InsuranceCompany newCompany = (InsuranceCompany)newObject;
        
        if(delete(oldCompany))
            return add(newCompany);
        return false;
    }

    @Override
    public boolean delete(Object value) {
        List<Object> result = get(value.toString());
        if(result.size() != 1)
            return false;
        
        if(value instanceof String)
        {
            InsuranceCompany companyToDelete = (InsuranceCompany)result.get(0);
            List<Node> nodes = this.XMLParser.findElementsByName("company", companyToDelete.getKVK());
            for(Node node : nodes) {
                this.XMLParser.deleteNode(node);
            }
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;
        }
        return false;
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
