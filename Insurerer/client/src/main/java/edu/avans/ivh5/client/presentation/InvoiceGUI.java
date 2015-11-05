package edu.avans.ivh5.client.presentation;

import edu.avans.ivh5.client.businesslogic.InsuranceManager;
import edu.avans.ivh5.client.businesslogic.InvoiceManager;
import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.Insurance;
import edu.avans.ivh5.shared.models.InsuranceContract;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Niels
 */
public class InvoiceGUI extends javax.swing.JFrame {
    
    private final InvoiceManager invoiceManager;
    private final InsuranceManager insuranceManager;
    private final Client client;
    private ClientGUI clientGUI;

    public InvoiceGUI(Client client, ClientGUI clientGUI) {
        this.client = client;
        this.invoiceManager = new InvoiceManager();
        this.insuranceManager = new InsuranceManager();
        this.clientGUI = clientGUI;
        
        // Set the JFrame to maximize by default on opening
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        displayInvoice();
        invoiceManager.getInvoice(null, client);
        // Rest of the program
    }

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPolis = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ownRiskField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        startDateField = new javax.swing.JTextField();
        endDateField = new javax.swing.JTextField();
        insuranceIDComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setText("< - -");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Verzekering ID");

        jLabel2.setText("Ingangsdatum");

        jLabel3.setText("Einddatum");

        jLabel4.setText("Eigen risicio");

        saveButton.setText("Opslaan");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Verwijderen");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        insuranceIDComboBox.setModel(new javax.swing.DefaultComboBoxModel());

        javax.swing.GroupLayout panelPolisLayout = new javax.swing.GroupLayout(panelPolis);
        panelPolis.setLayout(panelPolisLayout);
        panelPolisLayout.setHorizontalGroup(
            panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPolisLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPolisLayout.createSequentialGroup()
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPolisLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(insuranceIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ownRiskField)
                        .addComponent(endDateField)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPolisLayout.createSequentialGroup()
                            .addComponent(deleteButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(247, 247, 247))
            .addGroup(panelPolisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPolisLayout.setVerticalGroup(
            panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPolisLayout.createSequentialGroup()
                .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addGroup(panelPolisLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insuranceIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ownRiskField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(27, 27, 27)
                .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPolis, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1284, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPolis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 704, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void displayInvoice() {
        List<Insurance> insurance = new ArrayList<>();
        InsuranceContract contract = invoiceManager.getInsuranceContract(client);
        try{
        insurance = insuranceManager.getInsurances("zorgverzekering");
        } catch(RemoteException e){
            JOptionPane.showMessageDialog(null, "Geen verbinding met de server", "Server error", JOptionPane.ERROR_MESSAGE);
        }
        


        // If client exists display data
        // else display nothing
        if (contract.getBSN() == null) {
            // Add items to the combobox
            insurance.stream().forEach((insurance1) -> {
                insuranceIDComboBox.addItem(insurance1.getName());
            });
            
            // Don't display delete button
            deleteButton.setVisible(false);
        } else {
            // Add content to the fields
            insuranceIDComboBox.addItem(insurance.get(contract.getInsuranceID() - 1).getName());

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            startDateField.setText(formatter.format(contract.getStartDate()));
            endDateField.setText(formatter.format(contract.getEndDate()));

            Integer ownRisk = contract.getOwnRisk().intValue();
            ownRiskField.setText(Integer.toString(ownRisk));
            
            // Can't edit fields
            insuranceIDComboBox.setEnabled(false);
            startDateField.setEditable(false);
            endDateField.setEditable(false);
            ownRiskField.setEditable(false);
            
            // Don't display save button
            saveButton.setVisible(false); 
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // Call delete function
        invoiceManager.deleteInsuranceContract(client);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        ArrayList<InsuranceContract> insuranceContracts = new ArrayList<>();
        List<Insurance> insurance = new ArrayList<>();

        // Define all Strings, int etc.
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);

        BigDecimal ownRisk = null;

        String startDateHolder;
        Date startDate = null;

        String endDateHolder;
        Date endDate = null;

        
        // get values which should be saved
        try{
        insurance = insuranceManager.getInsurances((String) insuranceIDComboBox.getSelectedItem());
        } catch (RemoteException e){
            JOptionPane.showMessageDialog(null, "Geen verbinding met de server", "Server error", JOptionPane.ERROR_MESSAGE);
        }
        int insuranceID = Integer.parseInt(insurance.get(0).getID());

        String name = client.getName();
        
        clientGUI.setCheckBox(true);

        
        // Checks if values are correct
        if (!ownRiskField.getText().isEmpty() && ownRiskField.getText().matches("[0-9]+")) {
            if (Integer.parseInt(ownRiskField.getText()) > 0) {
                ownRisk = new BigDecimal(ownRiskField.getText());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Eigen risico is incorrect", "", JOptionPane.ERROR_MESSAGE);
        }

        if (!startDateField.getText().isEmpty()) {
            startDateHolder = startDateField.getText();

            try {
                startDate = format.parse(startDateHolder);
            } catch (ParseException ex) {
                System.out.println("Error: " + ex);
                JOptionPane.showMessageDialog(null, "Startdatum is incorrect", "", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Startdatum is incorrect", "", JOptionPane.ERROR_MESSAGE);
        }

        if (!endDateField.getText().isEmpty()) {
            endDateHolder = endDateField.getText();

            try {
                endDate = format.parse(endDateHolder);
            } catch (ParseException ex) {
                System.out.println("Error: " + ex);
                JOptionPane.showMessageDialog(null, "Einddatum is incorrect", "", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Einddatum is incorrect", "", JOptionPane.ERROR_MESSAGE);
        }

        // If everything is correct, add member
        if (startDate != null && endDate != null && startDate.before(endDate) && ownRisk != null) {
            insuranceContracts.add(new InsuranceContract(client.getBSN(), ownRisk, name, insuranceID, startDate, endDate));
            insuranceContracts.stream().forEach(p -> invoiceManager.addInsuranceContract(p));
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // Close frame
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField endDateField;
    private javax.swing.JComboBox insuranceIDComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField ownRiskField;
    javax.swing.JPanel panelPolis;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField startDateField;
    // End of variables declaration//GEN-END:variables
}
