package edu.avans.ivh5.client.presentation;

import javax.swing.*;

public class MainGUI2 extends JFrame {

    private JTabbedPane tabsWindow;
    private JPanel clientGUI;
    private JPanel insuranceGUI;
    private JPanel insuranceCompanyGUI;
    private JPanel userGUI;
    private boolean isAdmin;

    public MainGUI2(boolean isAdmin) {
        this.isAdmin = isAdmin;
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(isAdmin ? "Admin menu" : "Menu" );
        tabsWindow = new JTabbedPane();

        if (!isAdmin) {
            clientGUI = (JPanel) new ClientGUI().getContentPane();
            tabsWindow.addTab("Cliëntbeheer", clientGUI);

            insuranceGUI = (JPanel) new InsuranceGUI().getContentPane();
            tabsWindow.addTab("Verzekeringbeheer", insuranceGUI);
        } else {
            insuranceCompanyGUI = (JPanel) new InsuranceCompanyGUI().getContentPane();
            tabsWindow.addTab("Maatschappijbeheer", insuranceCompanyGUI);

            userGUI = (JPanel) new UserGUI().getContentPane();
            tabsWindow.addTab("Accounts beheer", userGUI);
        }
        this.add(tabsWindow);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        //JFrame frame = new MainGUI2();
    }
}
