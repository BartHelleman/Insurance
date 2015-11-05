/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.rmi;

import edu.avans.ivh5.server.dao.*;
import edu.avans.ivh5.shared.api.ClientInterface;
import edu.avans.ivh5.shared.models.*;
import edu.avans.ivh5.shared.util.BCrypt;
import java.io.IOException;
import java.rmi.*;
import java.util.*;
import java.util.stream.Collectors;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.xml.sax.SAXException;

/**
 *
 * @author Burak
 */
public class ClientImpl implements ClientInterface {

    private Logger logger;
    private DAOInterface clientDAO;
    private DAOInterface insuranceCompanyDAO;
    private DAOInterface insuranceContractDAO;
    private DAOInterface insuranceDAO;
    private DAOInterface invoiceDAO;
    private DAOInterface loginDAO;
    private DAOInterface treatmentCodeDAO;
    private DAOInterface treatmentDAO;

    public ClientImpl() {
        logger = Logger.getLogger(ClientImpl.class);
        try {
            clientDAO = new ClientDAO();
            insuranceCompanyDAO = new InsuranceCompanyDAO();
            insuranceContractDAO = new InsuranceContractDAO();
            insuranceDAO = new InsuranceDAO();
            invoiceDAO = new InvoiceDAO();
            loginDAO = new LoginDAO();
            treatmentCodeDAO = new TreatmentCodeDAO();
            treatmentDAO = new TreatmentDAO();

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("EXCEPTION: " + ex.getMessage());
        }
    }

    @Override
    public List<Client> searchClient(String searchPattern) throws RemoteException {
        List<Client> clients = new ArrayList<>();
        for (Object o : clientDAO.get(searchPattern)) {
            clients.add((Client) o);
        }
        return clients;
    }

    @Override
    public boolean addClient(Client client) throws RemoteException {
        List<Object> clients = clientDAO.get(client.getBSN()); /* Make list with Objects */

        if (clients.isEmpty()) { /* check if list is empty. When list is empty, then start add function from clientDAO. */

            return clientDAO.add(client);
        } else {
            return false;

        }
    }

    @Override
    public boolean changeClient(Object oldClient, Object newClient) throws RemoteException {
        return clientDAO.change(oldClient, newClient);
    }

    @Override
    public boolean deleteClient(String clientBSN) throws RemoteException {
        return clientDAO.delete(clientBSN);
    }

    public boolean hadInsuranceContract(Client client) throws RemoteException {
        List<Object> contracts = insuranceContractDAO.get(client.getBSN());
        return !contracts.isEmpty();
    }

    @Override
    public InsuranceCompany getInsuranceCompany() throws RemoteException {
        List<InsuranceCompany> insuranceCompany = new ArrayList();
                
        for(Object o : insuranceCompanyDAO.get("")){
            insuranceCompany.add((InsuranceCompany) o);
        }
        return insuranceCompany.get(0);
    }

    @Override
    public boolean changeInsuranceCompany(Object oldObject, Object newObject) throws RemoteException {

        return insuranceCompanyDAO.change(oldObject, newObject);
    }

    @Override
    public List<Insurance> searchInsurance(String searchPattern) throws RemoteException {
        List<Object> result = new ArrayList<>();
        List<Insurance> insurance = new ArrayList<>();

        result = insuranceDAO.get(searchPattern);

        for (Object o : result) {
            insurance.add((Insurance) o);
        }

        return insurance;
    }

    @Override
    public List<Insurance> getInsurances(String searchPattern) throws RemoteException {
        List<Insurance> insurances = new ArrayList<>();

        for (Object o : insuranceDAO.get(searchPattern)) {
            insurances.add((Insurance) o);
        }
        return insurances;
    }

    @Override
    public List<Insurance> getInsurance(String value) throws RemoteException {

        List<Insurance> insurance = new ArrayList<>();
        insuranceDAO.get(value).stream().forEach(i -> insurance.add((Insurance) i));
        return insurance.stream().filter(i -> i.getID().equals(value)).collect(Collectors.toList());
    }

    @Override
    public boolean addInsurance(Insurance insurance) throws RemoteException {
        int i = getInsurance(insurance.getID()).size();
        
        System.out.println("" + i);
        if (getInsurance(insurance.getID()).isEmpty()) {
            System.out.println("clientImpl geeft true");
            return insuranceDAO.add(insurance);
            
        } else {
            System.out.println("meerdere resultaten verkregen?");
            return false;
        }

    }

    @Override
    public boolean deleteInsurance(String id) throws RemoteException {
        return insuranceDAO.delete(id);
    }

    @Override
    public boolean changeInsurance(Insurance oldInsurance, Insurance newInsurance) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TreatmentCode> getTreatmentCodes(String searchPattern) throws RemoteException {
        List<TreatmentCode> treatmentCodes = new ArrayList<>();

        for (Object o : treatmentCodeDAO.get(searchPattern)) {
            treatmentCodes.add((TreatmentCode) o);
        }
        return treatmentCodes;
    }

    @Override
    public InsuranceContract getInsuranceContract(Client client) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InsuranceContract addInsuranceContract(InsuranceContract contract) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInsuranceContract(String clientName) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Invoice getInvoice(Treatment treatment) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkLogin(String username, String password) throws RemoteException {
        List<User> users = new ArrayList<>();
        if (!loginDAO.get(username).isEmpty()) {

            for (Object o : loginDAO.get(username)) {
                users.add((User) o);
            }
            for (User u : users) {
                if (username.equals(u.getUsername())) {
                    return u.getUsername().equals(username) && BCrypt.checkpw(password, u.getPassword()); // Login succesful
                }
            }
        }
        return false;
        // Login unsuccesful

    }

}
