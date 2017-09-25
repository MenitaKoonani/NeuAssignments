/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Airplane.AirplaneCatalog;
import Airplane.ImportIntoCatalog;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Menita Koonani
 */
public class ImportCatalogJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ImportCatalogJPanel
     */
    public ImportCatalogJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uploadFileLabel = new javax.swing.JLabel();
        uploadFilePathField = new javax.swing.JTextField();
        uploadFileBtn = new javax.swing.JButton();
        addAirplaneListBtn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uploadFileLabel.setText("Upload CSV File containing Airplane Data");
        add(uploadFileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 47, -1, -1));
        add(uploadFilePathField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 185, -1));

        uploadFileBtn.setText("Browse");
        uploadFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFileBtnActionPerformed(evt);
            }
        });
        add(uploadFileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, -1, -1));

        addAirplaneListBtn.setText("Add Airplane List from File");
        addAirplaneListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAirplaneListBtnActionPerformed(evt);
            }
        });
        add(addAirplaneListBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 108, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void uploadFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFileBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int isFileChosen = fileChooser.showOpenDialog(uploadFileBtn);
        if (isFileChosen == JFileChooser.APPROVE_OPTION) {
            File chosenFile = fileChooser.getSelectedFile();
            String filePath = chosenFile.getAbsolutePath();
            uploadFilePathField.setText(filePath);
        } else {
            JOptionPane.showMessageDialog(null, "Please upload a file!");
        }
    }//GEN-LAST:event_uploadFileBtnActionPerformed

    private void addAirplaneListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAirplaneListBtnActionPerformed
        // TODO add your handling code here:
        String fileName = uploadFilePathField.getText().trim();
        if(!fileName.isEmpty())
        {
            try {
                File chosenFile = new File(fileName);
                MainJFrame.airplaneCatalog = ImportIntoCatalog.populatingAirplaneCatalog(chosenFile);
                uploadFilePathField.setText("");
            } catch (IOException ex) {
                Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ImportCatalogJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please choose a file!");
            uploadFilePathField.requestFocus();
            return;
        }
    }//GEN-LAST:event_addAirplaneListBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAirplaneListBtn;
    private javax.swing.JButton uploadFileBtn;
    private javax.swing.JLabel uploadFileLabel;
    private javax.swing.JTextField uploadFilePathField;
    // End of variables declaration//GEN-END:variables
}