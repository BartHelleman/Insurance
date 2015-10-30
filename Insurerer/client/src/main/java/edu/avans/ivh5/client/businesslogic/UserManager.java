package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.LoginDAO;
import edu.avans.ivh5.shared.models.User;
import edu.avans.ivh5.shared.util.BCrypt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
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

    }

    public boolean userValid(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).collect(Collectors.toList()).isEmpty();

    }

    public boolean passwordValid(String password) {

        return password.matches("^[a-zA-Z0-9]+$");
    }

    public boolean createAccount(String username, String password) {

        for (Object o : loginDAO.get("")) {
            users.add((User) o);
        }

        if (!userValid(username)) {
            System.out.println("Deze username bestaat al");
            return false;
        } else {
            System.out.println("nieuwe username");
            User user = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()));
            loginDAO.add(user);
            users.clear();

            return true;

        }
    }

}
