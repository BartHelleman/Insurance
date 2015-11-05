/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.presentation.UserGUI;
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
    private UserGUI userGUI;
    private UserManager userManager;
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
        userGUI = new UserGUI();
        userManager = new UserManager();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPasswordValid() {
        String password = "Bakels";

        assert (userGUI.passwordValid(password) == true);
    }

}
