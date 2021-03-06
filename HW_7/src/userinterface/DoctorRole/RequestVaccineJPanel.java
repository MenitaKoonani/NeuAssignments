/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.Disease.Disease;
import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.DistributorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.VaccineQueue.RequestVaccine;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Menita Koonani
 */
public class RequestVaccineJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private HospitalEnterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem system;

    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestVaccineJPanel(JPanel userProcessContainer, UserAccount account, HospitalEnterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.system = system;
        valueLabel.setText(enterprise.getName());
        populateDiseaseComboBox();
        populateVaccineTable(String.valueOf(diseaseComboBox.getSelectedItem()));
    }

    public void populateDiseaseComboBox() {
        diseaseComboBox.removeAllItems();
        for (Disease eachDisease : system.getDiseaseCatalog().getDiseaseList()) {
            diseaseComboBox.addItem(String.valueOf(eachDisease));
        }
    }

    public void populateVaccineTable(String disease) {
        DefaultTableModel jTable = (DefaultTableModel) vaccineTable.getModel();
        jTable.setRowCount(0);
        for (Vaccine eachVaccine : system.getVaccineListForDisease(disease)) {
            Object[] row = new Object[2];
            row[0] = eachVaccine.getVaccineId();
            row[1] = eachVaccine;
            jTable.addRow(row);
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

        requestTestJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        diseaseComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestTestJButton.setText("Request Vaccine");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 130, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 120, 30));

        diseaseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diseaseComboBoxActionPerformed(evt);
            }
        });
        add(diseaseComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 120, -1));

        jLabel2.setText("Disease : ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 90, 20));

        vaccineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Id", "Vaccine"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 160));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Request Vaccine Panel");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 320, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        int selectedRow = vaccineTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        RequestVaccine request = new RequestVaccine();
        Disease disease = system.getDiseaseCatalog().getDiseaseByName((String) diseaseComboBox.getSelectedItem());
        request.setDisease(disease);
        request.setVaccine((Vaccine) vaccineTable.getValueAt(selectedRow, 1));
        request.setSender(userAccount);
        request.setStatus("Sent");
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof ClinicOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request);
            system.getWorkQueue().getWorkRequestList().add(request);
            JOptionPane.showMessageDialog(null, "Vaccine requested!");
        }
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageVaccineRequestsJPanel mvrjp = (ManageVaccineRequestsJPanel) component;
        mvrjp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void diseaseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diseaseComboBoxActionPerformed
        populateVaccineTable(String.valueOf(diseaseComboBox.getSelectedItem()));
    }//GEN-LAST:event_diseaseComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox<String> diseaseComboBox;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JTable vaccineTable;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
