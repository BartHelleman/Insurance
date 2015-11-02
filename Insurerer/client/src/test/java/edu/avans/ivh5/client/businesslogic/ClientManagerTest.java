/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.shared.models.Client;
import java.util.ArrayList;
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
        //burakClient = new Client("123456", "Karatas", "Burak", "Utrecht", "1234AB", "blabla", "blabla", false, "", "12345");
    }

    @After
    public void tearDown() {
    }

    /*@Test
    public void testSearchClients() {
        manager.addClient(burakClient);
        try {
            ArrayList<Client> searchResult = manager.searchClient("Burak");
            assert (searchResult.size() > 0);

            boolean hasFound = false;

            for (Client client : searchResult) {
                //if(client.getName().equals("Karatas") && client.getBSN().equals("123456")) {
                //    hasFound = true;
                //}
            }
            assert (hasFound);
        } finally {
            manager.deleteClient(burakClient);
        }
    }

    @Test
    public void testDeleteClient() {

        ArrayList<Client> beforeAdding = manager.searchClient("123456"); // 5 personen
        manager.addClient(burakClient);

        ArrayList<Client> afterAdding = manager.searchClient("123456"); // 5 + 1 personen
        assert (afterAdding.size() == beforeAdding.size() + 1);

        manager.deleteClient(burakClient);

        ArrayList<Client> afterDelete = manager.searchClient("123456"); // 5 personen

        assert (beforeAdding.size() == afterDelete.size());
    }

    @Test
    public void testAddClient() {
        ArrayList<Client> beforeAdding = manager.searchClient("123456");
        manager.addClient(burakClient);
        try {
            ArrayList<Client> afterAdding = manager.searchClient("123456");
            assert (afterAdding.size() == beforeAdding.size() + 1);
        } finally {
            manager.deleteClient(burakClient);
        }
    }

    @Test
    public void testChangeClient() {

        Client newBurak = null;//= new Client("0987654", "Karatas", "Burak", "Utrecht", "1234AB", "blabla", "blabla", false, "", "12345");

        ArrayList<Client> beforeAdding = manager.searchClient("123456"); // 5 personen
        manager.addClient(burakClient);

        try {
            ArrayList<Client> afterAdding = manager.searchClient("123456"); // 5 + 1 personen
            manager.changeClient(burakClient, newBurak);

            ArrayList<Client> result = manager.searchClient("0987654");
            assert (result.size() > 0);
        } finally {
            manager.deleteClient(newBurak);
        }

    }*/
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
