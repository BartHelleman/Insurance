/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.Insurance;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    /*
    @Before
    public void setUp() {
        manager = new InsuranceManager();
        insurance = new Insurance(1, 5, "Behandeling", new BigDecimal("100"));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSearchInsurance() {
        manager.addInsurance(insurance);
        ArrayList<Insurance> foundInsurances = manager.searchInsurance("Behandeling");
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
        ArrayList<Insurance> beforeAdding = manager.searchInsurance("Behandeling");
        manager.addInsurance(insurance);
        ArrayList<Insurance> afterAdding = manager.searchInsurance("Behandeling");
        
        assert(afterAdding.size() == beforeAdding.size() + 1);
        manager.deleteInsurance(insurance);
    }

    @Test
    public void testChangeInsurance() {
        ArrayList<Insurance> beforeAdding = manager.searchInsurance("Behandeling");
        manager.addInsurance(insurance);
        ArrayList<Insurance> afterAdding = manager.searchInsurance("Behandeling");
        assert(afterAdding.size() == beforeAdding.size() + 1);
        
        Insurance newInsurance = new Insurance(2, 5, "Een behandeling", new BigDecimal("100"));
        manager.changeInsurance(insurance, newInsurance);
        
        ArrayList<Insurance> result = manager.searchInsurance("Een behandeling");
        assert(result.size() > 0);
        
        manager.deleteInsurance(newInsurance);
    }*/
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
