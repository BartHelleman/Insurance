/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.presentation;

import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.client.businesslogic.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Bart Donders
 */
public class ClientInfoPanel extends javax.swing.JPanel {
private ClientManager clientManager;
    /**
     * Creates new form NewJPanel
     */
    public ClientInfoPanel(ClientManager clientManager) {
        this.clientManager = clientManager;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientPanel = new javax.swing.JPanel();
        clientFirstNameLabel = new javax.swing.JLabel();
        clientLastNameLabel = new javax.swing.JLabel();
        clientBSNLabel = new javax.swing.JLabel();
        clientAddressLabel = new javax.swing.JLabel();
        clientPostCodeLabel = new javax.swing.JLabel();
        clientCityLabel = new javax.swing.JLabel();
        clientTelLabel = new javax.swing.JLabel();
        clientEmailLabel = new javax.swing.JLabel();
        clientPolisLabel = new javax.swing.JLabel();
        clientFirstNameTextField = new javax.swing.JTextField();
        clientLastNameTextField = new javax.swing.JTextField();
        clientBSNTextField = new javax.swing.JTextField();
        clientAddressTextField = new javax.swing.JTextField();
        clientPostCodeTextField = new javax.swing.JTextField();
        clientCityTextField = new javax.swing.JTextField();
        clientTelTextField = new javax.swing.JTextField();
        clientEmailTextField = new javax.swing.JTextField();
        clientIncassoCombobox = new javax.swing.JComboBox();
        addInsuranceContractButton = new javax.swing.JButton();
        saveClientButton = new javax.swing.JButton();
        clientIncassoLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        treatmentsTable = new javax.swing.JTable();
        getInvoiceButton = new javax.swing.JButton();
        clientIBANTextField = new javax.swing.JTextField();
        clientEmailLabel1 = new javax.swing.JLabel();
        polisCheckBox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        declineButton = new javax.swing.JButton();

        clientPanel.setVisible(false);
        clientPanel.setBackground(new java.awt.Color(255, 255, 255));

        clientFirstNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientFirstNameLabel.setText("Voornaam:");

        clientLastNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientLastNameLabel.setText("Achternaam:");

        clientBSNLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientBSNLabel.setText("BSN:");

        clientAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientAddressLabel.setText("Straat + huisnr:");

        clientPostCodeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientPostCodeLabel.setText("Postcode:");

        clientCityLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientCityLabel.setText("Plaats:");

        clientTelLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientTelLabel.setText("Telefoonnummer:");

        clientEmailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientEmailLabel.setText("IBAN:");

        clientPolisLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientPolisLabel.setText("Polis:");

        clientFirstNameTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientFirstNameTextField.setToolTipText("Voornaam");
        clientFirstNameTextField.setName(""); // NOI18N
        clientFirstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientFirstNameTextFieldActionPerformed(evt);
            }
        });

        clientLastNameTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientLastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientLastNameTextFieldActionPerformed(evt);
            }
        });

        clientBSNTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientBSNTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientBSNTextFieldActionPerformed(evt);
            }
        });

        clientAddressTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientAddressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientAddressTextFieldActionPerformed(evt);
            }
        });

        clientPostCodeTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientPostCodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientPostCodeTextFieldActionPerformed(evt);
            }
        });

        clientCityTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientCityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientCityTextFieldActionPerformed(evt);
            }
        });

        clientTelTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientTelTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientTelTextFieldActionPerformed(evt);
            }
        });

        clientEmailTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientEmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientEmailTextFieldActionPerformed(evt);
            }
        });

        clientIncassoCombobox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clientIncassoCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nee", "Ja" }));

        addInsuranceContractButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addInsuranceContractButton.setText("Voeg polis toe");
        addInsuranceContractButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInsuranceContractButtonActionPerformed(evt);
            }
        });

        saveClientButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveClientButton.setText("Opslaan");
        saveClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveClientButtonActionPerformed(evt);
            }
        });

        clientIncassoLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientIncassoLabel1.setText("Incasso:");

        treatmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Behandelcode", "Einddatum behandeling"
            }
        ));
        treatmentsTable.getTableHeader().setResizingAllowed(false);
        treatmentsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(treatmentsTable);

        getInvoiceButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getInvoiceButton.setText("Toon factuur");
        getInvoiceButton.setActionCommand("");
        getInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getInvoiceButtonActionPerformed(evt);
            }
        });

        clientIBANTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientIBANTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientIBANTextFieldActionPerformed(evt);
            }
        });

        clientEmailLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientEmailLabel1.setText("Email:");

        polisCheckBox.setSelected(true);
        polisCheckBox.setText("toegevoegd");
        polisCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                polisCheckBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Client Toevoegen");

        declineButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        declineButton.setText("Annuleren");
        declineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clientFirstNameLabel)
                            .addComponent(clientLastNameLabel)
                            .addComponent(clientBSNLabel)
                            .addComponent(clientAddressLabel)
                            .addComponent(clientPostCodeLabel)
                            .addComponent(clientCityLabel)
                            .addComponent(clientTelLabel)
                            .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(clientIncassoLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(clientPanelLayout.createSequentialGroup()
                                    .addComponent(clientEmailLabel1)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(clientPanelLayout.createSequentialGroup()
                                    .addComponent(clientPolisLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                    .addComponent(polisCheckBox))))
                        .addGap(18, 18, 18)
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(clientEmailTextField)
                                .addComponent(clientCityTextField)
                                .addComponent(clientPostCodeTextField)
                                .addComponent(clientAddressTextField)
                                .addComponent(clientBSNTextField)
                                .addComponent(clientLastNameTextField)
                                .addComponent(clientFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(clientTelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientIBANTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientIncassoCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addInsuranceContractButton, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(clientEmailLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getInvoiceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(declineButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientFirstNameLabel)
                    .addComponent(clientFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientLastNameLabel)
                    .addComponent(clientLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientBSNLabel)
                    .addComponent(clientBSNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientAddressLabel)
                    .addComponent(clientAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientPostCodeLabel)
                    .addComponent(clientPostCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientCityLabel)
                    .addComponent(clientCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientTelLabel)
                    .addComponent(clientTelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientEmailLabel1))
                .addGap(7, 7, 7)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientEmailLabel)
                    .addComponent(clientIBANTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientIncassoCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientIncassoLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInsuranceContractButton)
                    .addComponent(clientPolisLabel)
                    .addComponent(polisCheckBox))
                .addGap(18, 18, 18)
                .addComponent(saveClientButton)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getInvoiceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(declineButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(clientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(clientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clientFirstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientFirstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientFirstNameTextFieldActionPerformed

    private void clientLastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientLastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientLastNameTextFieldActionPerformed

    private void clientBSNTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientBSNTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientBSNTextFieldActionPerformed

    private void clientAddressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientAddressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientAddressTextFieldActionPerformed

    private void clientPostCodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientPostCodeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientPostCodeTextFieldActionPerformed

    private void clientCityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientCityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientCityTextFieldActionPerformed

    private void clientTelTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientTelTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientTelTextFieldActionPerformed

    private void clientEmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientEmailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientEmailTextFieldActionPerformed

    private void addInsuranceContractButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInsuranceContractButtonActionPerformed
        InvoiceGUI invoiceGUI = new InvoiceGUI();

    }//GEN-LAST:event_addInsuranceContractButtonActionPerformed

    private void saveClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveClientButtonActionPerformed
        String BSN = clientBSNTextField.getText();
        String name = clientLastNameTextField.getText();
        String firstName = clientFirstNameTextField.getText();
        String city = clientCityTextField.getText();
        String postcode = clientPostCodeTextField.getText();
        String address = clientAddressTextField.getText();
        String IBAN = clientIBANTextField.getText();
        boolean incasso;
        if (clientIncassoCombobox.getSelectedItem().toString().equals("Nee")) {
            incasso = false;
        } else {
            incasso = true;
        }
        String email = clientEmailTextField.getText();
        String tel = clientTelTextField.getText();
        Client client = new Client(BSN, name, firstName, city, postcode, address, IBAN, incasso, email, tel);

        boolean validBSN = isValidBSN(BSN);
        boolean validPostCode = isValidPostCode(postcode);
        boolean validAddress = isValidAddress(address);
        boolean validFirstName = isValidFirstName(firstName);
        boolean validLastName = isValidLastName(name);
        boolean validEmail = isValidEmail(email);
        boolean validCity = isValidCity(city);
        boolean validTel = isValidTel(tel);
        boolean validIBAN = isValidIBAN(IBAN);

        /**
        * Valid FirstName message
        */
        if (validFirstName == false) {
            JOptionPane.showMessageDialog(null, "De ingevoerde voornaam is onjuist. Een naam mag enkel letters, spaties en - bevatten.", "Onjuiste voornaam", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (validLastName == false) {
            JOptionPane.showMessageDialog(null, "De ingevoerde achteraam is onjuist. Een naam mag enkel letters, spaties en - bevatten.", "Onjuiste achternaam", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /**
        * Valid BSN message
        */
        if (validBSN == false) {
            JOptionPane.showMessageDialog(null, "Het ingevoerde BSN is niet valide.", "Onjuiste BSN", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /**
        * Valid address message
        */
        if (validAddress == false) {
            JOptionPane.showMessageDialog(null, "Het ingevoerde adres is onjuist.", "Onjuist adres", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /**
        * Valid postcode message
        */
        if (validPostCode == false) {
            JOptionPane.showMessageDialog(null, "De ingevoerde postcode is onjuist. Postcode bevat vier cijfers en twee letters.", "Onjuiste Postcode", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /**
        * Valid city message
        */
        if (validCity == false) {
            JOptionPane.showMessageDialog(null, "De ingevoerde plaats is onjuist. Een plaats mag enkel letters, spaties en de symbolen ' - bevatten.", "Onjuiste plaats", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /**
        * Valid tel message
        */
        if (validTel == false) {
            JOptionPane.showMessageDialog(null, "Het ingevoerde telefoonnummer is onjuist. Een telefoonnummer kan ekel cijfers en de symbolen - + bevatten.", "Onjuist telefoonnummer", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /**
        * Valid email message
        */
        if (validEmail == false) {
            JOptionPane.showMessageDialog(null, "Het ingevoerde mailadres is onjuist.", "Onjuist mailadres", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (validIBAN == false) {
            JOptionPane.showMessageDialog(null, "Het ingevoerde IBAN nummer is onjuist. Controleer uw invoer.", "Onjuist IBAN nummer", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /**
        * client succesfully added message
        */
        boolean result = clientManager.addClient(client);
        if (result == true) {
            JOptionPane.showMessageDialog(null, "De client is succesvol toegevoegd.", "Toevoegen", JOptionPane.INFORMATION_MESSAGE);
            clientPanel.setVisible(false);
            emptyTextFields();

        } else {
            JOptionPane.showMessageDialog(null, "Dit BSN nummer is al bekend in het systeem.", "Klant bestaat al", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_saveClientButtonActionPerformed

    private void getInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getInvoiceButtonActionPerformed

    private void clientIBANTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientIBANTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientIBANTextFieldActionPerformed

    private void polisCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_polisCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_polisCheckBoxActionPerformed

    private void declineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineButtonActionPerformed
        Object[] options = {"Ja", "Nee"};

        int result = JOptionPane.showOptionDialog(null, "Weet u zeker dat u deze invoer wilt unnuleren?", "Annuleren", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if(result == JOptionPane.YES_OPTION) {
            clientPanel.setVisible(false);
            emptyTextFields();
        }

    }//GEN-LAST:event_declineButtonActionPerformed
/**
     * Validate BSN according to
     * http://nl.wikipedia.org/wiki/Burgerservicenummer
     */
    private boolean isValidBSN(String BSN) {
        int candidate;
        try {
            candidate = Integer.parseInt(BSN);
        } catch (NumberFormatException e) {
            return false;
        }

        if (candidate <= 9999999 || candidate > 999999999) {
            return false;
        }
        int sum = -1 * candidate % 10;

        for (int multiplier = 2; candidate > 0; multiplier++) {
            int val = (candidate /= 10) % 10;
            sum += multiplier * val;
        }

        return sum != 0 && sum % 11 == 0;

    }

    /**
     *
     * @param postCode check valid with regex.
     * @return
     */
    private boolean isValidPostCode(String postCode) {
        //  if (postCode.length()>= 6 || postCode.length() <= 7)
        if (postCode.matches("^[1-9][0-9]{3}[\\s]?[A-Za-z]{2}$")) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param address check valid with regex.
     * @return
     */
    private boolean isValidAddress(String address) {
        if (address.matches("^([1-9][e][\\s])*([a-zA-Z]+(([\\.][\\s])|([\\s]))?)+[1-9][0-9]*(([-][1-9][0-9]*)|([\\s]?[a-zA-Z]+))?$")) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param firstName check valid firstName with regex.
     * @return
     */
    private boolean isValidFirstName(String firstName) {
        if (firstName.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$")) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param lastName check valid lastName with regex.
     * @return
     */
    private boolean isValidLastName(String lastName) {
        if (lastName.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$")) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param email check email validate by RFC 5322 offical standard with
     * regex.
     * @return
     */
    private boolean isValidEmail(String email) {
        if (email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param city check validate with regex.
     * @return
     */
    private boolean isValidCity(String city) {
        if (city.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$")) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param tel check validate telnumber with regex (made by Burak).
     * @return
     */
    private boolean isValidTel(String tel) {
        if (tel.matches("^(\\+?)[\\d+]{0,5}(\\d|\\s|\\-)[\\d+]{0,8}$")) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param IBAN check validate IBAN with regex.
     * @return
     */
    private boolean isValidIBAN(String IBAN) {
        if (IBAN.matches("[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}")) {
            return true;
        }
        return false;
    }
     /**
     * clear TextField add Client Panal
     */
    public void emptyTextFields() {
        clientFirstNameTextField.setText("");
        clientLastNameTextField.setText("");
        clientBSNTextField.setText("");
        clientAddressTextField.setText("");
        clientPostCodeTextField.setText("");
        clientCityTextField.setText("");
        clientTelTextField.setText("");
        clientEmailTextField.setText("");
        clientIBANTextField.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInsuranceContractButton;
    private javax.swing.JLabel clientAddressLabel;
    private javax.swing.JTextField clientAddressTextField;
    private javax.swing.JLabel clientBSNLabel;
    private javax.swing.JTextField clientBSNTextField;
    private javax.swing.JLabel clientCityLabel;
    private javax.swing.JTextField clientCityTextField;
    private javax.swing.JLabel clientEmailLabel;
    private javax.swing.JLabel clientEmailLabel1;
    private javax.swing.JTextField clientEmailTextField;
    private javax.swing.JLabel clientFirstNameLabel;
    private javax.swing.JTextField clientFirstNameTextField;
    private javax.swing.JTextField clientIBANTextField;
    private javax.swing.JComboBox clientIncassoCombobox;
    private javax.swing.JLabel clientIncassoLabel1;
    private javax.swing.JLabel clientLastNameLabel;
    private javax.swing.JTextField clientLastNameTextField;
    private javax.swing.JPanel clientPanel;
    private javax.swing.JLabel clientPolisLabel;
    private javax.swing.JLabel clientPostCodeLabel;
    private javax.swing.JTextField clientPostCodeTextField;
    private javax.swing.JLabel clientTelLabel;
    private javax.swing.JTextField clientTelTextField;
    private javax.swing.JButton declineButton;
    private javax.swing.JButton getInvoiceButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox polisCheckBox;
    private javax.swing.JButton saveClientButton;
    private javax.swing.JTable treatmentsTable;
    // End of variables declaration//GEN-END:variables
}
