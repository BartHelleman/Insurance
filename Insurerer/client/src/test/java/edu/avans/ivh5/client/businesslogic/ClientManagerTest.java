/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.shared.models.Client;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Burak
 */
public class ClientManagerTest {

    private ClientManager manager;
    Client burakClient;

    public ClientManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        manager = new ClientManager();

        burakClient = new Client("201938157", "Helleman", "Bart", "Lekkerkerk", "9876KO", "Schuwacht 01", "NL00INGB000000", false, "bart_helleman@hotmail.com", "0656789012");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSearchClients() {
        manager.addClient(burakClient);
        try {

            List<Client> searchResult = manager.searchClient("Bart");
            assert (searchResult.size() > 0);

            boolean hasFound = false;

            for (Client client : searchResult) {
                if (client.getName().equals("Helleman") && client.getBSN().equals("201938157")) {
                    hasFound = true;
                }
            }
            assert (hasFound);
        } finally {
            manager.deleteClient(burakClient.getBSN());
        }
    }

    @Test
    public void testDeleteClient() {

        List<Client> beforeAdding = manager.searchClient("201938157"); // 5 personen
        int listSize = beforeAdding.size();
        manager.addClient(burakClient);

        List<Client> afterAdding = manager.searchClient("201938157"); // 5 + 1 personen

        assert (afterAdding.size() == listSize + 1);

        manager.deleteClient(burakClient.getBSN());

        List<Client> afterDelete = manager.searchClient("201938157"); // 5 personen
        System.out.println("Found3: " + manager.searchClient("201938157") + " Size: " + afterDelete.size());

        assert (beforeAdding.size() == afterDelete.size());

    }

    @Test
    public void testAddClient() {
        List<Client> beforeAdding = manager.searchClient("201938157");
        int listSize = beforeAdding.size();
        manager.addClient(burakClient);
        try {
            List<Client> afterAdding = manager.searchClient("201938157");
            assert (afterAdding.size() == listSize + 1);
        } finally {
            manager.deleteClient(burakClient.getBSN());
        }
    }

    @Test
    public void testChangeClient() {

        Client newBurak = new Client("984422754", "Kerdel", "Niels", "Krimpen", "8765II", "Schuwacht 01", "NL00XXXX0000009000", false, "nielskerdel@hotmail.com", "0656789012");

        List<Client> beforeAdding = manager.searchClient("201938157"); // 5 personen
        manager.addClient(burakClient);

        try {
            List<Client> afterAdding = manager.searchClient("201938157"); // 5 + 1 personen
            manager.changeClient(burakClient, newBurak);

            List<Client> result = manager.searchClient("984422754");
            assert (result.size() > 0);
        } finally {
            manager.deleteClient(newBurak.getBSN());
        }

    }
}
