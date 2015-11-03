package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.presentation.LoginGUI;
import edu.avans.ivh5.server.dao.LoginDAO;
import edu.avans.ivh5.shared.models.User;
import edu.avans.ivh5.shared.util.BCrypt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class LoginManager {

    //private LoginDAO loginDAO = new LoginDAO();
    private LoginDAO loginDAO;
    private List<User> users = new ArrayList<>();
    private LoginGUI loginGUI;

    public boolean login(String username, String password) {

        try {
            loginDAO = new LoginDAO();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Er is een exception: " + e.getMessage());
        }

        if (!loginDAO.get(username).isEmpty()) {

            for (Object o : loginDAO.get(username)) {
                users.add((User) o);
            }
            for (User u : users) {
                if (username.equals(u.getUsername())) {
                    return u.getUsername().equals(username) && BCrypt.checkpw(password, u.getPassword()); // Login succesful
                }
            }
        }
        return false;
        // Login unsuccesful

    }

    public void logout() {
            //mainGUI.dispose();
            loginGUI = new LoginGUI();
    }
}
