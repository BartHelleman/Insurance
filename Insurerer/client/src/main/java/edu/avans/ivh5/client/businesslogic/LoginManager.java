package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.client.presentation.LoginGUI;
import edu.avans.ivh5.server.dao.LoginDAO;
import edu.avans.ivh5.shared.models.User;
import edu.avans.ivh5.shared.util.BCrypt;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class LoginManager {

    //private LoginDAO loginDAO = new LoginDAO();
    private List<User> users = new ArrayList<>();
    private LoginGUI loginGUI;
    
    public boolean login(String username, String password) throws RemoteException {
        return RmiMain.getRmiInterface().checkLogin(username, password);
    }

    public void logout() {
            //mainGUI.dispose();
            loginGUI = new LoginGUI();
    }
}
