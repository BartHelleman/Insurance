package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ClientDAO implements DAOInterface {

    private XMLParser XMLParser;

    public ClientDAO() throws ParserConfigurationException, SAXException, IOException{
        this.XMLParser = new XMLParser("Clients.xml", "Clients.xsd");
    }
    
    @Override
    public boolean add(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> get(Object item) {
        if(item instanceof String)
        {
            return generateClients((String)item);
        }
        else if(item instanceof Client)
        {
            //???
        }
        throw new UnsupportedOperationException("The object type cannot be used to search in the XML files.");
    }

    @Override
    public boolean change(Object oldObject, Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Object> generateClients(String searchPattern)
    {
        ArrayList<Object> clients = new ArrayList<>();
        
        List<Node> clientsNodes = this.XMLParser.findElementsByName("client", searchPattern);
        
        for(int i = 0; i < clientsNodes.size(); i++)
        {
            Node clientNode = clientsNodes.get(i);
            
            String BSN = this.XMLParser.getValueByNodeName(clientNode, "BSN");
            String name = this.XMLParser.getValueByNodeName(clientNode, "name");
            String firstName = this.XMLParser.getValueByNodeName(clientNode, "firstName");
            String city = this.XMLParser.getValueByNodeName(clientNode, "city");
            String postcode = this.XMLParser.getValueByNodeName(clientNode, "postcode");
            String address = this.XMLParser.getValueByNodeName(clientNode, "address");
            String IBAN = this.XMLParser.getValueByNodeName(clientNode, "IBAN");
            boolean incasso = Boolean.getBoolean(this.XMLParser.getValueByNodeName(clientNode, "incasso"));
            String email = this.XMLParser.getValueByNodeName(clientNode, "email");
            String tel = this.XMLParser.getValueByNodeName(clientNode, "tel");

            clients.add(new Client(BSN, name, firstName, city, postcode, address, IBAN, incasso, email, tel));
        }
        
        return clients;
    }
}
