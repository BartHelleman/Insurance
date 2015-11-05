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
public class UserManagerTest {
    
    private UserManager manager;
    private LoginManager loginManager;
   
    public UserManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        manager = new UserManager();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testUserValid() {
        String username = "Rico";
        
        assert(manager.userValid(username) == true);
    }
    
    @Test
    public void testPasswordValid() {
        String password = "Bakels";
                
        assert(manager.passwordValid(password) == true);
    }
    
    @Test
    public void testCreateAccount() {
        String username = "Niels";
        String password = "Kerdel";
        boolean hasFound = false;
        
        if( manager.createAccount(username, password) == true) {
            try {
                if(loginManager.login(username, password) == true) {
                    hasFound = true;
                }
            } catch (RemoteException ex) {
                Logger.getLogger(UserManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        assert(hasFound);
    }
}
