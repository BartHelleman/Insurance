package edu.avans.ivh5.server.api;

import edu.avans.ivh5.shared.models.*;
import java.rmi.Remote;
import java.util.*;

public interface ClientInterface extends Remote {   
    // <editor-fold defaultstate="collapsed" desc="#ClientManager methods">
    /**
     * Find a list of clients based on a search term
     * @param searchPattern the search terms
     * @return List of clients that match this search term
     */
    List<Client> searchClient(String searchPattern);
    
    /**
     * Add a client to the client list (stored in the XML files)
     * @param client Client that needs to be added
     * @return If adding went succesful
     */
    boolean addClient(Client client);
    
    /**
     * Deletes a client from the client list (stored in the XML list)
     * @param client
     * @return 
     */
    boolean deleteClient(Client client);
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="#InsuranceCompany methods">
    
    /**
     * Gets the current insurance company
     * @return current insurance company
     */
    InsuranceCompany getInsuranceCompany();
    
    /**
     * Changes the insurance company to another company
     * @param insuranceCompany the new insurance company
     * @return if the change was succesful
     */
    boolean changeInsuranceCompany(InsuranceCompany insuranceCompany);
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="#InsuranceManager methods">
    
    List<Insurance> searchInsurance(String searchPattern);
    List<Insurance> getInsurances(String searchPattern);
    boolean addInsurance(Insurance insurance);
    boolean deleteInsurance(Insurance insurance);
    boolean changeInsurance(Insurance oldInsurance, Insurance newInsurance);
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="#InvoiceManager methods">
    
    InsuranceContract getInsuranceContract(Client client);
    InsuranceContract addInsuranceContract(InsuranceContract contract);
    void deleteInsuranceContract(String clientName);
    Invoice getInvoice(Treatment treatment);
    void printInvoice(InsuranceContract contract);
    
    // </editor-fold>
}
