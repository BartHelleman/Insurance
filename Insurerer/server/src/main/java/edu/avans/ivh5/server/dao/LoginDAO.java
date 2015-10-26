package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.User;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import edu.avans.ivh5.server.dao.XMLParser;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class LoginDAO implements DAOInterface {

    private XMLParser XMLParser;
    
    public LoginDAO() throws ParserConfigurationException, SAXException, IOException {
        this.XMLParser = new XMLParser("Accounts.xml", "Accounts.xsd");
    }
    
    @Override
    public boolean add(Object item) {
        if(item instanceof User)
        {
            Element userNode = this.XMLParser.createElement("account");
            User user = (User)item;
            
            Element username = this.XMLParser.createElement("username");
            Text usernameText = this.XMLParser.createTextNode(user.getUsername());
            username.appendChild(usernameText);
            userNode.appendChild(username);
            
            Element password = this.XMLParser.createElement("password");
            Text passwordText = this.XMLParser.createTextNode(user.getPassword());
            password.appendChild(passwordText);
            userNode.appendChild(password);
            
            this.XMLParser.addNode(userNode);
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;
        }
        
        return false;
    }

    @Override
    public List<Object> get(Object item) {
        if(item instanceof String) {
            return getUsers((String)item);
        }
        else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public boolean change(Object oldObject, Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Object> getUsers(String searchPattern) {
        List<Object> users = new ArrayList<>();
        List<Node> userNodes = this.XMLParser.findElementsByName("account", searchPattern);
        
        for(int i = 0; i < userNodes.size(); i++)
        {
            Node userNode = userNodes.get(i);
            
            String username = this.XMLParser.getValueByNodeName(userNode, "username");
            String password = this.XMLParser.getValueByNodeName(userNode, "password");

            users.add(new User(username, password));
        }
        
        return users;
    }
    
    public static void main(String[] args)
    {
        try {
            LoginDAO dao = new LoginDAO();
            dao.add(new User("Burak", "Karatas"));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
