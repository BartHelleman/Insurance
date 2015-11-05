/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.shared.models.InsuranceCompany;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Burak
 */
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
        manager = new InsuranceCompanyManager();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetInsuranceCompany() {
        try {
            manager.getInsuranceCompany();
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceCompanyManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testChange() {
        Object beforeChange = null;
        try {
            beforeChange = manager.getInsuranceCompany();
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceCompanyManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object newObject = new InsuranceCompany("Zorg4U", "Breda", "1234AB", "Breda", "0123456789");
        
        manager.change(beforeChange, newObject);
        
        Object afterChange = null;
        try {
            afterChange = manager.getInsuranceCompany();
        } catch (RemoteException ex) {
            Logger.getLogger(InsuranceCompanyManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assert(beforeChange != null && afterChange != null);
    }
}
