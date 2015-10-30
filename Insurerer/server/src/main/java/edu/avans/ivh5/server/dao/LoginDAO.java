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
        if(!(oldObject instanceof User) || !(newObject instanceof User))
            throw new RuntimeException("The object types must be type of 'User' ");
        
        User oldUser = (User)oldObject;
        User newUser = (User)newObject;
        
        if(delete(oldUser.getUsername()))
            return add(newUser);
        return false;
    }

    @Override
    public boolean delete(Object object) {
        List<Object> result = get(object.toString());
        if(result.size() != 1)
            return false;
        
        if(object instanceof String)
        {
            String searchPattern = (String)object;
            User userToDelete = (User)result.get(0);
            
            List<Node> nodes = this.XMLParser.findElementsByName("account", userToDelete.getUsername());
            for(Node node : nodes) {
                this.XMLParser.deleteNode(node);
            }
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;
        }
        return false;
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
    
}
