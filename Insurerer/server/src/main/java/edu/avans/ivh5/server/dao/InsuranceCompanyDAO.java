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

    private final XMLParser XMLParser;

    /**
     * Creates a new XMLParser with InsuranceCompanies.xml and
     * InsuranceCompanies.xsd as parameters.
     *
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public InsuranceCompanyDAO() throws ParserConfigurationException, SAXException, IOException {
        this.XMLParser = new XMLParser("InsuranceCompanies.xml", "InsuranceCompanies.xsd");
    }

    /**
     * Method to add the InsuranceCompany to the XML file.
     *
     * @param item the newCompany object containing the values of the input
     * fields.
     * @return boolean, true
     */
    @Override
    public boolean add(Object item) {
        if (item instanceof InsuranceCompany) {
            InsuranceCompany company = (InsuranceCompany) item;
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

    /**
     * Method to get the InsuranceCompany values from the XML file.
     *
     * @param value Used to get a specific InsuranceCompany, but not needed
     * here.
     * @return List with the object InsuranceCompany.
     */
    @Override
    public List<Object> get(Object value) {
        List<Object> companies = new ArrayList<>();
        List<Node> companyNodes = this.XMLParser.findElementsByName("company", "");

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

    /**
     * Deletes the old values from the XML file, and adds the new ones.
     *
     * @param oldObject the current values of InsuranceCompany
     * @param newObject the new values of InsuranceCompany
     * @return boolean
     */
    @Override
    public boolean change(Object oldObject, Object newObject) {
        if (!(oldObject instanceof InsuranceCompany) || !(newObject instanceof InsuranceCompany)) {
            throw new RuntimeException("Old and new insurancecompanies have to be of type: InsuranceCompany");
        }

        InsuranceCompany oldCompany = (InsuranceCompany) oldObject;
        InsuranceCompany newCompany = (InsuranceCompany) newObject;

        if (delete(oldCompany)) {
            return add(newCompany);
        }
        return false;
    }

    /**
     * Deletes the given parameter from the XML file.
     *
     * @param value attribute to specify which InsuranceCompany needs to get
     * deleted from the XML file.
     * @return boolean
     */
    @Override
    public boolean delete(Object value) {
        List<Object> result;

        if (value instanceof String) {
            result = get(value.toString());
        } else if (value instanceof InsuranceCompany) {
            InsuranceCompany company = (InsuranceCompany) value;
            result = get(company.getKVK());
        } else {
            return false;
        }

        if (result == null || result.size() != 1) {
            return false;
        }

        InsuranceCompany companyToDelete = (InsuranceCompany) result.get(0);
        List<Node> nodes = this.XMLParser.findElementsByName("company", companyToDelete.getKVK());
        nodes.stream().forEach((node) -> {
            this.XMLParser.deleteNode(node);
        });
        DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
        return true;
    }
}
