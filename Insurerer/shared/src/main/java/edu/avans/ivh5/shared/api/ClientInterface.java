package edu.avans.ivh5.shared.api;

import edu.avans.ivh5.shared.models.*;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface ClientInterface extends Remote {   
    
    // <editor-fold defaultstate="collapsed" desc="#ClientManager methods">
    /**
     * Find a list of clients based on a search term
     * @param searchPattern the search terms
     * @return List of clients that match this search term
     */
    List<Client> searchClient(String searchPattern) throws RemoteException;
    
    /**
     * Add a client to the client list (stored in the XML files)
     * @param client Client that needs to be added
     * @return If adding went succesful
     */
    boolean addClient(Client client) throws RemoteException;
    
    boolean changeClient(Object oldvalue, Object newValue) throws RemoteException;
    
    boolean changeInvoice(Object oldInvoice, Object newInvoice) throws RemoteException;
    /**
     * Deletes a client from the client list (stored in the XML list)
     * @param client
     * @return 
     */
    boolean deleteClient(String client) throws RemoteException;
    
    boolean hadInsuranceContract(Client client) throws RemoteException;
    
    List<Invoice> getInvoices(Client client) throws RemoteException;
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="#InsuranceCompany methods">
    
    /**
     * Gets the current insurance company
     * @return current insurance company
     */
    InsuranceCompany getInsuranceCompany() throws RemoteException;
    
    /**
     * Changes the insurance company to another company
     * @param insuranceCompany the new insurance company
     * @return if the change was succesful
     */
    boolean changeInsuranceCompany(Object oldObject, Object newObject) throws RemoteException;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="#InsuranceManager methods">
    
    List<Insurance> searchInsurance(String searchPattern) throws RemoteException;
    List<Insurance> getInsurance(String value) throws RemoteException;
    List<Insurance> getInsurances(String searchPattern) throws RemoteException;
    List<TreatmentCode> getTreatmentCodes(String searchPattern) throws RemoteException;
    boolean addInsurance(Insurance insurance) throws RemoteException;
    boolean deleteInsurance(String id) throws RemoteException;
    boolean changeInsurance(Insurance oldInsurance, Insurance newInsurance) throws RemoteException;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="#InvoiceManager methods">
    
    InsuranceContract getInsuranceContract(Client client) throws RemoteException;
    InsuranceContract addInsuranceContract(InsuranceContract contract) throws RemoteException;
    boolean deleteInsuranceContract(Client client) throws RemoteException;
    Invoice getInvoice(Treatment treatment) throws RemoteException;
    //void printInvoice(InsuranceContract contract) throws RemoteException;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="#LoginManager methods">
    
    boolean checkLogin(String username, String password) throws RemoteException;
    boolean addUser(User user) throws RemoteException;
    boolean isAdmin(String username) throws RemoteException;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="#Other methods">
    
    ArrayList<SharedTreatment> getTreatmentsThatNeedToBeBilled() throws RemoteException;
    
    // </editor-fold>
    
    
}
