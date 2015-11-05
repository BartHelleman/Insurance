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
import edu.avans.ivh5.shared.models.InsuranceCompany;
import edu.avans.ivh5.shared.models.Treatment;
import edu.avans.ivh5.shared.util.generateInvoicePDF;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        InsuranceManager insuranceManager = new InsuranceManager();
        InsuranceGUI insuranceGUI = new InsuranceGUI();
        insuranceGUI.setVisible(true);

        //InvoiceManager invoiceManager = new InvoiceManager();
        //InvoiceGUI invoiceGUI = new InvoiceGUI(client);
        //invoiceGUI.setVisible(true);

        build();

        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
        UserGUI userGUI = new UserGUI();
        userGUI.setVisible(true);
        InsuranceCompanyGUI insuranceCompanyGUI = new InsuranceCompanyGUI();
        insuranceCompanyGUI.setVisible(true);
        }

//        try {
//            generateInvoicePDF generatePDF = new generateInvoicePDF(
//                    new Treatment("AAA1", "Knie", new BigDecimal(30.0), 10),
//                    new Client("209000454", "Oguzhan", "Babaarslan", "Amsterdam", "3450AS", "hogeschoollaan ", "NL23RABO1234567", true, "Oguzhan.ajax@ajax.nl", "06-33733214"),
//                    new InsuranceCompany("TYUIO", "Amsterdam", "3409GF", "Ajaxstraat 0202", "09876543")
//            );
            //insuranceGUI.setVisible(true);
            
            //   Client client = new Client("12345678", "Burak", "Niels", "Krimpen", "2922CD", "Blomsingel 31", "NL00 INGB 012345", false, "nskerdel", "0612345678");
            //   InvoiceManager invoiceManager = new InvoiceManager();
            //   InvoiceGUI invoiceGUI = new InvoiceGUI(client);
            //   invoiceGUI.setVisible(true);
            
            //    build();

            
//         Client client = new Client("004", "Burak", "Niels", "Krimpen", "2922CD", "Blomsingel 31", "NL00 INGB 012345", false, "nskerdel", "0612345678");
//         InvoiceManager invoiceManager = new InvoiceManager();
//         InvoiceGUI invoiceGUI = new InvoiceGUI(client);
//         invoiceGUI.setVisible(true);
            //InvoiceManager invoiceManager = new InvoiceManager();
            //InvoiceGUI invoiceGUI = new InvoiceGUI(invoiceManager);
            //invoiceGUI.setVisible(true);
            //build();
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
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

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
