package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.ClientDAO;
import edu.avans.ivh5.shared.models.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ClientManager {

    //relaties
    private InvoiceManager invoiceManager;
    private ClientDAO clientDAO;

    public ClientManager() {
        try {
             clientDAO = new ClientDAO();
        }
        catch(ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
       
    }
    
    

    public ArrayList<Client> searchClient(String searchPattern) {
        return null;
    }

    public boolean addClient(Client client) {

        List<Object> clients = clientDAO.get(client.getBSN()); /* Make list with Objects */

        if (clients.isEmpty() == true) { /* check if list is empty. When list is empty, then start add function from clientDAO. */

            clientDAO.add(client);
            return true;
        } else {
            return false;

        }

    }

    public void deleteClient(Client client) {

    }

    public void changeClient(Client oldClient, Client newClient) {

    }

}
