/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.UserDirectory;

import Business.Business;
import Business.User;
import UserInterface.LoginJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Menita Koonani
 */
public class UserWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserWorkAreaJPanel
     */
    JPanel UserProcessContainer;
    Business business;
    User user;

    public UserWorkAreaJPanel(JPanel UserProcessContainer, Business business, User user) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.business = business;
        this.user = user;
        populateUserWorkAreaPanel();
    }

    public void populateUserWorkAreaPanel() {
        userIDField.setText(String.valueOf(user.getUserId()));
        userNameField.setText(user.getUsername());
        userRoleField.setText(user.getUserRole());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userRoleField = new javax.swing.JLabel();
        userIDField = new javax.swing.JLabel();
        userNameField = new javax.swing.JLabel();
        workAreaPanelHeader = new javax.swing.JLabel();
        manageUsersBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Role : ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 200, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("User ID : ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 200, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("User Name : ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 200, 30));

        userRoleField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(userRoleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 200, 30));

        userIDField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(userIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 200, 30));

        userNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 200, 30));

        workAreaPanelHeader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        workAreaPanelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        workAreaPanelHeader.setText("User Work Area Panel");
        add(workAreaPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 760, 60));

        manageUsersBtn.setBackground(new java.awt.Color(0, 153, 153));
        manageUsersBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manageUsersBtn.setText("Manage User Accounts");
        manageUsersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUsersBtnActionPerformed(evt);
            }
        });
        add(manageUsersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 250, 30));

        logoutBtn.setBackground(new java.awt.Color(0, 153, 153));
        logoutBtn.setText("<< Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 213, 110, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void manageUsersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUsersBtnActionPerformed
        // TODO add your handling code here:
        ManageUserAccountDirectory manageUserAccDir = new ManageUserAccountDirectory(UserProcessContainer, business, user);
        CardLayout cardLayout = (CardLayout) UserProcessContainer.getLayout();
        UserProcessContainer.add("ManageUserAccDirPanel", manageUserAccDir);
        cardLayout.next(UserProcessContainer);
    }//GEN-LAST:event_manageUsersBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout? ", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            UserProcessContainer.remove(this);
            Component[] componentArray = UserProcessContainer.getComponents();
            Component component = componentArray[componentArray.length - 1];
            CardLayout cardLayout = (CardLayout) UserProcessContainer.getLayout();
            LoginJPanel loginPanel = (LoginJPanel) component;
            loginPanel.renderLoginPage();
            cardLayout.previous(UserProcessContainer);
        }// TODO add your handling code here:

    }//GEN-LAST:event_logoutBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton manageUsersBtn;
    private javax.swing.JLabel userIDField;
    private javax.swing.JLabel userNameField;
    private javax.swing.JLabel userRoleField;
    private javax.swing.JLabel workAreaPanelHeader;
    // End of variables declaration//GEN-END:variables
}
