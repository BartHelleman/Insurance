package edu.avans.ivh5.client.main;

import edu.avans.ivh5.client.businesslogic.InsuranceManager;
import edu.avans.ivh5.client.businesslogic.InvoiceManager;
import edu.avans.ivh5.client.presentation.ClientGUI;
import edu.avans.ivh5.client.presentation.InsuranceGUI;
import edu.avans.ivh5.client.presentation.InvoiceGUI;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
       /* InsuranceManager insuranceManager = new InsuranceManager();
        InsuranceGUI insuranceGUI = new InsuranceGUI(insuranceManager);
        insuranceGUI.setVisible(true);
        */
        InvoiceManager invoiceManager = new InvoiceManager();
        InvoiceGUI invoiceGUI = new InvoiceGUI(invoiceManager);
        invoiceGUI.setVisible(true);
       
       // build();

    }
/*
    private static void build() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e);
        }
        ClientGUI GUI = new ClientGUI();
        GUI.setVisible(true);
    } */
}
