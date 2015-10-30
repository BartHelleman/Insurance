package edu.avans.ivh5.client.presentation;

import edu.avans.ivh5.client.businesslogic.InvoiceManager;
import edu.avans.ivh5.shared.models.InsuranceContract;
import static java.awt.Color.red;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        displayErrorArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        backButton.setText("< - -");

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

        displayErrorArea.setColumns(20);
        displayErrorArea.setRows(5);
        jScrollPane1.setViewportView(displayErrorArea);

        javax.swing.GroupLayout panelPolisLayout = new javax.swing.GroupLayout(panelPolis);
        panelPolis.setLayout(panelPolisLayout);
        panelPolisLayout.setHorizontalGroup(
            panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPolisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPolisLayout.createSequentialGroup()
                .addGap(0, 1136, Short.MAX_VALUE)
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
                            .addComponent(insuranceIDField)
                            .addComponent(ownRiskField, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(startDateField)
                            .addComponent(endDateField))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelPolisLayout.setVerticalGroup(
            panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPolisLayout.createSequentialGroup()
                .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addGroup(panelPolisLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPolisLayout.createSequentialGroup()
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
                                    .addComponent(jLabel4)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(panelPolisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton))
                .addContainerGap(795, Short.MAX_VALUE))
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

    public final String displayInvoice() {
        InsuranceContract contract = manager.getInsuranceContract(null);
        String clientName = contract.getClientName();
        displayErrorArea.setVisible(false);

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

        String startDateHolder = null;
        Date startDate = null;

        String endDateHolder = null;
        Date endDate = null;

        int insuranceID = 0;
        String name = displayInvoice();

        if (!ownRiskField.getText().isEmpty() && ownRiskField.getText().matches("[0-9]+")) {
            if(Integer.parseInt(ownRiskField.getText()) > 0) {
            ownRisk = new BigDecimal(ownRiskField.getText());
            }
        } else {
            ownRiskField.setBackground(red);
            
        }

        if (!insuranceIDField.getText().isEmpty()) {
            insuranceID = Integer.parseInt(insuranceIDField.getText());
        } else {
            insuranceIDField.setBackground(red);
        }

        if (!startDateField.getText().isEmpty()) {
            startDateHolder = startDateField.getText();

            try {
                startDate = format.parse(startDateHolder);
            } catch (ParseException ex) {
                System.out.println("Error: " + ex);
            }
        } else {
            startDateField.setBackground(red);
        }

        if (!endDateField.getText().isEmpty()) {
            endDateHolder = endDateField.getText();

            try {
                endDate = format.parse(endDateHolder);
            } catch (ParseException ex) {
                System.out.println("Error: " + ex);
            }
        } else {
            endDateField.setBackground(red);
        }

        if (startDate != null && endDate != null) {
            if (ownRisk != null) {
                insuranceContracts.add(new InsuranceContract(ownRisk, name, insuranceID, startDate, endDate));
                insuranceContracts.stream().forEach(p -> manager.addInsuranceContract(p));
            } else {

            }
        } else {
            displayErrorArea.setVisible(true);
            displayErrorArea.setEditable(false);
            displayErrorArea.setText("Geef een geldig datum op. Bijvoorbeeld 2000-01-01");
        }
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextArea displayErrorArea;
    private javax.swing.JTextField endDateField;
    private javax.swing.JTextField insuranceIDField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JTextField ownRiskField;
    private javax.swing.JPanel panelPolis;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField startDateField;
    // End of variables declaration//GEN-END:variables
}