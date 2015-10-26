package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class ClientDAO implements DAOInterface {

    private XMLParser XMLParser;

    public ClientDAO() throws ParserConfigurationException, SAXException, IOException{
        this.XMLParser = new XMLParser("Clients.xml", "Clients.xsd");
    }
    
    @Override
    public boolean add(Object item) {
        if(item instanceof Client)
        {
            Client client = (Client)item;
            Element newClientNode = this.XMLParser.createElement("client");
            
            Element BSN = this.XMLParser.createElement("BSN");
            Text BSNText =  this.XMLParser.createTextNode(client.getBSN());
            BSN.appendChild(BSNText);
            newClientNode.appendChild(BSN);
            
            Element name = this.XMLParser.createElement("name");
            Text nameText = this.XMLParser.createTextNode(client.getName());
            name.appendChild(nameText);
            newClientNode.appendChild(name);
            
            Element firstName = this.XMLParser.createElement("firstName");
            Text firstNameText = this.XMLParser.createTextNode(client.getFirstName());
            firstName.appendChild(firstNameText);
            newClientNode.appendChild(firstName);
            
            Element city = this.XMLParser.createElement("city");
            Text cityText = this.XMLParser.createTextNode(client.getCity());
            city.appendChild(cityText);
            newClientNode.appendChild(city);
            
            Element postcode = this.XMLParser.createElement("postcode");
            Text postcodeText = this.XMLParser.createTextNode(client.getPostcode());
            postcode.appendChild(postcodeText);
            newClientNode.appendChild(postcode);
            
            Element address = this.XMLParser.createElement("address");
            Text addressText = this.XMLParser.createTextNode(client.getAddress());
            address.appendChild(addressText);
            newClientNode.appendChild(address);
            
            Element IBAN = this.XMLParser.createElement("IBAN");
            Text IBANText = this.XMLParser.createTextNode(client.getIBAN());
            IBAN.appendChild(IBANText);
            newClientNode.appendChild(IBAN);
            
            Element incasso = this.XMLParser.createElement("incasso");
            Text incassoText = this.XMLParser.createTextNode(Boolean.toString(client.isIncasso()));
            incasso.appendChild(incassoText);
            newClientNode.appendChild(incasso);
            
            Element email = this.XMLParser.createElement("email");
            Text emailText = this.XMLParser.createTextNode(client.getEmail());
            email.appendChild(emailText);
            newClientNode.appendChild(email);
            
            Element tel = this.XMLParser.createElement("tel");
            Text telText = this.XMLParser.createTextNode(client.getTel());
            tel.appendChild(telText);
            newClientNode.appendChild(tel);
            
            this.XMLParser.addNode(newClientNode);;
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> get(Object item) {
        
        if(item instanceof String)
        {
            return getClients((String)item);
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
    
    private List<Object> getClients(String searchPattern)
    {
        List<Object> clients = new ArrayList<>();
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
    
    public static void main(String[] args)
    {
        Client c = new Client("38823", "achternaam", "voornaam", "stad", "postcode", "address", "iban", false, "email@email.com", "12345");
        try
        {
            ClientDAO dao = new ClientDAO();
            dao.add(c);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
