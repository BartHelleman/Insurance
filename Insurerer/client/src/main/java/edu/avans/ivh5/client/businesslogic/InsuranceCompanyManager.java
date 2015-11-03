package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.server.dao.InsuranceCompanyDAO;
import edu.avans.ivh5.shared.models.InsuranceCompany;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class InsuranceCompanyManager {

    String name = "";
    String city = "";
    String postcode = "";
    String address = "";
    String KVK = "";
    private InsuranceCompanyDAO insuranceCompanyDAO;

    /**
     * Method to get the InsuranceCompany from the DAO class.
     *
     * @return InsuranceCompany
     */
    public InsuranceCompany getInsuranceCompany() {
        InsuranceCompany insuranceCompany;

        try {
            insuranceCompanyDAO = new InsuranceCompanyDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }

        insuranceCompany = (InsuranceCompany) insuranceCompanyDAO.get("").get(0);

        return insuranceCompany;
    }

    /**
     * Method to change the old values of insuranceCompany to the ones from the
     * textfields.
     *
     * @param oldObject the current values of InsuranceCompany
     * @param newObject the new values of InsuranceCompany
     */
    public void change(Object oldObject, Object newObject) {
        Boolean insuranceCompany = null;

        try {
            insuranceCompanyDAO = new InsuranceCompanyDAO();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }

        insuranceCompany = insuranceCompanyDAO.change(oldObject, newObject);
    }
}
