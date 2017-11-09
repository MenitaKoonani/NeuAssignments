/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DistributorRole;

import Business.Enterprise.HospitalEnterprise;
import Business.Organization.DistributorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.VaccineQueue.RequestVaccine;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Menita Koonani
 */
public class DistributorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private DistributorOrganization distributorOrganization;
    private HospitalEnterprise enterprise;

    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public DistributorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, HospitalEnterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.distributorOrganization = (DistributorOrganization) organization;
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
        SupplyVaccinesBtn = new javax.swing.JButton();
        manageVaccinesBtn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 127, 30));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 158, 26));

        SupplyVaccinesBtn.setText("Supply Vaccines");
        SupplyVaccinesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplyVaccinesBtnActionPerformed(evt);
            }
        });
        add(SupplyVaccinesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 180, -1));

        manageVaccinesBtn.setText("Manage Vaccines");
        manageVaccinesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVaccinesBtnActionPerformed(evt);
            }
        });
        add(manageVaccinesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void manageVaccinesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageVaccinesBtnActionPerformed
        ManageVaccinesJPanel manageVaccinesJPanel = new ManageVaccinesJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("manageVaccinesJPanel", manageVaccinesJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageVaccinesBtnActionPerformed

    private void SupplyVaccinesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplyVaccinesBtnActionPerformed
        SupplyVaccinesJPanel supplyVaccinesJPanel = new SupplyVaccinesJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("supplyVaccinesJPanel", supplyVaccinesJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_SupplyVaccinesBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SupplyVaccinesBtn;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton manageVaccinesBtn;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
