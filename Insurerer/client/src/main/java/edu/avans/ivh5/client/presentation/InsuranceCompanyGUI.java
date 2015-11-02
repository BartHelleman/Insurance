package edu.avans.ivh5.client.presentation;

import edu.avans.ivh5.client.businesslogic.InsuranceCompanyManager;
import edu.avans.ivh5.shared.models.InsuranceCompany;
import javax.swing.JOptionPane;

public class InsuranceCompanyGUI extends javax.swing.JFrame {

    InsuranceCompanyManager insuranceCompanyManager = new InsuranceCompanyManager();

    private JOptionPane saveOptionPane;

    String name = "";
    String city = "";
    String postcode = "";
    String address = "";
    String KVK = "";

    /**
     * Creates new form InsuranceCompanyGUI
     */
    public InsuranceCompanyGUI() {
        initComponents();
        InsuranceCompany insuranceCompany = insuranceCompanyManager.getInsuranceCompany();

        companyNameTextField.setText(insuranceCompany.getName());
        cityTextField.setText(insuranceCompany.getCity());
        postcodeTextField.setText(insuranceCompany.getPostCode());
        addressTextField.setText(insuranceCompany.getAddress());
        KVKTextField.setText(insuranceCompany.getKVK());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        companyNameLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        postcodeLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        KVKLabel = new javax.swing.JLabel();
        KVKTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        postcodeTextField = new javax.swing.JTextField();
        cityTextField = new javax.swing.JTextField();
        companyNameTextField = new javax.swing.JTextField();
        saveCompanyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        companyNameLabel.setText("Naam");

        cityLabel.setText("Plaats");

        postcodeLabel.setText("Postcode");

        addressLabel.setText("Adres");

        KVKLabel.setText("KVK");

        KVKTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KVKTextFieldMouseClicked(evt);
            }
        });

        addressTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressTextFieldMouseClicked(evt);
            }
        });

        postcodeTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postcodeTextFieldMouseClicked(evt);
            }
        });

        cityTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cityTextFieldMouseClicked(evt);
            }
        });

        companyNameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                companyNameTextFieldMouseClicked(evt);
            }
        });

        saveCompanyButton.setBackground(new java.awt.Color(204, 204, 255));
        saveCompanyButton.setText("Opslaan");
        saveCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCompanyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveCompanyButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(companyNameLabel)
                            .addComponent(cityLabel)
                            .addComponent(postcodeLabel)
                            .addComponent(addressLabel)
                            .addComponent(KVKLabel))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addressTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(KVKTextField)
                            .addComponent(companyNameTextField)
                            .addComponent(cityTextField)
                            .addComponent(postcodeTextField))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyNameLabel)
                    .addComponent(companyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postcodeLabel)
                    .addComponent(postcodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KVKLabel)
                    .addComponent(KVKTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveCompanyButton)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCompanyButtonActionPerformed
        if (!companyNameTextField.getText().matches("[0-9]+")) {
            name = companyNameTextField.getText();
        } else {
            JOptionPane.showMessageDialog(null, "De ingevulde naam is ongeldig", "Ongeldige naam", JOptionPane.ERROR_MESSAGE);
        }
        if (!cityTextField.getText().matches("[0-9]+")) {
            city = cityTextField.getText();
        } else {
            JOptionPane.showMessageDialog(null, "De ingevulde plaats is ongeldig", "Ongeldige plaats", JOptionPane.ERROR_MESSAGE);
        }
        if (postcodeTextField.getText().matches("^[1-9][0-9]{3}[\\s]?[A-Za-z]{2}$")) {
            postcode = postcodeTextField.getText();
        } else {
            JOptionPane.showMessageDialog(null, "De ingevulde postcode is ongeldig", "Ongeldig postcode", JOptionPane.ERROR_MESSAGE);
        }
        if (addressTextField.getText().matches("^([1-9][e][\\s])*([a-zA-Z]+(([\\.][\\s])|([\\s]))?)+[1-9][0-9]*(([-][1-9][0-9]*)|([\\s]?[a-zA-Z]+))?$")) {
            address = addressTextField.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Het ingevulde adres is ongeldig", "Ongeldig adres", JOptionPane.ERROR_MESSAGE);
        }
        if (KVKTextField.getText().matches("[0-9]+")) {
            KVK = KVKTextField.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Het ingevulde KVK is ongeldig", "Ongeldig KVK", JOptionPane.ERROR_MESSAGE);
        }
        
        InsuranceCompany insuranceCompany = new InsuranceCompany(name, city, postcode, address, KVK);
        insuranceCompanyManager.change(insuranceCompanyManager.getInsuranceCompany(), insuranceCompany);
        JOptionPane.showMessageDialog(null, "Wijziging opgeslagen", "", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_saveCompanyButtonActionPerformed

    private void companyNameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyNameTextFieldMouseClicked
        companyNameTextField.selectAll();
    }//GEN-LAST:event_companyNameTextFieldMouseClicked

    private void cityTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cityTextFieldMouseClicked
        cityTextField.selectAll();
    }//GEN-LAST:event_cityTextFieldMouseClicked

    private void postcodeTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postcodeTextFieldMouseClicked
        postcodeTextField.selectAll();
    }//GEN-LAST:event_postcodeTextFieldMouseClicked

    private void addressTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressTextFieldMouseClicked
        addressTextField.selectAll();
    }//GEN-LAST:event_addressTextFieldMouseClicked

    private void KVKTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KVKTextFieldMouseClicked
        KVKTextField.selectAll();
    }//GEN-LAST:event_KVKTextFieldMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InsuranceCompanyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsuranceCompanyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsuranceCompanyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsuranceCompanyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InsuranceCompanyGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel KVKLabel;
    private javax.swing.JTextField KVKTextField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel companyNameLabel;
    private javax.swing.JTextField companyNameTextField;
    private javax.swing.JLabel postcodeLabel;
    private javax.swing.JTextField postcodeTextField;
    private javax.swing.JButton saveCompanyButton;
    // End of variables declaration//GEN-END:variables
}
