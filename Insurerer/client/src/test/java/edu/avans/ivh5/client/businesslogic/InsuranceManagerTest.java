package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.shared.models.Insurance;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InsuranceManagerTest {

    private InsuranceManager manager;
    private Insurance insurance;
    private Insurance insurance2;
    private Insurance insurance3;

    public InsuranceManagerTest() {
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
        manager = new InsuranceManager();
        List<String> treatments = new ArrayList();
        treatments.add("123456");
        insurance = new Insurance("015", "Zorgverzekering BartHelleman", new BigDecimal("300"), treatments);
        insurance3 = new Insurance("017", "Zorgverzekering IETS", new BigDecimal("50"), treatments);
        insurance2 = new Insurance("024", "Zorgverzekering Poes", new BigDecimal("150"), treatments);
    }

    @After
    public void tearDown() {
    }

    /*
     Testing if the search function keeps on working even after adding and deleteing Insurances. 
     */
    @Test
    public void testSearchInsurance() {
        try {
            manager.searchInsurance(insurance.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            manager.addInsurance(insurance);

        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Insurance> foundInsurances = null;
        try {
            foundInsurances = manager.searchInsurance(insurance.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assert (foundInsurances.size() > 0);

        boolean hasFound = false;

        for (Insurance ins : foundInsurances) {
            if (ins.getName().equals(insurance.getName())) {
                hasFound = true;
            }
        }

        assert (hasFound);

        try {
            manager.deleteInsurance(insurance.getID());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Insurance> foundInsurances2 = null;

        try {
            foundInsurances2 = manager.searchInsurance(insurance.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assert (foundInsurances2.isEmpty());
    }

    /*
     Checking if insurance already exists.
     Adding a new insurance and searching for it again to see if it succeeded.
     Deleting it afterwards.
     */
    @Test
    public void testAddInsurance() {
        List<Insurance> beforeAdding = null;
        try {
            beforeAdding = manager.searchInsurance(insurance3.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            manager.addInsurance(insurance3);
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Insurance> afterAdding = null;
        try {
            afterAdding = manager.searchInsurance(insurance3.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assert (afterAdding.size() == beforeAdding.size() + 1);
        try {
            manager.deleteInsurance(insurance3.getID());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     Making sure insurance does not already exists.
     Adding it and making sure it worked.
     Making a new insurance which we use to change the old insurance with.
     Making sure the change worked and deleting it afterwards.
     */
    @Test
    public void testChangeInsurance() {
        List<String> treatments = new ArrayList();
        treatments.add("123456");
        List<Insurance> beforeAdding = null;
        try {
            beforeAdding = manager.searchInsurance(insurance2.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            manager.addInsurance(insurance2);
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Insurance> afterAdding = null;
        try {
            afterAdding = manager.searchInsurance(insurance2.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assert (afterAdding.size() == beforeAdding.size() + 1);

        Insurance newInsurance = new Insurance("021", "Zorgverzekering BusinessIntelligence", new BigDecimal("150"), treatments);
        manager.changeInsurance(insurance2, newInsurance);

        List<Insurance> result = null;
        try {
            result = manager.searchInsurance(newInsurance.getName());

        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assert (result.size() > 0 && !afterAdding.get(0).getID().equals(result.get(0).getID()));

        try {
            manager.deleteInsurance(newInsurance.getID());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
     Checking if insurance exists and adding it.
     Checking if the delete works by searching it afterwards again.
     */
    @Test
    public void testDeleteInsurance() {
        try {

            List<Insurance> beforeAdding = null;
            try {
                beforeAdding = manager.searchInsurance(insurance.getName()); // 5 personen
            } catch (RemoteException ex) {
                Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            int listSize = beforeAdding.size();
            try {
                manager.addInsurance(insurance);
            } catch (RemoteException ex) {
                Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            }

            List<Insurance> afterAdding = manager.searchInsurance(insurance.getName());

            assert (afterAdding.size() == listSize + 1);

            manager.deleteInsurance(insurance.getID());

            List<Insurance> afterDelete = manager.searchInsurance(insurance.getName());

            assert (beforeAdding.size() == afterDelete.size());

        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
