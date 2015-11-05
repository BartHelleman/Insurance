package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.shared.models.User;
import java.rmi.RemoteException;

public class UserManager {

    public boolean createAccount(User user) throws RemoteException {

        return RmiMain.getRmiInterface().addUser(user);
    }

}
