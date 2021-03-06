/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PersonDirectory;

import Business.Business;
import Business.Person;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Menita Koonani
 */
public class UpdatePersonJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdatePersonJPanel
     */
    JPanel UserProcessContainer;
    Business business;
    Person person;

    public UpdatePersonJPanel(JPanel UserProcessContainer, Business business, Person person) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.business = business;
        this.person = person;
        populateUpdatePersonPanel();
    }

    public void populateUpdatePersonPanel() {
        firstnameField.setText(person.getFirstName());
        lastnameField.setText(person.getLastName());
        dobChooser.setDate(person.getDateOfBirth());
        dobChooser.setMaxSelectableDate(new Date(System.currentTimeMillis()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newPersonHeader = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lastnameField = new javax.swing.JTextField();
        updatePersonBtn = new javax.swing.JButton();
        cancelPersonBtn = new javax.swing.JButton();
        firstnameField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dobChooser = new com.toedter.calendar.JDateChooser();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newPersonHeader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        newPersonHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newPersonHeader.setText("Update Person");
        add(newPersonHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 760, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("First name : ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Last name : ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 200, 30));
        add(lastnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 230, 30));

        updatePersonBtn.setBackground(new java.awt.Color(0, 153, 153));
        updatePersonBtn.setText("Update");
        updatePersonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePersonBtnActionPerformed(evt);
            }
        });
        add(updatePersonBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 120, 30));

        cancelPersonBtn.setBackground(new java.awt.Color(0, 153, 153));
        cancelPersonBtn.setText("<< Cancel");
        cancelPersonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPersonBtnActionPerformed(evt);
            }
        });
        add(cancelPersonBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 110, 30));
        add(firstnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 230, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Date of birth : ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 200, 30));
        add(dobChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 230, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void cancelPersonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPersonBtnActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        Component[] componentArray = UserProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManagePersonDirectory managePersonDir = (ManagePersonDirectory) component;
        managePersonDir.populateManagePersonPanel();
        CardLayout cardLayout = (CardLayout) UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_cancelPersonBtnActionPerformed

    private void updatePersonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePersonBtnActionPerformed
        // TODO add your handling code here:
        String firstName = firstnameField.getText();
        String lastName = lastnameField.getText();
        Date dob = dobChooser.getDate();
        if (firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All the fields are mandatory", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDateOfBirth(dob);
        JOptionPane.showMessageDialog(null, "Person updated successfully!");
    }//GEN-LAST:event_updatePersonBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelPersonBtn;
    private com.toedter.calendar.JDateChooser dobChooser;
    private javax.swing.JTextField firstnameField;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField lastnameField;
    private javax.swing.JLabel newPersonHeader;
    private javax.swing.JButton updatePersonBtn;
    // End of variables declaration//GEN-END:variables
}
