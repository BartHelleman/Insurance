package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginManagerTest {

    private LoginManager manager;

    public LoginManagerTest() {
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
        manager = new LoginManager();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLogin() {
        String username = "Rico";
        String password = "Bakels";

        try {
            assert (manager.login(username, password) == true);
        } catch (RemoteException ex) {
            Logger.getLogger(LoginManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testLogout() {
        manager.logout();
    }
}
