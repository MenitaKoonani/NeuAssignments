/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PersonDirectory;

import UserInterface.UserDirectory.NewUserAccountJPanel;
import UserInterface.UserDirectory.UpdateUserAccountJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Menita Koonani
 */
public class ManagePersonDirectory extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccDirectory
     */
    JPanel UserProcessContainer;

    public ManagePersonDirectory(JPanel UserProcessContainer) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        populateManagePersonDir();
    }

    public void populateManagePersonDir() {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        manageUsersTable = new javax.swing.JTable();
        updatePersonBtn = new javax.swing.JButton();
        findPersonBtn = new javax.swing.JButton();
        newPersonBtn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        managePersonDir.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        managePersonDir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        managePersonDir.setText("Manage Person Directory");
        add(managePersonDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 760, 60));

        manageUsersTable.setBackground(new java.awt.Color(0, 153, 153));
        manageUsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person ID", "First Name", "Last Name", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(manageUsersTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 140, 600, 180));

        updatePersonBtn.setBackground(new java.awt.Color(0, 153, 153));
        updatePersonBtn.setText("Update Person");
        updatePersonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePersonBtnActionPerformed(evt);
            }
        });
        add(updatePersonBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 180, -1));

        findPersonBtn.setBackground(new java.awt.Color(0, 153, 153));
        findPersonBtn.setText("Find Person");
        add(findPersonBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 180, -1));

        newPersonBtn.setBackground(new java.awt.Color(0, 153, 153));
        newPersonBtn.setText("New Person");
        newPersonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPersonBtnActionPerformed(evt);
            }
        });
        add(newPersonBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void newPersonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPersonBtnActionPerformed
        // TODO add your handling code here:
        NewUserAccountJPanel newUserAccPanel = new NewUserAccountJPanel(UserProcessContainer);
        CardLayout cardLayout = (CardLayout) UserProcessContainer.getLayout();
        UserProcessContainer.add("NewUserAccPanel", newUserAccPanel);
        cardLayout.next(UserProcessContainer);
    }//GEN-LAST:event_newPersonBtnActionPerformed

    private void updatePersonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePersonBtnActionPerformed
        // TODO add your handling code here:
        UpdateUserAccountJPanel updateUserAccPanel = new UpdateUserAccountJPanel(UserProcessContainer);
        CardLayout cardLayout = (CardLayout) UserProcessContainer.getLayout();
        UserProcessContainer.add("UpdateUserAccountPanel", updateUserAccPanel);
        cardLayout.next(UserProcessContainer);
    }//GEN-LAST:event_updatePersonBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton findPersonBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel managePersonDir;
    private javax.swing.JTable manageUsersTable;
    private javax.swing.JButton newPersonBtn;
    private javax.swing.JButton updatePersonBtn;
    // End of variables declaration//GEN-END:variables
}