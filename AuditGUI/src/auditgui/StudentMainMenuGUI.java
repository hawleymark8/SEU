/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auditgui;

/**
 *
 * @author Mark Hawley
 */
public class StudentMainMenuGUI extends javax.swing.JFrame {

    /**
     * Creates new form StudentMainMenuGUI
     */
    public StudentMainMenuGUI() {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        studentMenuPanel = new javax.swing.JPanel();
        studentMainMenuLabel = new javax.swing.JLabel();
        coursesTakenButton = new javax.swing.JButton();
        auditAndSchedulerButton = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studentMainMenuLabel.setText("Student Main Menu");

        coursesTakenButton.setText("Courses Taken");

        auditAndSchedulerButton.setText("Degree Audit and Scheduler");

        mainMenuButton.setText("Main Menu");

        logoutButton.setText("Logout");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentMenuPanelLayout = new javax.swing.GroupLayout(studentMenuPanel);
        studentMenuPanel.setLayout(studentMenuPanelLayout);
        studentMenuPanelLayout.setHorizontalGroup(
            studentMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentMenuPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(studentMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(studentMainMenuLabel)
                    .addComponent(coursesTakenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(auditAndSchedulerButton)
                    .addGroup(studentMenuPanelLayout.createSequentialGroup()
                        .addComponent(mainMenuButton)
                        .addGap(18, 18, 18)
                        .addComponent(logoutButton)
                        .addGap(22, 22, 22)
                        .addComponent(exitButton)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        studentMenuPanelLayout.setVerticalGroup(
            studentMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(exitButton)
                    .addComponent(mainMenuButton)
                    .addComponent(logoutButton))
                .addGap(18, 18, 18)
                .addGroup(studentMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentMenuPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(coursesTakenButton)
                        .addGap(18, 18, 18)
                        .addComponent(auditAndSchedulerButton))
                    .addComponent(studentMainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentMainMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentMainMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentMainMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentMainMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new StudentMainMenuGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton auditAndSchedulerButton;
    private javax.swing.JButton coursesTakenButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JLabel studentMainMenuLabel;
    private javax.swing.JPanel studentMenuPanel;
    // End of variables declaration//GEN-END:variables
}
