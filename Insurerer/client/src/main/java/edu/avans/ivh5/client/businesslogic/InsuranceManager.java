package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.InsuranceDAO;
import edu.avans.ivh5.server.dao.LoginDAO;
import edu.avans.ivh5.server.dao.TreatmentCodeDAO;
import edu.avans.ivh5.shared.models.Insurance;
import edu.avans.ivh5.shared.models.TreatmentCode;
import edu.avans.ivh5.shared.models.User;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class InsuranceManager {

    LoginDAO loginDAO;
    private InsuranceDAO insuranceDAO;
    private TreatmentCodeDAO treatmentCodeDAO;
    private List<Insurance> insurances;

    public InsuranceManager() {
        insurances = new ArrayList();
        try {
            insuranceDAO = new InsuranceDAO();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param searchPattern
     * @return
     */
    public List<Insurance> searchInsurance(String searchPattern) {
        insurances.clear();
        List<Object> result = insuranceDAO.get(searchPattern);

        for (Object o : result) {
            insurances.add((Insurance) o);
        }
        return insurances;
    }

    public List<Insurance> getInsurances(String searchPattern) {
        List<Insurance> insurances = new ArrayList();
        try {
            insuranceDAO = new InsuranceDAO();

            List<Object> insurance = insuranceDAO.get(searchPattern);
            for(int i = 0; i < insurance.size(); i++) {
                insurances.add((Insurance) insurance.get(i));

            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(InsuranceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        //List<String> treatments = new ArrayList();
        //treatments.add("123");
        //Insurance test = new Insurance(1, "naam", new BigDecimal(100), treatments);
        //insurances.add(test);

        return insurances;
    }
    
    public List<TreatmentCode> getTreatmentCodes(String searchPattern){
        List<Object> result = new ArrayList<>();
        List<TreatmentCode> treatmentCodes = new ArrayList<>();
        
        try {
            treatmentCodeDAO = new TreatmentCodeDAO();
                    } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(InsuranceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        result = treatmentCodeDAO.getTreatments(searchPattern);
        for(Object o : result){
            treatmentCodes.add((TreatmentCode) o);
        }
        return treatmentCodes;
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
    public void deleteInsurance(String id) {
        insuranceDAO.delete(id);
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
