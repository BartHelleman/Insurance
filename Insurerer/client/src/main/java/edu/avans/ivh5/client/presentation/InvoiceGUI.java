package edu.avans.ivh5.client.presentation;

import edu.avans.ivh5.client.businesslogic.InvoiceManager;
import edu.avans.ivh5.shared.models.InsuranceContract;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;

/**
 *
 * @author Niels
 */
public class InvoiceGUI extends javax.swing.JFrame {

    public InvoiceGUI() {
        
    
    
       // Set the JFrame to maximize by default on opening
       setExtendedState(JFrame.MAXIMIZED_BOTH);        

       // Rest of the program
    }

    private InvoiceManager manager;

    public InvoiceGUI(InvoiceManager manager) {
        this.manager = manager;
        initComponents();
        displayInvoice();
    }
    
    


    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPolis = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        insuranceNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        startDateField = new javax.swing.JTextField();
        endDateField = new javax.swing.JTextField();
        ownRiskField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        backButton.setText("< - -");

        insuranceNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insuranceNameFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Verzekeringsnaam");

        jLabel2.setText("Ingangsdatum");

        jLabel3.setText("Einddatum");

        jLabel4.setText("Eigen risicio");

        endDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateFieldActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelPolisLayout = new javax.swing.GroupLayout(panelPolis);
        panelPolis.setLayout(panelPolisLayout);
        panelPolisLayout.setHorizontalGroup(
            panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPolisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPolisLayout.createSequentialGroup()
                .addGap(0, 105, Short.MAX_VALUE)
                .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPolisLayout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton))
                    .addGroup(panelPolisLayout.createSequentialGroup()
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(103, 103, 103)
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startDateField)
                            .addComponent(insuranceNameField)
                            .addComponent(endDateField)
                            .addComponent(ownRiskField, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))))
                .addGap(247, 247, 247))
        );
        panelPolisLayout.setVerticalGroup(
            panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPolisLayout.createSequentialGroup()
                .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addGroup(panelPolisLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insuranceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ownRiskField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(27, 27, 27)
                .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton))
                .addContainerGap(283, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPolis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPolis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void displayInvoice() {
        InsuranceContract contract = manager.getInsuranceContract(null);
    //    manager.addInsuranceContract(null);  
        if (contract == null) {
            deleteButton.setVisible(false);
        } else {
            insuranceNameField.setText(contract.getClientName()); // Moet InsuranceName worden
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            startDateField.setText(formatter.format(contract.getStartDate()));       
            endDateField.setText(formatter.format(contract.getEndDate()));
            
            Integer ownRisk = contract.getOwnRisk().intValue();
            ownRiskField.setText(Integer.toString(ownRisk));
        
            saveButton.setVisible(false);
            
            insuranceNameField.setEditable(false);
            startDateField.setEditable(false);
            endDateField.setEditable(false);
            ownRiskField.setEditable(false);
        } 
    }
    
    private void insuranceNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insuranceNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insuranceNameFieldActionPerformed

    private void endDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateFieldActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        InsuranceContract contract = manager.getInsuranceContract(null);
        manager.deleteInsuranceContract(contract);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
       // String 
        InsuranceContract contract = manager.addInsuranceContract(null);
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField endDateField;
    private javax.swing.JTextField insuranceNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField ownRiskField;
    private javax.swing.JPanel panelPolis;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField startDateField;
    // End of variables declaration//GEN-END:variables
}
