package edu.avans.ivh5.client.main;

import edu.avans.ivh5.client.presentation.ClientGUI;
import javax.swing.UIManager;

import edu.avans.ivh5.client.businesslogic.InsuranceManager;
import edu.avans.ivh5.client.presentation.InsuranceGUI;

public class Main {
    public static void main(String[] args) {
        InsuranceManager insuranceManager = new InsuranceManager();
        InsuranceGUI insuranceGUI = new InsuranceGUI(insuranceManager);
        insuranceGUI.setVisible(true);
    }
}
