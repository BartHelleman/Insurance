package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.shared.models.User;
import edu.avans.ivh5.shared.util.BCrypt;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserManagerTest {

    private UserManager userManager;
    private LoginManager loginManager;
    private User user;
    String password;
    String username;
    String accountType;

    public UserManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        RmiMain.main(new String[0]);
        loginManager = new LoginManager();
        userManager = new UserManager();

        username = "Persoon1";
        password = "Wachtwoord1";
        accountType = "Gebruiker";
        user = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()), accountType);
    }

    @After
    public void tearDown() {
    }

    /*
     Trying to create a new account with an username and an encrypted password (encrypting happens in the GUI, but we are not testing that one)
     Checking if it succeeded by trying to log in with the new account.
     */
    @Test
    public void testCreateAccount() {
        try {
            userManager.createAccount(user);
        } catch (RemoteException ex) {
            Logger.getLogger(UserManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            assert (loginManager.login(username, password) == true);

        } catch (RemoteException ex) {
            Logger.getLogger(UserManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
