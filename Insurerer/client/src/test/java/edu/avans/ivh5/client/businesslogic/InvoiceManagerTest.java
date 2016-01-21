package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.InsuranceContract;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InvoiceManagerTest {

    private InvoiceManager manager;
    private InsuranceContract insuranceContract;
    private Client client;

    public InvoiceManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        manager = new InvoiceManager();
        RmiMain.main(new String[0]);
        SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-dd");
        String testStartDate = "2000-02-02";
        String testEndDate = "2010-02-02";
        Date startDate = null;
        Date endDate = null;

        try {
            startDate = format.parse(testStartDate);
            endDate = format.parse(testEndDate);
        } catch (ParseException ex) {
            Logger.getLogger(InvoiceManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        insuranceContract = new InsuranceContract("312853415", new BigDecimal(200), "Burak", 1, startDate, endDate);
        client = new Client("312853415", "Karatas", "Burak", "Krimpen", "2922CD", "Blomsingel 31", "NL00 INGB 012345", false, "nskerdel", "0612345678");
    }

    @After
    public void tearDown() {
    }

    /*
    Making sure the get function works by making sure a new insurancecontract can not by found the first time, but it can after adding it.
    Deleting it after and testing the get function again.
    */
    @Test
    public void testGetInsuranceContract() {
        try {
            InsuranceContract beforeAdding = manager.getInsuranceContract(client);

            manager.addInsuranceContract(insuranceContract);

            InsuranceContract afterAdding = manager.getInsuranceContract(client);

            assert (afterAdding.getBSN() != null && beforeAdding.getBSN() == null);

            manager.deleteInsuranceContract(client);

            InsuranceContract afterDelete = manager.getInsuranceContract(client);

            assert (afterDelete.getBSN() == null);
        } catch (RemoteException e) {
            fail();
        }
    }

    /*
    Making sure insuranceContract does not exists and checking if the add function does what we want.
    Deleting the insuranceContract afterwards.
    */
    @Test
    public void testAddInsuranceContract() {
        try {
            InsuranceContract beforeAdding = manager.getInsuranceContract(client);
            manager.addInsuranceContract(insuranceContract);
            try {
                InsuranceContract afterAdding = manager.getInsuranceContract(client);
                assert (afterAdding.getBSN() != null && beforeAdding.getBSN() == null);
            } finally {
                manager.deleteInsuranceContract(client);
            }
        } catch (RemoteException e) {
            fail();
        }
    }

    /*
    Making sure insuranceContract does not exists and adding one after it to be able to test the delete function.
    Testing the delete function by searching for the contract afterwards again.
    */
    @Test
    public void testDeleteInsuranceContract() {
        try {
            InsuranceContract beforeAdding = manager.getInsuranceContract(client);

            manager.addInsuranceContract(insuranceContract);

            InsuranceContract afterAdding = manager.getInsuranceContract(client);

            assert (afterAdding.getBSN() != null && beforeAdding.getBSN() == null);

            manager.deleteInsuranceContract(client);

            InsuranceContract afterDelete = manager.getInsuranceContract(client);

            assert (afterDelete.getBSN() == null);
        } catch (RemoteException e) {
            fail();
        }
    }
}
