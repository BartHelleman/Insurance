package edu.avans.ivh5.client.businesslogic;

public class LoginManager {

    public boolean login(String username, String password) {
        if (username.equals("Rico") && password.equals("Bakels")) {
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
