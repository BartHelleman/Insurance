package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.LoginDAO;
import edu.avans.ivh5.shared.models.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class UserManager {

    String username = "";
    String password = "";
    List<User> users = new ArrayList<>();
    LoginDAO loginDAO;

    public UserManager() {
        try {
            loginDAO = new LoginDAO();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Er is een exception: " + e.getMessage());
        }

        for (Object o : loginDAO.get("")) {
            users.add((User) o);
        }
    }

    public boolean checkUser(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).collect(Collectors.toList()).isEmpty();

    }

    public boolean createAccount(String username, String password) {

        if (!checkUser(username)) {
            System.out.println("Deze username bestaat al");
            return false;
        } else {
            System.out.println("nieuwe username");
            User user = new User(username, password);
            return true;
        }
    }

}
