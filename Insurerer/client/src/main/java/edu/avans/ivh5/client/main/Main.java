package edu.avans.ivh5.client.main;

import edu.avans.ivh5.client.businesslogic.InvoiceManager;
import edu.avans.ivh5.client.presentation.InvoiceGUI;

public class Main {
    public static void main(String[] args) {
        
        InvoiceManager manager = new InvoiceManager();
        InvoiceGUI gui = new InvoiceGUI(manager);
        gui.setVisible(true);
    }
}
