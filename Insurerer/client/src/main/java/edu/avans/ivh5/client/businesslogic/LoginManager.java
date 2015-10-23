package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.LoginDAO;
import edu.avans.ivh5.shared.models.User;

public class LoginManager {
    
    private LoginDAO loginDAO = new LoginDAO();
    private User user;
    
    public boolean login(String username, String password) {
        
        user = (User)loginDAO.get(username).get(0);
        
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
