package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.LoginDAO;
import edu.avans.ivh5.shared.models.User;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class LoginManager {

    //private LoginDAO loginDAO = new LoginDAO();
    private User user;
    private LoginDAO loginDAO;

    public boolean login(String username, String password) {

        try {
            loginDAO = new LoginDAO();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Er is een exception: " + e.getMessage());
        }

        user = (User) loginDAO.get(username).get(0);

        //user = (User)loginDAO.get(username).get(0);
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            // Login succesful
            return true;
        } else {
            // Login unsuccesful
            return false;
        }
    }

    public void logout() {

    }
}
