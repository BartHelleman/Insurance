/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.rmi;

import edu.avans.ivh5.server.dao.*;
import edu.avans.ivh5.server.main.Main;
import edu.avans.ivh5.shared.api.ClientInterface;
import edu.avans.ivh5.shared.models.*;
import edu.avans.ivh5.shared.util.BCrypt;
import java.io.IOException;
import java.math.BigDecimal;
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
    private static DAOInterface clientDAO;
    private static DAOInterface insuranceCompanyDAO;
    private static DAOInterface insuranceContractDAO;
    private static DAOInterface insuranceDAO;
    private static DAOInterface invoiceDAO;
    private static DAOInterface loginDAO;
    private static DAOInterface treatmentCodeDAO;
    private static DAOInterface treatmentDAO;

    public ClientImpl() {
        logger = Logger.getLogger(ClientImpl.class);
    }

    static {
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
        List<Object> clients = clientDAO.get(client.getBSN());
        /* Make list with Objects */

        if (clients.isEmpty()) {
            /* check if list is empty. When list is empty, then start add function from clientDAO. */

            return clientDAO.add(client);
        } else {
            return false;

        }
    }

    @Override
    public boolean changeClient(Object oldClient, Object newClient) throws RemoteException {
        Client oldClientObj = (Client)oldClient;
        Client newClientObj = (Client)newClient;
        if(!oldClientObj.getBSN().equals(newClientObj.getBSN())) // Only change contracts if the PK changed
        {
            List<Object> allContracts = insuranceContractDAO.get(oldClientObj.getBSN());

            for(Object contract : allContracts)
            {
                InsuranceContract newContract = (InsuranceContract)contract;
                newContract.setBSN(newClientObj.getBSN());
                newContract.setClientName(newClientObj.getFirstName() + newClientObj.getName());
                insuranceContractDAO.change(contract, newContract);
            }
        }
        return clientDAO.change(oldClient, newClient);
    }

    @Override
    public boolean changeInvoice(Object oldInvoice, Object newInvoice) throws RemoteException {
        return invoiceDAO.change(oldInvoice, newInvoice);
    }

    @Override
    public boolean deleteClient(String clientBSN) throws RemoteException {
        List<Object> insuranceContracts = insuranceContractDAO.get(clientBSN);
        if(insuranceContracts.size() == 1)
            insuranceContractDAO.delete(Integer.toString(((InsuranceContract)insuranceContracts.get(0)).getInsuranceID()));
        return clientDAO.delete(clientBSN);
    }

    @Override
    public boolean hadInsuranceContract(Client client) throws RemoteException {
        List<Object> contracts = insuranceContractDAO.get(client.getBSN());
        return !contracts.isEmpty();
    }

    @Override
    public InsuranceCompany getInsuranceCompany() throws RemoteException {
        List<InsuranceCompany> insuranceCompany = new ArrayList();

        for (Object o : insuranceCompanyDAO.get("")) {
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
        List<Object> result;
        List<Insurance> insurance = new ArrayList<>();

        result = insuranceDAO.get(searchPattern);

        result.stream().forEach((o) -> {
            insurance.add((Insurance) o);
        });

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
        List<Object> insurances = insuranceDAO.get(insurance.getID());

        if (insurances.isEmpty()) {
            return insuranceDAO.add(insurance);

        } else {
            return insuranceDAO.change(insurance, insurance);
        }

    }

    @Override
    public boolean deleteInsurance(String id) throws RemoteException {
        // Check if anyone has this insurance in their insurance policy first
        List<Object> allContracts = insuranceContractDAO.get(id);
        return allContracts.isEmpty() && insuranceDAO.delete(id);
    }

    @Override
    public boolean changeInsurance(Insurance oldInsurance, Insurance newInsurance) throws RemoteException {
        
        // We only have to change the contracts if the insurance IDs have changed
        if(!oldInsurance.getID().equals(newInsurance.getID()))
        {
            List<Object> allContracts = insuranceContractDAO.get(oldInsurance.getID());

            for(Object contract : allContracts)
            {
                InsuranceContract newContract = (InsuranceContract)contract;
                newContract.setInsuranceID(Integer.parseInt(newInsurance.getID()));
                insuranceContractDAO.change(contract, newContract);
            }
        }
        return insuranceDAO.change(oldInsurance, newInsurance);
    }

    @Override
    public List<TreatmentCode> getTreatmentCodes(String searchPattern) throws RemoteException {
        List<TreatmentCode> treatmentCodes = new ArrayList<>();

        treatmentCodeDAO.get(searchPattern).stream().forEach((o) -> {
            treatmentCodes.add((TreatmentCode) o);
        });
        return treatmentCodes;
    }

    @Override
    public InsuranceContract getInsuranceContract(Client client) throws RemoteException {
        InsuranceContract insuranceContract;

// get all data off insurancecontracts
        if (insuranceContractDAO.get(client.getBSN()).size() == 1) {
            insuranceContract = (InsuranceContract) insuranceContractDAO.get(client.getBSN()).get(0);
        } else {
            insuranceContract = new InsuranceContract(null, null, client.getBSN(), 0, null, null);
        }

        return insuranceContract;
    }

    @Override
    public InsuranceContract addInsuranceContract(InsuranceContract contract) throws RemoteException {

        ArrayList<InsuranceContract> insuranceContracts = new ArrayList<>();
        insuranceContracts.add(contract);

        insuranceContracts.stream().forEach(p -> insuranceContractDAO.add(p));

        return null;

    }

    @Override
    public boolean deleteInsuranceContract(Client client) throws RemoteException {
        List<Object> contracts = insuranceContractDAO.get(client.getBSN());
        return contracts.isEmpty() && insuranceContractDAO.delete(client.getBSN());
    }

    @Override
    public Invoice getInvoice(Treatment treatment) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkLogin(String username, String password) throws RemoteException {
        List<User> users = new ArrayList<>();
        if (!loginDAO.get(username).isEmpty()) {

            loginDAO.get(username).stream().forEach((o) -> {
                users.add((User) o);
            });
            for (User u : users) {
                if (username.equals(u.getUsername())) {
                    return u.getUsername().equals(username) && BCrypt.checkpw(password, u.getPassword()); // Login succesful
                }
            }
        }
        return false;

    }

    @Override
    public boolean isAdmin(String username) throws RemoteException {
        List<Object> users = loginDAO.get(username);    
        for (Object u : users) {
            User user = (User)u;
            if(user.getUsername().equals(username))
            {
                return user.getAccountType().equals("Admin");
            }
        }
        return false;
        }
        /**
         * Subtracts deductible of a client by a certain amount
         *
         * @param client Client whose deductible needs to decrease
         * @param amountToReduce Amount of money that needs to be taken off
         * @return An array where the first value says how much money doesn't
         * fit in the deductible anymore, and second value is the current
         * deductible (that's left)
         */
    public static BigDecimal[] subtractDeductible(Client client, BigDecimal amountToReduce) {
        List<Object> insuranceContract = insuranceContractDAO.get(client.getBSN());

        if (insuranceContract.size() > 0) {
            InsuranceContract contract = (InsuranceContract) insuranceContract.get(0);
            contract.setOwnRisk(contract.getOwnRisk().subtract(amountToReduce)); // own risk = own risk - cost

            BigDecimal retVal = contract.getOwnRisk();
            if (contract.getOwnRisk().compareTo(BigDecimal.ZERO) == -1) // if less than 0
            {
                retVal = contract.getOwnRisk().abs(); // The value in the negative is what goes beyond your deductible, aka the reimbursed amount
                contract.setOwnRisk(BigDecimal.ZERO);
            } else {
                retVal = BigDecimal.ZERO;
            }
            insuranceContractDAO.change(contract, contract);
            BigDecimal[] d = new BigDecimal[2];
            d[0] = retVal;
            d[1] = contract.getOwnRisk();
            return d;
        }

        return null;
    }

    @Override
    public boolean addUser(User user) throws RemoteException {
        return loginDAO.add(user);
    }

    @Override
    public ArrayList<SharedTreatment> getTreatmentsThatNeedToBeBilled() throws RemoteException {
        if (Main.RMI) {
            return Main.getPhysioInterface().getAllFinishedTreatments();
        } else {
            ArrayList<SharedTreatment> treatments = new ArrayList<>();
            treatments.add(new SharedTreatment("209000454", "002behandelcode002", 5));
            return treatments;
        }
    }

    @Override
    public List<Invoice> getInvoices(Client client) throws RemoteException {
        List<Object> invoicesObjects = invoiceDAO.get(client.getBSN());
        List<Invoice> invoices = new ArrayList<>();
        invoicesObjects.forEach(i -> {
            Invoice invoice = (Invoice) i;
            if (invoice.getBSN().equals(client.getBSN())) {
                invoices.add(invoice);
            }
        });
        return invoices;
    }

    public static DAOInterface getClientDAO() {
        return clientDAO;
    }

    public static DAOInterface getInsuranceCompanyDAO() {
        return insuranceCompanyDAO;
    }

    public static DAOInterface getInsuranceContractDAO() {
        return insuranceContractDAO;
    }

    public static DAOInterface getInsuranceDAO() {
        return insuranceDAO;
    }

    public static DAOInterface getInvoiceDAO() {
        return invoiceDAO;
    }

    public static DAOInterface getLoginDAO() {
        return loginDAO;
    }

    public static DAOInterface getTreatmentCodeDAO() {
        return treatmentCodeDAO;
    }

    public static DAOInterface getTreatmentDAO() {
        return treatmentDAO;
    }

}
