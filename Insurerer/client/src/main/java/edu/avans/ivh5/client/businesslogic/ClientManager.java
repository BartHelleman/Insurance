package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.server.dao.ClientDAO;
import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.Invoice;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ClientManager {

    //relaties
    private InsuranceContractManager insuranceContractManager;
    private ClientDAO clientDAO;
    private List<Client> clienten;

    public ClientManager() {

        clienten = new ArrayList<>();
    }

    public List<Client> searchClient(String searchPattern) throws RemoteException {

        return RmiMain.getRmiInterface().searchClient(searchPattern);

    }

    public boolean addClient(Client client) throws RemoteException{

        return RmiMain.getRmiInterface().addClient(client);
    }



    public boolean deleteClient(String clientBSN) throws RemoteException {
        return RmiMain.getRmiInterface().deleteClient(clientBSN);
    }

    public boolean changeClient(Client oldClient, Client newClient) throws RemoteException {
        return RmiMain.getRmiInterface().changeClient(oldClient, newClient);
    }
    
    public boolean hasInsuranceContract(Client client) throws RemoteException {
       
        return RmiMain.getRmiInterface().hadInsuranceContract(client);
        
    }
    
    public List<Invoice> getInvoices(Client client) throws RemoteException {

        return RmiMain.getRmiInterface().getInvoices(client);
    }

}
