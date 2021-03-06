/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.VitalSignHistory;
import Business.VitalSigns;
import javax.swing.JOptionPane;

/**
 *
 * @author Menita Koonani
 */
public class CreateVitalSignPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateVitalSignPanel
     */
    private VitalSignHistory vitalSignHistory;

    public CreateVitalSignPanel(VitalSignHistory newVitalSignHistory) {
        initComponents();
        this.vitalSignHistory = newVitalSignHistory;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createPanelHeader = new javax.swing.JLabel();
        tempLabel = new javax.swing.JLabel();
        BPLabel = new javax.swing.JLabel();
        pulseLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        tempField = new javax.swing.JTextField();
        BPField = new javax.swing.JTextField();
        pulseField = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        createVitalSignBtn = new javax.swing.JButton();

        createPanelHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        createPanelHeader.setText("Create Vital Sign");

        tempLabel.setText("Temperature");

        BPLabel.setText("Blood Pressure");

        pulseLabel.setText("Pulse");

        dateLabel.setText("Date");

        createVitalSignBtn.setText("Create Vital Sign");
        createVitalSignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createVitalSignBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createVitalSignBtn)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tempLabel)
                            .addComponent(BPLabel)
                            .addComponent(pulseLabel)
                            .addComponent(dateLabel))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pulseField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BPField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tempField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(createPanelHeader)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(createPanelHeader)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempLabel)
                    .addComponent(tempField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BPLabel)
                    .addComponent(BPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pulseLabel)
                    .addComponent(pulseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createVitalSignBtn)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createVitalSignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createVitalSignBtnActionPerformed
        // TODO add your handling code here:

        double temp = Double.parseDouble(tempField.getText());
        double bp = Double.parseDouble(BPField.getText());
        int pulse = Integer.parseInt(pulseField.getText());
        String date = dateField.getText();

        VitalSigns vitalSigns = vitalSignHistory.addVitals();
        vitalSigns.setBloodPressure(bp);
        vitalSigns.setTemperatue(temp);
        vitalSigns.setPulse(pulse);
        vitalSigns.setDate(date);

        JOptionPane.showMessageDialog(null, "Successfully added vital signs!!");

        // to reset the text fields for the next entry
        tempField.setText("");
        BPField.setText("");
        pulseField.setText("");
        dateField.setText("");

    }//GEN-LAST:event_createVitalSignBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BPField;
    private javax.swing.JLabel BPLabel;
    private javax.swing.JLabel createPanelHeader;
    private javax.swing.JButton createVitalSignBtn;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField pulseField;
    private javax.swing.JLabel pulseLabel;
    private javax.swing.JTextField tempField;
    private javax.swing.JLabel tempLabel;
    // End of variables declaration//GEN-END:variables
}
