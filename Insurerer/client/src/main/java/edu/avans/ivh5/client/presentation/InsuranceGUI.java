package edu.avans.ivh5.client.presentation;

import edu.avans.ivh5.client.businesslogic.InsuranceManager;
import edu.avans.ivh5.shared.models.Insurance;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class InsuranceGUI extends javax.swing.JFrame {

    private final List<Integer> treatments = new ArrayList<>();
    private final List<String> insuranceList = new ArrayList<>();
    String searchPattern = "";
    List<Insurance> insurance;
    private final InsuranceManager manager;

    /**
     * Creates new form InsuranceGUI
     *
     * @param insuranceManager
     */
    public InsuranceGUI(InsuranceManager insuranceManager) {
        this.manager = insuranceManager;
        this.insurance = (List<Insurance>) manager.getInsurances(searchPattern);
        treatments.add(123321);
        treatments.add(345678);

        initComponents();

        /*IDTextField.setText(Integer.toString(insurance.getID()));
         nameTextField.setText(insurance.getName());
         priceTextField.setText(insurance.getPrice().toString());
         */
    }
    
    public InsuranceGUI()
    {
        this(new InsuranceManager());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        insuranceTabbedPane = new javax.swing.JTabbedPane();
        changeInsurancePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        treatmentList = new javax.swing.JList();
        saveButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        treatmentsLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        IDTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        treatmentComboBox = new javax.swing.JComboBox();
        insurancePanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        seachTextField = new javax.swing.JTextField();
        addInsuranceButton = new javax.swing.JButton();
        removeInsuranceButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        changeInsurancePanel.setVisible(false);

        treatmentList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return treatments.size(); }
            public Object getElementAt(int i) { return treatments.get(i); }
        });
        treatmentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treatmentListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(treatmentList);

        saveButton.setBackground(new java.awt.Color(204, 204, 255));
        saveButton.setText("Opslaan");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Naam");

        IDLabel.setText("ID");

        priceLabel.setText("Prijs");

        treatmentsLabel.setText("Vergoede behandelingen");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        treatmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(treatments.toArray()));
        treatmentComboBox.setFocusable(false);
        treatmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treatmentComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout changeInsurancePanelLayout = new javax.swing.GroupLayout(changeInsurancePanel);
        changeInsurancePanel.setLayout(changeInsurancePanelLayout);
        changeInsurancePanelLayout.setHorizontalGroup(
            changeInsurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeInsurancePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(changeInsurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(treatmentsLabel)
                    .addGroup(changeInsurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, changeInsurancePanelLayout.createSequentialGroup()
                            .addGroup(changeInsurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(IDLabel)
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceLabel))
                            .addGap(68, 68, 68)
                            .addGroup(changeInsurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(treatmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(saveButton)))
                .addGap(33, 33, 33))
        );
        changeInsurancePanelLayout.setVerticalGroup(
            changeInsurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeInsurancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(changeInsurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(changeInsurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDLabel)
                    .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(changeInsurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(changeInsurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(treatmentsLabel)
                    .addComponent(treatmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchButton.setBackground(new java.awt.Color(204, 204, 255));
        searchButton.setText("Zoek");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        seachTextField.setText("Zoekterm");
        seachTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seachTextFieldActionPerformed(evt);
            }
        });

        addInsuranceButton.setBackground(new java.awt.Color(204, 204, 255));
        addInsuranceButton.setText("Verzekering toevoegen");
        addInsuranceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInsuranceButtonActionPerformed(evt);
            }
        });

        removeInsuranceButton.setBackground(new java.awt.Color(204, 204, 255));
        removeInsuranceButton.setText("Verzekering verwijderen");

        for(int i = 0; i < insurance.size(); i++) {
            String name = insurance.get(i).getName();
            insuranceList.add(name);
        }
        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return insuranceList.size(); }
            public Object getElementAt(int i) { return insuranceList.get(i); }
        });
        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout insurancePanelLayout = new javax.swing.GroupLayout(insurancePanel);
        insurancePanel.setLayout(insurancePanelLayout);
        insurancePanelLayout.setHorizontalGroup(
            insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insurancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(insurancePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insurancePanelLayout.createSequentialGroup()
                                .addComponent(seachTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insurancePanelLayout.createSequentialGroup()
                                .addComponent(removeInsuranceButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addInsuranceButton)))))
                .addContainerGap())
        );
        insurancePanelLayout.setVerticalGroup(
            insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insurancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(seachTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInsuranceButton)
                    .addComponent(removeInsuranceButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(insuranceTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insurancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changeInsurancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1096, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insuranceTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changeInsurancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insurancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seachTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seachTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seachTextFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

    }//GEN-LAST:event_searchButtonActionPerformed

    private void treatmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treatmentComboBoxActionPerformed
        Integer treatment = (Integer) treatmentComboBox.getSelectedItem();
        if (!treatments.contains(treatment)) {
            treatments.add(treatment);
            treatmentList.updateUI();
        } else {
        }
    }//GEN-LAST:event_treatmentComboBoxActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void treatmentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treatmentListMouseClicked
        Integer selected = (Integer) treatmentList.getSelectedValue();
        treatments.remove(selected);
        treatmentList.clearSelection();
        treatmentList.updateUI();
    }//GEN-LAST:event_treatmentListMouseClicked

    private void addInsuranceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInsuranceButtonActionPerformed
        changeInsurancePanel.setVisible(true);
    }//GEN-LAST:event_addInsuranceButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

    }//GEN-LAST:event_saveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JButton addInsuranceButton;
    private javax.swing.JPanel changeInsurancePanel;
    private javax.swing.JPanel insurancePanel;
    private javax.swing.JTabbedPane insuranceTabbedPane;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JButton removeInsuranceButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField seachTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox treatmentComboBox;
    private javax.swing.JList treatmentList;
    private javax.swing.JLabel treatmentsLabel;
    // End of variables declaration//GEN-END:variables
}
