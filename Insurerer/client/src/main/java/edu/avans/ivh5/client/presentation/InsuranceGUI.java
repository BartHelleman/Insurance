package edu.avans.ivh5.client.presentation;

import edu.avans.ivh5.client.businesslogic.InsuranceManager;
import edu.avans.ivh5.server.dao.TreatmentCodeDAO;
import edu.avans.ivh5.shared.models.Insurance;
import edu.avans.ivh5.shared.models.TreatmentCode;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InsuranceGUI extends javax.swing.JFrame {

    private List<TreatmentCode> treatmentObjects = new ArrayList<>();
    private List<String> treatmentCodes = new ArrayList<>();
    private List<Insurance> insurances;
    private InsuranceManager insuranceManager = new InsuranceManager();
    private DefaultListModel listModel = new DefaultListModel();

    /**
     * Creates new form InsuranceGUI
     *
     * @param insuranceManager
     */
    public InsuranceGUI() {
//treatmentCodes.add("5");
//treatmentCodes.add("6");
        initComponents();
        this.setVisible(true);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

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
        changeInsurancePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        treatmentList = new javax.swing.JList(listModel);
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
        searchTextField = new javax.swing.JTextField();
        addInsuranceButton = new javax.swing.JButton();
        removeInsuranceButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        insuranceTable = new javax.swing.JTable();

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

        treatmentComboBox.setFocusable(false);
        treatmentComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                treatmentComboBoxPopupMenuWillBecomeVisible(evt);
            }
        });
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

        addInsuranceButton.setBackground(new java.awt.Color(204, 204, 255));
        addInsuranceButton.setText("Verzekering toevoegen");
        addInsuranceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInsuranceButtonActionPerformed(evt);
            }
        });

        removeInsuranceButton.setBackground(new java.awt.Color(204, 204, 255));
        removeInsuranceButton.setText("Verzekering verwijderen");
        removeInsuranceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeInsuranceButtonActionPerformed(evt);
            }
        });

        insuranceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Naam", "Prijs"
            }

        )     {    @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }}
        );
        insuranceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insuranceTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(insuranceTable);

        javax.swing.GroupLayout insurancePanelLayout = new javax.swing.GroupLayout(insurancePanel);
        insurancePanel.setLayout(insurancePanelLayout);
        insurancePanelLayout.setHorizontalGroup(
            insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insurancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insurancePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insurancePanelLayout.createSequentialGroup()
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insurancePanelLayout.createSequentialGroup()
                                .addComponent(removeInsuranceButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addInsuranceButton))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        insurancePanelLayout.setVerticalGroup(
            insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insurancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(insurancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInsuranceButton)
                    .addComponent(removeInsuranceButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insurancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeInsurancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1096, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changeInsurancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insurancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(545, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        DefaultTableModel tableModel = (DefaultTableModel) insuranceTable.getModel();

        if (tableModel.getRowCount()
                > 0) {
            for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                tableModel.removeRow(i);
            }
        }

        try {
            insurances = insuranceManager.searchInsurance(searchTextField.getText());
        } catch (RemoteException e) {
            System.out.println("geen verbinding met de server");
        }

        for (Insurance i : insurances) {
            String id = i.getID();
            String name = i.getName();
            String price = i.getPrice().toString();

            tableModel.addRow(new Object[]{id, name, price});

        }

    }//GEN-LAST:event_searchButtonActionPerformed


    private void treatmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treatmentComboBoxActionPerformed
        String treatment = (String) treatmentComboBox.getSelectedItem();

        if (!listModel.contains(treatment)) {
            listModel.addElement(treatment);

        } else {
            System.out.println("object zit er al in");
        }

    }//GEN-LAST:event_treatmentComboBoxActionPerformed

    private void treatmentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treatmentListMouseClicked
        String selected = (String) treatmentList.getSelectedValue();

        listModel.removeElement(selected);
    }//GEN-LAST:event_treatmentListMouseClicked

    private void addInsuranceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInsuranceButtonActionPerformed

        nameTextField.setText(null);
        IDTextField.setText(null);
        priceTextField.setText(null);

        insuranceTable.clearSelection();

        changeInsurancePanel.setVisible(true);
    }//GEN-LAST:event_addInsuranceButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        List<String> treatmentCodes = new ArrayList<>();

        if (!(nameTextField.getText().isEmpty() || IDTextField.getText().isEmpty() || priceTextField.getText().isEmpty())) {
            String name = nameTextField.getText();
            String ID = IDTextField.getText();
            BigDecimal price = new BigDecimal(priceTextField.getText());

            for (int i = 0; i < listModel.size(); i++) {
                treatmentCodes.add((String) listModel.getElementAt(i));
            }

            Insurance insurance = new Insurance(ID, name, price, treatmentCodes);

            try {
                if (insuranceManager.addInsurance(insurance)) {
                    JOptionPane.showMessageDialog(null, "Verzekering toegevoegd", "Toegevoegd", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(null, "Geen verbinding met de server", "Server error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Er zijn velden leeg", "velden leeg", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void removeInsuranceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeInsuranceButtonActionPerformed

        DefaultTableModel tableModel = (DefaultTableModel) insuranceTable.getModel();
        Object[] options = {"Ja", "Nee"};

        if (insuranceTable.getSelectedRowCount() != 1) {
            System.out.println("Selecteer één verzekering");
        } else {
            int action = JOptionPane.showOptionDialog(null, "Weet u zeker dat u deze verzekering wilt verwijderen?", "Verwijderen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            System.out.println("" + action);
            if (action == 0) {
                try {
                    if (insuranceManager.deleteInsurance((String) insuranceTable.getValueAt(insuranceTable.getSelectedRow(), 0))) {
                        JOptionPane.showMessageDialog(null, "Verzekering verwijderd", "verwijderd", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (RemoteException e) {
                    JOptionPane.showMessageDialog(null, "Geen verbinding met de server", "Server error", JOptionPane.ERROR_MESSAGE);
                }
                tableModel.removeRow(insuranceTable.getSelectedRow());
                changeInsurancePanel.setVisible(false);
            }
        }
    }//GEN-LAST:event_removeInsuranceButtonActionPerformed

    private void insuranceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insuranceTableMouseClicked
        insurances.clear();

        if (insuranceTable.getSelectedRowCount() != 1) {
            changeInsurancePanel.setVisible(false);
            JOptionPane.showMessageDialog(null, "Selecteer één item", "Fout", JOptionPane.INFORMATION_MESSAGE);
        } else {
            changeInsurancePanel.setVisible(true);

            //haal bijbehorende verzekering op
            try {
                insurances = insuranceManager.searchInsurance((String) insuranceTable.getValueAt(insuranceTable.getSelectedRow(), 0));
            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(null, "Geen verbinding met de server", "Server error", JOptionPane.ERROR_MESSAGE);
            }

            List<String> reimbursedTreatments = new ArrayList<>();
            for (Insurance i : insurances) {
                if (insuranceTable.getValueAt(insuranceTable.getSelectedRow(), 0).equals(i.getID())) {
                    listModel.clear();
                    nameTextField.setText(i.getName());
                    IDTextField.setText(i.getID());
                    priceTextField.setText(i.getPrice().toString());

                    reimbursedTreatments = i.getTreatments();

                    for (String s : reimbursedTreatments) {
                        listModel.addElement(s);
                    }

                }
            }

        }
    }//GEN-LAST:event_insuranceTableMouseClicked

    private void treatmentComboBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_treatmentComboBoxPopupMenuWillBecomeVisible
        treatmentObjects.clear();
        treatmentCodes.clear();
        
        try {
            treatmentObjects = insuranceManager.getTreatmentCodes("");
        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(null, "Geen verbinding met de server", "Server error", JOptionPane.ERROR_MESSAGE);
        }
        for (TreatmentCode t : treatmentObjects) {
            treatmentCodes.add(t.getCode());
        }
        treatmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(treatmentCodes.toArray()));
    }//GEN-LAST:event_treatmentComboBoxPopupMenuWillBecomeVisible

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JButton addInsuranceButton;
    private javax.swing.JPanel changeInsurancePanel;
    private javax.swing.JPanel insurancePanel;
    private javax.swing.JTable insuranceTable;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JButton removeInsuranceButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox treatmentComboBox;
    private javax.swing.JList treatmentList;
    private javax.swing.JLabel treatmentsLabel;
    // End of variables declaration//GEN-END:variables
}
