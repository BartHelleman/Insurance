package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.shared.models.User;
import java.util.ArrayList;

public class UserManager {

    String username = "";
    String password = "";
    ArrayList<User> users = new ArrayList();

    public UserManager() {

    }

    public boolean checkUser(String username) {
        return users.contains(username);
    }

    public void createAccount(String username, String password) {
        this.username = username;
        this.password = password;
        User user = new User(username, password);
        users.add(user);
    }

}
