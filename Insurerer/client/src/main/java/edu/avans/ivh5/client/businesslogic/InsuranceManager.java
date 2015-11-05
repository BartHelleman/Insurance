package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.shared.models.Insurance;
import edu.avans.ivh5.shared.models.TreatmentCode;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class InsuranceManager {

    private List<Insurance> insurances;

    public InsuranceManager() {
        insurances = new ArrayList();
    }

    /**
     * @param searchPattern
     * @return
     */
    public List<Insurance> searchInsurance(String searchPattern) throws RemoteException {

        return RmiMain.getRmiInterface().searchInsurance(searchPattern);

    }

    public List<Insurance> getInsurances(String searchPattern) throws RemoteException {

        return RmiMain.getRmiInterface().getInsurances(searchPattern);

//        try {
//            insuranceDAO = new InsuranceDAO();
//
//            List<Object> insurance = insuranceDAO.get(searchPattern);
//            for (Object i : insurance) {
//                insurances.add((Insurance) i);
//            }
//        } catch (ParserConfigurationException | SAXException | IOException ex) {
//            Logger.getLogger(InsuranceManager.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //List<String> treatments = new ArrayList();
//        //treatments.add("123");
//        //Insurance test = new Insurance(1, "naam", new BigDecimal(100), treatments);
//        //insurances.add(test);
//
//        return insurances;
    }

    public List<TreatmentCode> getTreatmentCodes(String searchPattern) throws RemoteException {

        return RmiMain.getRmiInterface().getTreatmentCodes(searchPattern);
    }

    /**
     *
     * @param insurance
     */
    public boolean addInsurance(Insurance insurance) throws RemoteException {

        return RmiMain.getRmiInterface().addInsurance(insurance);

    }

    /**
     *
     * @param insurance
     * @return
     */
    public boolean deleteInsurance(String id) throws RemoteException {

        return RmiMain.getRmiInterface().deleteInsurance(id);
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
