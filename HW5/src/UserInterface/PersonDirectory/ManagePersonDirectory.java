/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PersonDirectory;

import Business.Business;
import Business.Person;
import Business.User;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Menita Koonani
 */
public class ManagePersonDirectory extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccDirectory
     */
    JPanel UserProcessContainer;
    Business business;

    public ManagePersonDirectory(JPanel UserProcessContainer, Business business) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.business = business;
        populateManagePersonPanel();
    }

    public void populateManagePersonPanel() {
        DefaultTableModel managePersonTable = (DefaultTableModel) managePersonsTable.getModel();
        managePersonTable.setRowCount(0);

        for (Person eachPerson : business.getPersonDirectory().getPersonList()) {
            Object row[] = new Object[5];

            row[0] = eachPerson;
            row[1] = eachPerson.getFirstName();
            row[2] = eachPerson.getLastName();
            if (!eachPerson.getUserList().isEmpty()) {
                for (User eachUser : eachPerson.getUserList()) {
                    row[3] = eachUser.getUsername().isEmpty() ? "---------------" : eachUser.getUsername();
                    managePersonTable.addRow(row);
                }
            } else {
                row[3] = "---------------";
                managePersonTable.addRow(row);
            }
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

        managePersonDir = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        managePersonsTable = new javax.swing.JTable();
        updatePersonBtn = new javax.swing.JButton();
        findPersonBtn = new javax.swing.JButton();
        newPersonBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        managePersonDir.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        managePersonDir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        managePersonDir.setText("Manage Person Directory");
        add(managePersonDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 760, 60));

        managePersonsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(managePersonsTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 140, 600, 180));

        updatePersonBtn.setBackground(new java.awt.Color(0, 153, 153));
        updatePersonBtn.setText("Update Person >>");
        updatePersonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePersonBtnActionPerformed(evt);
            }
        });
        add(updatePersonBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 180, -1));

        findPersonBtn.setBackground(new java.awt.Color(0, 153, 153));
        findPersonBtn.setText("Find Person >>");
        findPersonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPersonBtnActionPerformed(evt);
            }
        });
        add(findPersonBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 180, -1));

        newPersonBtn.setBackground(new java.awt.Color(0, 153, 153));
        newPersonBtn.setText("New Person >>");
        newPersonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPersonBtnActionPerformed(evt);
            }
        });
        add(newPersonBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 180, -1));

        backBtn.setBackground(new java.awt.Color(0, 153, 153));
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void newPersonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPersonBtnActionPerformed
        // TODO add your handling code here:
        NewPersonJPanel newPersonPanel = new NewPersonJPanel(UserProcessContainer, business);
        CardLayout cardLayout = (CardLayout) UserProcessContainer.getLayout();
        UserProcessContainer.add("NewPersonJPanel", newPersonPanel);
        cardLayout.next(UserProcessContainer);
    }//GEN-LAST:event_newPersonBtnActionPerformed

    private void updatePersonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePersonBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = managePersonsTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Person selectedPerson = (Person) managePersonsTable.getValueAt(selectedRow, 0);
        UpdatePersonJPanel updatePersonPanel = new UpdatePersonJPanel(UserProcessContainer, business, selectedPerson);
        CardLayout cardLayout = (CardLayout) UserProcessContainer.getLayout();
        UserProcessContainer.add("UpdatePersonPanel", updatePersonPanel);
        cardLayout.next(UserProcessContainer);
    }//GEN-LAST:event_updatePersonBtnActionPerformed

    private void findPersonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPersonBtnActionPerformed
        // TODO add your handling code here:
        FindPersonJPanel findPersonPanel = new FindPersonJPanel(UserProcessContainer, business);
        UserProcessContainer.add("FindPersonPanel", findPersonPanel);
        CardLayout cardLayout = (CardLayout) UserProcessContainer.getLayout();
        cardLayout.next(UserProcessContainer);
    }//GEN-LAST:event_findPersonBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        Component[] componentArray = UserProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PersonWorkAreaJPanel personWorkAreaPanel = (PersonWorkAreaJPanel) component;
        personWorkAreaPanel.populatePersonWorkAreaPanel();
        CardLayout cardLayout = (CardLayout) UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton findPersonBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel managePersonDir;
    private javax.swing.JTable managePersonsTable;
    private javax.swing.JButton newPersonBtn;
    private javax.swing.JButton updatePersonBtn;
    // End of variables declaration//GEN-END:variables
}
