package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.shared.models.Client;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClientManagerTest {

    private ClientManager manager;
    Client client;

    public ClientManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        RmiMain m = new RmiMain("localhost");

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        RmiMain.main(new String[0]);
        manager = new ClientManager();

        client = new Client("201938157", "Helleman", "Bart", "Lekkerkerk", "9876KO", "Schuwacht 01", "NL00INGB000000", false, "bart_helleman@hotmail.com", "0656789012");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSearchClients() {
        try {
            manager.addClient(client);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            List<Client> searchResult = manager.searchClient(client.getFirstName());
            assert (searchResult.size() > 0);

            boolean hasFound = false;

            for (Client clients : searchResult) {
                if (clients.getName().equals(client.getName()) && clients.getBSN().equals(client.getBSN())) {
                    hasFound = true;
                }
            }
            assert (hasFound);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                manager.deleteClient(client.getBSN());
            } catch (RemoteException ex) {
                Logger.getLogger(ClientManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Test
    public void testDeleteClient() {

        try {

            List<Client> beforeAdding = null;
            try {
                beforeAdding = manager.searchClient(client.getBSN());
            } catch (RemoteException ex) {
                Logger.getLogger(ClientManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            int listSize = beforeAdding.size();
            try {
                manager.addClient(client);
            } catch (RemoteException ex) {
                Logger.getLogger(ClientManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            }

            List<Client> afterAdding = manager.searchClient(client.getBSN());

            assert (afterAdding.size() == listSize + 1);

            manager.deleteClient(client.getBSN());

            List<Client> afterDelete = manager.searchClient(client.getBSN());

            assert (beforeAdding.size() == afterDelete.size());

        } catch (RemoteException ex) {
            Logger.getLogger(ClientManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testAddClient() {
        try {
            List<Client> beforeAdding = manager.searchClient(client.getBSN());
            int listSize = beforeAdding.size();
            manager.addClient(client);
            try {
                List<Client> afterAdding = manager.searchClient(client.getBSN());
                assert (afterAdding.size() == listSize + 1);
            } finally {
                manager.deleteClient(client.getBSN());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ClientManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testChangeClient() {

        try {

            Client newClient = new Client("984422754", "Kerdel", "Niels", "Krimpen", "8765II", "Schuwacht 01", "NL00XXXX0000009000", false, "nielskerdel@hotmail.com", "0656789012");

            List<Client> beforeAdding = manager.searchClient(client.getBSN()); // 5 personen
            manager.addClient(client);

            try {
                List<Client> afterAdding = manager.searchClient(client.getBSN()); // 5 + 1 personen
                manager.changeClient(client, newClient);

                List<Client> result = manager.searchClient(client.getBSN());
                assert (result.size() > 0);
            } finally {
                manager.deleteClient(newClient.getBSN());
            }

        } catch (RemoteException ex) {
            Logger.getLogger(ClientManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
