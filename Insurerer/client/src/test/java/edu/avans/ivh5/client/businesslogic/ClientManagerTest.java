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

    /*
     Adding client which can be searched for later. 
     If a client can be found and it matches the details of the old client test succeeded. 
     After delete the client.
     */
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

    /*
     Making sure the client from the other test is deleted by searching it before adding. 
     If it succeeded delete client again and check if it is deleted.
     */
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

    /*
     Again making sure client got deleted before adding it again.
     Checking if adding was succesfull.
     Deleting afterwards. 
     */
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

    /*
     First making a new client which will be used to change the other client with.
     Making sure client got deleted from the other tests before adding again.
     Changing the client info and checking if it succedeed in doing so + checking if data actually got changed.
     Deleting client afterwards.
     */
    @Test
    public void testChangeClient() {

        try {

            Client newClient = new Client("984422754", "Kerdel", "Niels", "Krimpen", "8765II", "Schuwacht 01", "NL00XXXX0000009000", false, "nielskerdel@hotmail.com", "0656789012");

            List<Client> beforeAdding = manager.searchClient(client.getBSN());
            manager.addClient(client);

            try {
                List<Client> afterAdding = manager.searchClient(client.getBSN());
                manager.changeClient(client, newClient);

                List<Client> result = manager.searchClient(newClient.getBSN());
                assert (result.size() > 0 && !afterAdding.get(0).getBSN().equals(result.get(0).getBSN()));
            } finally {
                manager.deleteClient(newClient.getBSN());
            }

        } catch (RemoteException ex) {
            Logger.getLogger(ClientManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
