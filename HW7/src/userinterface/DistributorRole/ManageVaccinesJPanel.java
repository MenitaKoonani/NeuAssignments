/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DistributorRole;

import Business.Enterprise.HospitalEnterprise;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Menita Koonani
 */
public class ManageVaccinesJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    HospitalEnterprise enterprise;

    /**
     * Creates new form ManageVaccinesJPanel
     */
    public ManageVaccinesJPanel(JPanel userProcessContainer, HospitalEnterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        manageVaccinesBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        vaccineNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        diseaseComboBox = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 127, 30));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 158, 26));

        manageVaccinesBtn.setText("Add Vaccine");
        manageVaccinesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVaccinesBtnActionPerformed(evt);
            }
        });
        add(manageVaccinesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 150, -1));

        jLabel1.setText("Disease : ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 90, 20));
        add(vaccineNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 170, -1));

        jLabel2.setText("Vaccine Name : ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 90, 20));

        add(diseaseComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 170, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void manageVaccinesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageVaccinesBtnActionPerformed
        String vaccine = vaccineNameField.getText();
        if (vaccine.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vaccine name cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        enterprise.getVaccineCatalog().newVaccine(vaccine);
        vaccineNameField.setText("");
        JOptionPane.showMessageDialog(null, "Vaccine added to catalog!");
    }//GEN-LAST:event_manageVaccinesBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> diseaseComboBox;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton manageVaccinesBtn;
    private javax.swing.JTextField vaccineNameField;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}