/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.presentation;

import edu.avans.ivh5.client.businesslogic.ClientManager;
import edu.avans.ivh5.client.businesslogic.InvoiceManager;
import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.shared.models.Client;
import edu.avans.ivh5.shared.models.Invoice;
import edu.avans.ivh5.shared.util.DateFormatter;
import edu.avans.ivh5.shared.util.generateInvoicePDF;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Bart Donders
 */
public class ClientGUI extends javax.swing.JFrame {

    //relaties
    private ClientManager clientManager;
    private List<Client> clienten;
    private Client selectedClient;
    private List<Invoice> invoices;
    private InvoiceManager invoiceManager;

    /**
     * Creates new form ClientGUI
     */
    public ClientGUI() {
        this.clienten = new ArrayList<>();
        initComponents();

        clientsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (clientsTable.getSelectedRow() != -1) {
                    String BSN = clientsTable.getValueAt(clientsTable.getSelectedRow(), 2).toString();

                    try {
                        List<Client> result = clientManager.searchClient(BSN);

                        if (result.isEmpty()) {
                            return;
                        }
                        Client client = result.get(0);

                        clientFirstNameTextField.setText(client.getFirstName());
                        clientLastNameTextField.setText(client.getName());
                        clientBSNTextField.setText(client.getBSN());
                        clientAddressTextField.setText(client.getAddress());
                        clientPostCodeTextField.setText(client.getPostcode());
                        clientCityTextField.setText(client.getCity());
                        clientTelTextField.setText(client.getTel());
                        clientEmailTextField.setText(client.getEmail());
                        clientIBANTextField.setText(client.getIBAN());
                        int index;
                        if (client.isIncasso()) {
                            index = 0;
                        } else {
                            index = 1;
                        }

                        clientIncassoCombobox.setSelectedIndex(index);
                        selectedClient = client;
                        clientPanel.setVisible(true);
                        jScrollPane2.setVisible(true);
                        getInvoiceButton.setVisible(true);
                        clientPolisLabel.setVisible(true);
                        addInsuranceContractButton.setVisible(true);
                        polisCheckBox.setVisible(true);

                        if (clientManager.hasInsuranceContract(client)) {
                            setCheckBox(true);
                        } else {
                            setCheckBox(false);
                        }

                        DefaultTableModel tableModel = (DefaultTableModel) treatmentsTable.getModel();
                        try {
                            invoices = clientManager.getInvoices(selectedClient);
                        } catch (RemoteException e) {
                            invoices = new ArrayList<>();
                        }

                        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                            tableModel.removeRow(i);
                        }

                        for (int i = 0; i < invoices.size(); i++) {
                            Invoice invoice = invoices.get(i);
                            tableModel.addRow(new Object[]{invoice.getTreatmentCode(), DateFormatter.dateToString(invoice.getDate()), invoice.isPaid()});
                        }

                    } catch (RemoteException e) {
                        JOptionPane.showMessageDialog(null, "Geen verbinding met de server", "Server error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }

        });

        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        this.clientManager = new ClientManager();
        this.invoiceManager = new InvoiceManager();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        clientsTable = new javax.swing.JTable();
        searchClientButton = new javax.swing.JButton();
        searchClientTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addClientButton = new javax.swing.JButton();
        deleteClientButton = new javax.swing.JButton();
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
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clientbeheer");
        setMinimumSize(null);
        setName("Clientbeheer"); // NOI18N

        clientsTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Voornaam", "Achternaam", "BSN"
            }
        ){    @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }}
        );
        clientsTable.getTableHeader().setResizingAllowed(false);
        clientsTable.getTableHeader().setReorderingAllowed(false);
        clientsTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                clientsTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(clientsTable);

        searchClientButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchClientButton.setText("Zoeken");
        searchClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchClientButtonActionPerformed(evt);
            }
        });

        searchClientTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchClientTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        searchClientTextField.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("Clientbeheer");

        addClientButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addClientButton.setText("Client toevoegen");
        addClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClientButtonActionPerformed(evt);
            }
        });

        deleteClientButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteClientButton.setText("Client verwijderen");
        deleteClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteClientButtonActionPerformed(evt);
            }
        });

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

        clientBSNTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        clientAddressTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        clientPostCodeTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        clientCityTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        clientTelTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        clientEmailTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

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
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Behandelcode", "Einddatum behandeling", "Betaald"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        treatmentsTable.getTableHeader().setResizingAllowed(false);
        treatmentsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(treatmentsTable);
        if (treatmentsTable.getColumnModel().getColumnCount() > 0) {
            treatmentsTable.getColumnModel().getColumn(0).setResizable(false);
            treatmentsTable.getColumnModel().getColumn(1).setResizable(false);
            treatmentsTable.getColumnModel().getColumn(2).setResizable(false);
        }

        getInvoiceButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getInvoiceButton.setText("Toon factuur");
        getInvoiceButton.setActionCommand("");
        getInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getInvoiceButtonActionPerformed(evt);
            }
        });

        clientIBANTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        clientEmailLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientEmailLabel1.setText("Email:");

        polisCheckBox.setText("toegevoegd");
        polisCheckBox.setEnabled(false);
        polisCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                polisCheckBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Client toevoegen / wijzigen");

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
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(declineButton, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(getInvoiceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        clientFirstNameTextField.getAccessibleContext().setAccessibleName("");
        clientFirstNameTextField.getAccessibleContext().setAccessibleDescription("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Zoeken:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addClientButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteClientButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchClientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addComponent(clientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchClientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addClientButton)
                            .addComponent(deleteClientButton))
                        .addGap(51, 51, 51))))
        );

        searchClientTextField.getAccessibleContext().setAccessibleName("");
        searchClientTextField.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClientButtonActionPerformed
        if (selectedClient != null) {
            clientFirstNameTextField.setText("");
            clientLastNameTextField.setText("");
            clientBSNTextField.setText("");
            clientAddressTextField.setText("");
            clientPostCodeTextField.setText("");
            clientCityTextField.setText("");
            clientTelTextField.setText("");
            clientEmailTextField.setText("");
            clientIBANTextField.setText("");
            selectedClient = null;

        }
        clientPanel.setVisible(true);
        jScrollPane2.setVisible(false);
        getInvoiceButton.setVisible(false);
        clientPolisLabel.setVisible(false);
        addInsuranceContractButton.setVisible(false);
        polisCheckBox.setVisible(false);

    }//GEN-LAST:event_addClientButtonActionPerformed

    private void deleteClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteClientButtonActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) clientsTable.getModel();
        Object[] options = {"Ja", "Nee"};
        List<Invoice> invoices = null;

        if (clientsTable.getSelectedRowCount() != 1) {
            System.out.println("Selecteer één persoon");
            return;
        }

        try {
            invoices = clientManager.getInvoices(clientManager.searchClient((String) clientsTable.getValueAt(clientsTable.getSelectedRow(), 2)).get(0));
        } catch (RemoteException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


        for (Invoice in : invoices) {
            if (!in.isPaid()) {
                JOptionPane.showMessageDialog(null, "Verwijderen niet mogelijk. De client heeft nog openstaande betalingen", "Openstaande betalingen", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }


        int action = JOptionPane.showOptionDialog(null, "Weet u zeker dat u deze client wilt verwijderen?", "Verwijderen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        System.out.println("" + action);

        if (action == 0) {
            try {
                clientManager.deleteClient((String) clientsTable.getValueAt(clientsTable.getSelectedRow(), 2));
                tableModel.removeRow(clientsTable.getSelectedRow());
            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(null, "Geen verbinding met de server", "Server error", JOptionPane.ERROR_MESSAGE);
            }
            clientPanel.setVisible(false);
            emptyTextFields();
        }

    }//GEN-LAST:event_deleteClientButtonActionPerformed

    private void searchClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchClientButtonActionPerformed

        DefaultTableModel tableModel = (DefaultTableModel) clientsTable.getModel();

        if (tableModel.getRowCount()
                > 0) {
            for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                tableModel.removeRow(i);
            }
        }
        try {
            clienten = clientManager.searchClient(searchClientTextField.getText());
        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(null, "Startdatum is incorrect", "", JOptionPane.ERROR_MESSAGE);

        }
        //clientsTable
        for (Client c : clienten) {

            String firstName = c.getFirstName();
            String lastName = c.getName();
            String bsn = c.getBSN();

            tableModel.addRow(new Object[]{firstName, lastName, bsn});

        }

    }//GEN-LAST:event_searchClientButtonActionPerformed

    private void declineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineButtonActionPerformed
        Object[] options = {"Ja", "Nee"};

        int result = JOptionPane.showOptionDialog(null, "Weet u zeker dat u deze invoer wilt annuleren?", "Annuleren", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (result == JOptionPane.YES_OPTION) {
            clientPanel.setVisible(false);
            emptyTextFields();
        }
    }//GEN-LAST:event_declineButtonActionPerformed


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
        if (selectedClient != null) {

            for (int i = 0; i < treatmentsTable.getRowCount(); i++) {
                boolean isChecked = (Boolean) treatmentsTable.getValueAt(i, 2);
                Invoice invoice = invoices.get(i);

                invoice.setPaid(isChecked);
                try {
                    invoiceManager.changeInvoice(invoice, invoice);
                } catch (RemoteException ex) {
                    Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            try {
                if (clientManager.changeClient(selectedClient, client)) {
                    JOptionPane.showMessageDialog(null, "De client is succesvol gewijzigd.", "Gewijzigd", JOptionPane.INFORMATION_MESSAGE);
                    searchClientButton.doClick();
                }
            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(null, "Geen verbinding met de server", "Server error", JOptionPane.ERROR_MESSAGE);
            }

            emptyTextFields();
            clientPanel.setVisible(false);

        } else {
            try {
                boolean result = clientManager.addClient(client);

                if (result == true) {
                    JOptionPane.showMessageDialog(null, "De client is succesvol toegevoegd.", "Toevoegen", JOptionPane.INFORMATION_MESSAGE);
                    clientPanel.setVisible(false);
                    emptyTextFields();
                    searchClientButton.doClick();

                } else {
                    JOptionPane.showMessageDialog(null, "Dit BSN nummer is al bekend in het systeem.", "Klant bestaat al", JOptionPane.ERROR_MESSAGE);
                }
            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(null, "Startdatum is incorrect", "", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_saveClientButtonActionPerformed

    private void addInsuranceContractButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInsuranceContractButtonActionPerformed
        JFrame frame = new InvoiceGUI(selectedClient, this);
        frame.pack();
        frame.setVisible(true);
        
        //InvoiceGUI gui = new InvoiceGUI(new InvoiceManager());
    }//GEN-LAST:event_addInsuranceContractButtonActionPerformed

    private void polisCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_polisCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_polisCheckBoxActionPerformed

    private void clientEmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientEmailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientEmailTextFieldActionPerformed

    private void clientTelTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientTelTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientTelTextFieldActionPerformed

    private void clientCityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientCityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientCityTextFieldActionPerformed

    private void clientPostCodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientPostCodeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientPostCodeTextFieldActionPerformed

    private void clientAddressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientAddressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientAddressTextFieldActionPerformed

    private void clientBSNTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientBSNTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientBSNTextFieldActionPerformed

    private void clientLastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientLastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientLastNameTextFieldActionPerformed

    private void clientFirstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientFirstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientFirstNameTextFieldActionPerformed

    private void clientIBANTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientIBANTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientIBANTextFieldActionPerformed

    private void clientsTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_clientsTablePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_clientsTablePropertyChange

    private void getInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getInvoiceButtonActionPerformed

        ListSelectionModel lsm = treatmentsTable.getSelectionModel();
        int index = lsm.getMinSelectionIndex();
        File f = new File(generateInvoicePDF.getInvoicePDF(invoices.get(index)) + ".pdf");
        try {
            Desktop.getDesktop().open(f);
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }//GEN-LAST:event_getInvoiceButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

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

    public void setCheckBox(boolean value) {
        polisCheckBox.setSelected(value);
    }

    private int getRowByValue(TableModel model, Object value) {
        for (int i = model.getRowCount() - 1; i >= 0; --i) {
            for (int j = model.getColumnCount() - 1; j >= 0; --j) {
                if (model.getValueAt(i, j).equals(value)) {
                    // what if value is not unique?
                    return i;
                }
            }
        }
        return -1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClientButton;
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
    private javax.swing.JTable clientsTable;
    private javax.swing.JButton declineButton;
    private javax.swing.JButton deleteClientButton;
    private javax.swing.JButton getInvoiceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox polisCheckBox;
    private javax.swing.JButton saveClientButton;
    private javax.swing.JButton searchClientButton;
    private javax.swing.JTextField searchClientTextField;
    private javax.swing.JTable treatmentsTable;
    // End of variables declaration//GEN-END:variables

}
