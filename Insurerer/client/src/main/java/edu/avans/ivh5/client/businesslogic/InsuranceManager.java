package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.LoginDAO;
import edu.avans.ivh5.shared.models.Insurance;
import edu.avans.ivh5.shared.models.InsuranceCompany;
import edu.avans.ivh5.shared.models.User;
import java.util.ArrayList;

public class InsuranceManager {
    
    LoginDAO loginDAO;
    User user;

    /**
     *
     * @param user
     * @param password
     */
    public void createAccount(String user, String password) {

    }

    /**
     * @param searchPattern
     * @return
     */
    public ArrayList<Insurance> searchInsurance(String searchPattern) {
        return null;
    }

    /**
     *
     * @param InsuranceComanany
     * @return
     */
    public boolean changeInsuranceCompany(InsuranceCompany InsuranceComanany) {
        return false;
    }
    
    /**
     *
     * @param insurance
     */
    public void addInsurance(Insurance insurance) {

    }
    /**
     * 
     * @param insurance
     * @return 
     */
    public boolean deleteInsurance(Insurance insurance){
        return false;
    }
    
    /**
     * 
     * @param oldInsurance
     * @param newInsurance 
     * @return  
     */
    public boolean changeInsurance(Insurance oldInsurance, Insurance newInsurance){
       return false;
    }
}
