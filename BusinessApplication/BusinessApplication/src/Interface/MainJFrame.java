/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Menita Koonani
 */
import Business.Product;
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private Product product;
    public MainJFrame() {
        initComponents();
        product=new Product();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitJPane = new javax.swing.JSplitPane();
        controlJPanel = new javax.swing.JPanel();
        createProductBtn = new javax.swing.JButton();
        viewProductBtn = new javax.swing.JButton();
        displayJPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createProductBtn.setText("Create");
        createProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProductBtnActionPerformed(evt);
            }
        });

        viewProductBtn.setText("View");
        viewProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlJPanelLayout = new javax.swing.GroupLayout(controlJPanel);
        controlJPanel.setLayout(controlJPanelLayout);
        controlJPanelLayout.setHorizontalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createProductBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewProductBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        controlJPanelLayout.setVerticalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(createProductBtn)
                .addGap(57, 57, 57)
                .addComponent(viewProductBtn)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        splitJPane.setLeftComponent(controlJPanel);

        javax.swing.GroupLayout displayJPanelLayout = new javax.swing.GroupLayout(displayJPanel);
        displayJPanel.setLayout(displayJPanelLayout);
        displayJPanelLayout.setHorizontalGroup(
            displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );
        displayJPanelLayout.setVerticalGroup(
            displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        splitJPane.setRightComponent(displayJPanel);

        getContentPane().add(splitJPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProductBtnActionPerformed
        CreateJPanel createJPanel = new CreateJPanel(product);
        splitJPane.setRightComponent(createJPanel);
        
    }//GEN-LAST:event_createProductBtnActionPerformed

    private void viewProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductBtnActionPerformed
        ViewJPanel viewJPanel = new ViewJPanel(product);
        splitJPane.setRightComponent(viewJPanel);
    }//GEN-LAST:event_viewProductBtnActionPerformed

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
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JButton createProductBtn;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JSplitPane splitJPane;
    private javax.swing.JButton viewProductBtn;
    // End of variables declaration//GEN-END:variables
}