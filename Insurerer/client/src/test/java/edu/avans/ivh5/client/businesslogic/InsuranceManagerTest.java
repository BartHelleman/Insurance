/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.Insurance;
import edu.avans.ivh5.shared.models.Treatment;
import edu.avans.ivh5.shared.models.TreatmentCode;
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
import static org.junit.Assert.*;

/**
 *
 * @author Burak
 */
public class InsuranceManagerTest {
    
    private InsuranceManager manager;
    private Insurance insurance;
    
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
        manager = new InsuranceManager();
        List<String> treatments = new ArrayList();
        treatments.add("123456");
        insurance = new Insurance("007", "Zorgverkering Plus Extra", new BigDecimal("180"), treatments);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSearchInsurance() {
        try { 
            manager.searchInsurance(null);
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
            foundInsurances = manager.searchInsurance("Behandeling");
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assert(foundInsurances.size() > 0);
        
        boolean hasFound = false;
        
        for(Insurance ins : foundInsurances) {
            if(ins.getName().equals("Behandeling")) {
                hasFound = true;
            }
        }
        assert(hasFound);   
    }
    
    @Test
    public void testAddInsurance() {
        List<Insurance> beforeAdding = null;
        try {
            beforeAdding = manager.searchInsurance("Behandeling");
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            manager.addInsurance(insurance);
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Insurance> afterAdding = null;
        try {
            afterAdding = manager.searchInsurance("Behandeling");
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assert(afterAdding.size() == beforeAdding.size() + 1);
        try {
            manager.deleteInsurance(insurance.getID());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testChangeInsurance() {
        List<String> treatments = new ArrayList();
        treatments.add("123456");
        List<Insurance> beforeAdding = null;
        try {
            beforeAdding = manager.searchInsurance("Behandeling");
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            manager.addInsurance(insurance);
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Insurance> afterAdding = null;
        try {
            afterAdding = manager.searchInsurance("Behandeling");
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assert(afterAdding.size() == beforeAdding.size() + 1);
        
        Insurance newInsurance = new Insurance("", "", new BigDecimal("100"), treatments);
        manager.changeInsurance(insurance, newInsurance);
        
        List<Insurance> result = null;
        try {
            result = manager.searchInsurance("Een behandeling");
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assert(result.size() > 0);
        
        try {
            manager.deleteInsurance(newInsurance.getID());
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
