package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.shared.models.InsuranceCompany;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InsuranceCompanyManagerTest {

    private InsuranceCompanyManager manager;

    public InsuranceCompanyManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        RmiMain.main(new String[0]);
        manager = new InsuranceCompanyManager();
    }

    @After
    public void tearDown() {
    }

    /*
     Getting insuranceCompany data and making sure it actually returned something
     */
    @Test
    public void testGetInsuranceCompany() {
        InsuranceCompany insuranceCompany = null;
        try {
            insuranceCompany = manager.getInsuranceCompany();
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceCompanyManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assert (insuranceCompany.getName() != null);
    }

    /*
     Creating a new InsuranceCompany which will be used later.
     Checking old data and changing the data after it.
     Checking if the data got changed.
     */
    @Test
    public void testChange() {
        Object beforeChange = null;
        InsuranceCompany beforeIC = null;
        try {
            beforeChange = manager.getInsuranceCompany();
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceCompanyManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        beforeIC = (InsuranceCompany) beforeChange;

        Object newObject = new InsuranceCompany("Arfer", "Eindhoven", "1234AB", "Eindhoven", "0123456789");

        try {
            manager.changeInsuranceCompany(beforeChange, newObject);
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceCompanyManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object afterChange = null;
        InsuranceCompany afterIC = null;
        try {
            afterChange = manager.getInsuranceCompany();
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceCompanyManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        afterIC = (InsuranceCompany) afterChange;

        assert (beforeChange != null && afterChange != null && !afterIC.getName().equals(beforeIC.getName()));
    }
}
