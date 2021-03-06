/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.UserDirectory;

import Business.Business;
import Business.User;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Menita Koonani
 */
public class FindUserJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FindPersonJPanel
     */
    JPanel UserProcessContainer;
    Business business;

    public FindUserJPanel(JPanel UserProcessContainer, Business business) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.business = business;
        setVisibility(false);
    }

    public void setVisibility(boolean isVisible) {
        personIdLabel.setVisible(isVisible);
        personIdField.setVisible(isVisible);

        firstnamelabel.setVisible(isVisible);
        firstnameField.setVisible(isVisible);

        lastnamelabel.setVisible(isVisible);
        lastnameField.setVisible(isVisible);

        dobLabel.setVisible(isVisible);
        dobField.setVisible(isVisible);

        usernameLabel.setVisible(isVisible);
        usernameField.setVisible(isVisible);

        userroleLabel.setVisible(isVisible);
        userroleField.setVisible(isVisible);

        accStatusLabel.setVisible(isVisible);
        accStatusField.setVisible(isVisible);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        managePersonDir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userId = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        lastnamelabel = new javax.swing.JLabel();
        firstnameField = new javax.swing.JTextField();
        firstnamelabel = new javax.swing.JLabel();
        lastnameField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        userroleLabel = new javax.swing.JLabel();
        userroleField = new javax.swing.JTextField();
        accStatusLabel = new javax.swing.JLabel();
        accStatusField = new javax.swing.JTextField();
        personIdLabel = new javax.swing.JLabel();
        personIdField = new javax.swing.JTextField();
        dobLabel = new javax.swing.JLabel();
        dobField = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        managePersonDir.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        managePersonDir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        managePersonDir.setText("Find User");
        add(managePersonDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 24, 720, 60));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Enter User ID : ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 200, 30));
        add(userId, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 230, 30));

        searchBtn.setBackground(new java.awt.Color(0, 153, 153));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 120, -1));

        lastnamelabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastnamelabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lastnamelabel.setText("Last Name : ");
        add(lastnamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 100, 30));

        firstnameField.setEditable(false);
        add(firstnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 230, 30));

        firstnamelabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstnamelabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        firstnamelabel.setText("First Name : ");
        add(firstnamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 100, 30));

        lastnameField.setEditable(false);
        add(lastnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 230, 30));

        backBtn.setBackground(new java.awt.Color(0, 153, 153));
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 100, -1));

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        usernameLabel.setText("Username : ");
        add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 100, 30));

        usernameField.setEditable(false);
        add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 230, 30));

        userroleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userroleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userroleLabel.setText("User role : ");
        add(userroleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 100, 30));

        userroleField.setEditable(false);
        add(userroleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 230, 30));

        accStatusLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        accStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        accStatusLabel.setText("Account Status : ");
        add(accStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 140, 30));

        accStatusField.setEditable(false);
        add(accStatusField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 230, 30));

        personIdLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        personIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        personIdLabel.setText("Person ID : ");
        add(personIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 100, 30));

        personIdField.setEditable(false);
        add(personIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 230, 30));

        dobLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dobLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dobLabel.setText("Date of Birth : ");
        add(dobLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 100, 30));

        dobField.setEditable(false);
        add(dobField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 230, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        int userID = Integer.parseInt(userId.getText());
        if (userId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter user id to search!", "Warning", JOptionPane.WARNING_MESSAGE);
            userId.requestFocus();
            return;
        }
        User user = business.getUserDirectory().getUserById(userID);
        if (user == null) {
            JOptionPane.showMessageDialog(null, "User not found!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        setVisibility(true);

//        DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM, yyyy");
        personIdField.setText(String.valueOf(user.getPerson().getPersonId()));
        firstnameField.setText(user.getPerson().getFirstName());
        lastnameField.setText(user.getPerson().getLastName());
        dobField.setText(String.valueOf(user.getPerson().getDateOfBirth()));
        usernameField.setText(user.getUsername());
        userroleField.setText(user.getUserRole());
        accStatusField.setText(user.isActive() ? "Active" : "Disabled");
    }//GEN-LAST:event_searchBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        Component[] componentArray = UserProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageUserAccountDirectory manageUserDir = (ManageUserAccountDirectory) component;
        manageUserDir.populateUserAccountDir();
        CardLayout cardLayout = (CardLayout) UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accStatusField;
    private javax.swing.JLabel accStatusLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField dobField;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JTextField firstnameField;
    private javax.swing.JLabel firstnamelabel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField lastnameField;
    private javax.swing.JLabel lastnamelabel;
    private javax.swing.JLabel managePersonDir;
    private javax.swing.JTextField personIdField;
    private javax.swing.JLabel personIdLabel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField userId;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField userroleField;
    private javax.swing.JLabel userroleLabel;
    // End of variables declaration//GEN-END:variables
}
