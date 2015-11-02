package edu.avans.ivh5.client.main;

import edu.avans.ivh5.client.businesslogic.InsuranceManager;
import edu.avans.ivh5.client.businesslogic.InvoiceManager;
import edu.avans.ivh5.client.presentation.ClientGUI;
import edu.avans.ivh5.client.presentation.InsuranceCompanyGUI;
import edu.avans.ivh5.client.presentation.InsuranceGUI;
import edu.avans.ivh5.client.presentation.InvoiceGUI;
import edu.avans.ivh5.client.presentation.LoginGUI;
import edu.avans.ivh5.client.presentation.LoginGUI;
import edu.avans.ivh5.client.presentation.MainGUI;
import edu.avans.ivh5.client.presentation.UserGUI;
import edu.avans.ivh5.shared.models.Client;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        //InsuranceManager insuranceManager = new InsuranceManager();
        //InsuranceGUI insuranceGUI = new InsuranceGUI(insuranceManager);
        //insuranceGUI.setVisible(true);
        

        // Client client = new Client("0123456789", "Burak", "Niels", "Krimpen", "2922CD", "Blomsingel 31", "NL00 INGB 012345", false, "nskerdel", "0612345678");
        // InvoiceManager invoiceManager = new InvoiceManager();
        // InvoiceGUI invoiceGUI = new InvoiceGUI(client);
        // invoiceGUI.setVisible(true);

        //InvoiceManager invoiceManager = new InvoiceManager();
        //InvoiceGUI invoiceGUI = new InvoiceGUI(invoiceManager);
        //invoiceGUI.setVisible(true);
       
        // build();

        //InvoiceManager invoiceManager = new InvoiceManager();
        //InvoiceGUI invoiceGUI = new InvoiceGUI(invoiceManager);
        //invoiceGUI.setVisible(true);
        
        //LoginGUI loginGUI = new LoginGUI();
        //loginGUI.setVisible(true);

        //UserGUI userGUI = new UserGUI();
        //userGUI.setVisible(true);
        //InsuranceCompanyGUI insuranceCompanyGUI = new InsuranceCompanyGUI();
        //insuranceCompanyGUI.setVisible(true);
        //InvoiceManager invoiceManager = new InvoiceManager();
        //InvoiceGUI invoiceGUI = new InvoiceGUI(invoiceManager);
        //invoiceGUI.setVisible(true);
        //build();
    }

    private static void build() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e);
        }
        ClientGUI GUI = new ClientGUI();
        GUI.setVisible(true);
    } 

}
