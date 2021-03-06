/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import UserApplication.*;
import java.awt.Dimension;

/**
 *
 * @author Menita Koonani
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private Person person;
    public MainJFrame() {
        initComponents();
        person = new Person();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userJPanel = new javax.swing.JPanel();
        userSplitPane = new javax.swing.JSplitPane();
        userControlPanel = new javax.swing.JPanel();
        createUserBtn = new javax.swing.JButton();
        viewUserBtn = new javax.swing.JButton();
        addAddressBtn = new javax.swing.JButton();
        addLicenseBtn = new javax.swing.JButton();
        addCreditCardBtn = new javax.swing.JButton();
        addAccountBtn = new javax.swing.JButton();
        userDisplayPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createUserBtn.setText("Create a new User");
        createUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserBtnActionPerformed(evt);
            }
        });

        viewUserBtn.setText("View User Details");
        viewUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserBtnActionPerformed(evt);
            }
        });

        addAddressBtn.setText("Add your address");
        addAddressBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAddressBtnActionPerformed(evt);
            }
        });

        addLicenseBtn.setText("Add License details");
        addLicenseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLicenseBtnActionPerformed(evt);
            }
        });

        addCreditCardBtn.setText("Add credit card details");
        addCreditCardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCreditCardBtnActionPerformed(evt);
            }
        });

        addAccountBtn.setText("Add financial details");
        addAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccountBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userControlPanelLayout = new javax.swing.GroupLayout(userControlPanel);
        userControlPanel.setLayout(userControlPanelLayout);
        userControlPanelLayout.setHorizontalGroup(
            userControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addCreditCardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addLicenseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addAddressBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addAccountBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userControlPanelLayout.setVerticalGroup(
            userControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userControlPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(createUserBtn)
                .addGap(18, 18, 18)
                .addComponent(addAddressBtn)
                .addGap(18, 18, 18)
                .addComponent(addLicenseBtn)
                .addGap(18, 18, 18)
                .addComponent(addCreditCardBtn)
                .addGap(18, 18, 18)
                .addComponent(addAccountBtn)
                .addGap(18, 18, 18)
                .addComponent(viewUserBtn)
                .addGap(100, 100, 100))
        );

        userSplitPane.setLeftComponent(userControlPanel);

        userDisplayPanel.setAutoscrolls(true);

        javax.swing.GroupLayout userDisplayPanelLayout = new javax.swing.GroupLayout(userDisplayPanel);
        userDisplayPanel.setLayout(userDisplayPanelLayout);
        userDisplayPanelLayout.setHorizontalGroup(
            userDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );
        userDisplayPanelLayout.setVerticalGroup(
            userDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );

        userSplitPane.setRightComponent(userDisplayPanel);

        javax.swing.GroupLayout userJPanelLayout = new javax.swing.GroupLayout(userJPanel);
        userJPanel.setLayout(userJPanelLayout);
        userJPanelLayout.setHorizontalGroup(
            userJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                .addContainerGap())
        );
        userJPanelLayout.setVerticalGroup(
            userJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userJPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(userSplitPane)
                .addContainerGap())
        );

        getContentPane().add(userJPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserBtnActionPerformed
        // TODO add your handling code here:
        ViewAllDetailsJPanel viewAllDetailsPanel = new ViewAllDetailsJPanel(person);
        userSplitPane.setRightComponent(viewAllDetailsPanel);
    }//GEN-LAST:event_viewUserBtnActionPerformed

    private void createUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserBtnActionPerformed
        // TODO add your handling code here:
        CreateUserJPanel createUserJPanel = new CreateUserJPanel(person);
        userSplitPane.setRightComponent(createUserJPanel);
    }//GEN-LAST:event_createUserBtnActionPerformed

    private void addAddressBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAddressBtnActionPerformed
        // TODO add your handling code here:
        CreateAddressJPanel createAddressJPanel = new CreateAddressJPanel(person);
        userSplitPane.setRightComponent(createAddressJPanel);
    }//GEN-LAST:event_addAddressBtnActionPerformed

    private void addLicenseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLicenseBtnActionPerformed
        // TODO add your handling code here:
        CreateLicenseJPanel createLicensePanel = new CreateLicenseJPanel(person);
        userSplitPane.setRightComponent(createLicensePanel);
    }//GEN-LAST:event_addLicenseBtnActionPerformed

    private void addCreditCardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCreditCardBtnActionPerformed
        // TODO add your handling code here:
        CreateCreditCardJPanel createCreditCardJPanel = new CreateCreditCardJPanel(person);
        userSplitPane.setRightComponent(createCreditCardJPanel);
    }//GEN-LAST:event_addCreditCardBtnActionPerformed

    private void addAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAccountBtnActionPerformed
        // TODO add your handling code here:
        CreateFinancialAccountsJPanel createFinancialAccPanel = new CreateFinancialAccountsJPanel(person);
        userSplitPane.setRightComponent(createFinancialAccPanel);
    }//GEN-LAST:event_addAccountBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAccountBtn;
    private javax.swing.JButton addAddressBtn;
    private javax.swing.JButton addCreditCardBtn;
    private javax.swing.JButton addLicenseBtn;
    private javax.swing.JButton createUserBtn;
    private javax.swing.JPanel userControlPanel;
    private javax.swing.JPanel userDisplayPanel;
    private javax.swing.JPanel userJPanel;
    private javax.swing.JSplitPane userSplitPane;
    private javax.swing.JButton viewUserBtn;
    // End of variables declaration//GEN-END:variables
}
