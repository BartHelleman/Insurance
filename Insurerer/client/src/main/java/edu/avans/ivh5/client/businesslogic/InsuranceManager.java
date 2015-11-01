package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.InsuranceDAO;
import edu.avans.ivh5.server.dao.LoginDAO;
import edu.avans.ivh5.shared.models.Insurance;
import edu.avans.ivh5.shared.models.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class InsuranceManager {

    LoginDAO loginDAO;
    User user;
    private InsuranceDAO insuranceDAO;

    /**
     * @param searchPattern
     * @return
     */
    public ArrayList<Insurance> searchInsurance(String searchPattern) {
        return null;
    }
    
    /*public Insurance getInsurances(String searchPattern) {
        Insurance insurance = null;
        try {
            insuranceDAO = new InsuranceDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(InsuranceManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        insurance = (Insurance) InsuranceDAO.get(searchPattern);
        
        
        return insurance;
    }*/
    
    public List<Insurance> getInsurances(String searchPattern) {
        List<Insurance> insurances = new ArrayList();
        try {
            insuranceDAO = new InsuranceDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(InsuranceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        insurances = (List<Insurance>) insuranceDAO.get(insurances).get(0);
        
        return insurances;
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
    public boolean deleteInsurance(Insurance insurance) {
        return false;
    }

    /**
     *
     * @param oldInsurance
     * @param newInsurance
     * @return
     */
    public boolean changeInsurance(Insurance oldInsurance, Insurance newInsurance) {
        return false;
    }
}
