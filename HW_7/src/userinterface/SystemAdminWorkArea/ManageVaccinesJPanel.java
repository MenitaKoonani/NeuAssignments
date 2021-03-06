/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.Disease.Disease;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Vaccine.Vaccine;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Menita Koonani
 */
public class ManageVaccinesJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem system;

    /**
     * Creates new form ManageVaccinesJPanel
     */
    public ManageVaccinesJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        populateDiseaseComboBox();
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel jTable = (DefaultTableModel) diseaseVaccineTable.getModel();
        jTable.setRowCount(0);
        for (Vaccine eachVaccine : system.getVaccineCatalog().getVaccineList()) {
            Object[] row = new Object[2];
            row[0] = eachVaccine.getDisease();
            row[1] = eachVaccine;
            row[2] = eachVaccine.getMaxAvailable();
            jTable.addRow(row);
        }
    }

    public void populateDiseaseComboBox() {
        diseaseComboBox.removeAllItems();
        for (Disease eachDisease : system.getDiseaseCatalog().getDiseaseList()) {
            diseaseComboBox.addItem(String.valueOf(eachDisease));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageVaccinesBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        vaccineNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        diseaseComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        diseaseVaccineTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        maxAvailSpinner = new javax.swing.JSpinner();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageVaccinesBtn.setText("Add Vaccine");
        manageVaccinesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVaccinesBtnActionPerformed(evt);
            }
        });
        add(manageVaccinesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 150, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Disease : ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 90, 20));
        add(vaccineNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 170, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Max Availabiltiy : ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 120, 20));

        add(diseaseComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 170, -1));

        diseaseVaccineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disease", "Vaccine", "Max Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(diseaseVaccineTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 110));

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Manage Vaccine Catalog");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 320, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Vaccine Name : ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 90, 20));
        add(maxAvailSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 100, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void manageVaccinesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageVaccinesBtnActionPerformed
        String vaccine = vaccineNameField.getText();
        if (vaccine.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vaccine name cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if ((int) maxAvailSpinner.getValue() <= 0) {
            JOptionPane.showMessageDialog(null, "Vaccine availability should be positive!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Disease disease = system.getDiseaseCatalog().getDiseaseByName((String) diseaseComboBox.getSelectedItem());
        system.getVaccineCatalog().newVaccine(vaccine, disease, (int) maxAvailSpinner.getValue());
        vaccineNameField.setText("");
        maxAvailSpinner.setValue(0);
        populateTable();
    }//GEN-LAST:event_manageVaccinesBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> diseaseComboBox;
    private javax.swing.JTable diseaseVaccineTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageVaccinesBtn;
    private javax.swing.JSpinner maxAvailSpinner;
    private javax.swing.JTextField vaccineNameField;
    // End of variables declaration//GEN-END:variables
}
