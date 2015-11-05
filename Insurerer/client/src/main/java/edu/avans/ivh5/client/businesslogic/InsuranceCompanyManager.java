package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.shared.models.InsuranceCompany;
import java.rmi.RemoteException;

public class InsuranceCompanyManager {

    /**
     * Method to get the InsuranceCompany from the DAO class.
     *
     * @return InsuranceCompany
     * @throws java.rmi.RemoteException
     */
    public InsuranceCompany getInsuranceCompany() throws RemoteException {

        return RmiMain.getRmiInterface().getInsuranceCompany();
    }

    /**
     * Method to change the old values of insuranceCompany to the ones from the
     * text fields.
     *
     * @param oldObject the current values of InsuranceCompany
     * @param newObject the new values of InsuranceCompany
     * @return
     * @throws java.rmi.RemoteException
     */
    public boolean changeInsuranceCompany(Object oldObject, Object newObject) throws RemoteException {
        return RmiMain.getRmiInterface().changeInsuranceCompany(oldObject, newObject);
    }

}
