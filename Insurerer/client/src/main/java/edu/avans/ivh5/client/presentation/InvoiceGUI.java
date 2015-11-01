package edu.avans.ivh5.client.presentation;

import edu.avans.ivh5.client.businesslogic.InvoiceManager;
import edu.avans.ivh5.shared.models.InsuranceContract;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        panelPolis = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        insuranceIDField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ownRiskField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        startDateField = new javax.swing.JTextField();
        endDateField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setText("< - -");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        insuranceIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insuranceIDFieldActionPerformed(evt);
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

        javax.swing.GroupLayout panelPolisLayout = new javax.swing.GroupLayout(panelPolis);
        panelPolis.setLayout(panelPolisLayout);
        panelPolisLayout.setHorizontalGroup(
            panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPolisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(insuranceIDField)
                    .addComponent(ownRiskField)
                    .addComponent(startDateField)
                    .addComponent(endDateField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPolisLayout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(insuranceIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 701, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final String displayInvoice() {
        InsuranceContract contract = manager.getInsuranceContract(null);
        String clientName = contract.getClientName();

        if (contract.getOwnRisk() == null) {
            deleteButton.setVisible(false);
        } else {
            insuranceIDField.setText(contract.getClientName());

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            startDateField.setText(formatter.format(contract.getStartDate()));
            endDateField.setText(formatter.format(contract.getEndDate()));

            Integer ownRisk = contract.getOwnRisk().intValue();
            ownRiskField.setText(Integer.toString(ownRisk));

            saveButton.setVisible(false);

            insuranceIDField.setEditable(false);
            startDateField.setEditable(false);
            endDateField.setEditable(false);
            ownRiskField.setEditable(false);
        }
        return clientName;
    }

    private void insuranceIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insuranceIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insuranceIDFieldActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        String clientName = displayInvoice();
        manager.deleteInsuranceContract(clientName);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        ArrayList<InsuranceContract> insuranceContracts = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);

        BigDecimal ownRisk = null;

        String startDateHolder;
        Date startDate = null;

        String endDateHolder;
        Date endDate = null;

        int insuranceID = 0;
        String name = displayInvoice();

        if (!ownRiskField.getText().isEmpty() && ownRiskField.getText().matches("[0-9]+")) {
            if(Integer.parseInt(ownRiskField.getText()) > 0) {
            ownRisk = new BigDecimal(ownRiskField.getText());
            }
        } else {
            ownRiskField.setText("Geef een geldig eigen risico op. Bijvoorbeeld 200");
        }

        if (!insuranceIDField.getText().isEmpty()) {
            insuranceID = Integer.parseInt(insuranceIDField.getText());
        } else {
        }

        if (!startDateField.getText().isEmpty()) {
            startDateHolder = startDateField.getText();

            try {
                startDate = format.parse(startDateHolder);
            } catch (ParseException ex) {
                System.out.println("Error: " + ex);
            }
        } else {
            startDateField.setText("Geef een geldig datum op. Bijvoorbeeld 2000-01-01");
        }

        if (!endDateField.getText().isEmpty()) {
            endDateHolder = endDateField.getText();

            try {
                endDate = format.parse(endDateHolder);
            } catch (ParseException ex) {
                System.out.println("Error: " + ex);
            }
        } else {
            endDateField.setText("Geef een geldig datum op. Bijvoorbeeld 2000-01-01");
        }

        if (startDate != null && endDate != null && startDate.before(endDate)) {
            if (ownRisk != null) {
                insuranceContracts.add(new InsuranceContract(ownRisk, name, insuranceID, startDate, endDate));
                insuranceContracts.stream().forEach(p -> manager.addInsuranceContract(p));
            } else {

            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField endDateField;
    private javax.swing.JTextField insuranceIDField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JTextField ownRiskField;
    private javax.swing.JPanel panelPolis;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField startDateField;
    // End of variables declaration//GEN-END:variables
}