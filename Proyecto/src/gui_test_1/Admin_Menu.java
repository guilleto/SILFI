package gui_test_1;

import Control.ValidarLogin;
import Entidad.Usuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin_Menu extends javax.swing.JFrame {
    
    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com:3306/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    
    public String user;
    
    public Admin_Menu(String user) {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;
      
        
    }
    
    private Admin_Menu() {
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btAdministrarLabs = new javax.swing.JButton();
        btGuiaDeUso = new javax.swing.JButton();
        btCuenta = new javax.swing.JButton();
        btRegistroActividades = new javax.swing.JButton();
        btAdministrarUsuarios = new javax.swing.JButton();
        btCerrarSesion = new javax.swing.JButton();
        jlFondo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 650));
        setMinimumSize(new java.awt.Dimension(900, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 650));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BADE.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BADEPUSH.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 190, 170));

        btAdministrarLabs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BL.png"))); // NOI18N
        btAdministrarLabs.setContentAreaFilled(false);
        btAdministrarLabs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAdministrarLabs.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BLPUSH.png"))); // NOI18N
        btAdministrarLabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdministrarLabsActionPerformed(evt);
            }
        });
        jPanel1.add(btAdministrarLabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 170, 180));

        btGuiaDeUso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BHI.png"))); // NOI18N
        btGuiaDeUso.setContentAreaFilled(false);
        btGuiaDeUso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btGuiaDeUso.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BHIPUSH.png"))); // NOI18N
        btGuiaDeUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuiaDeUsoActionPerformed(evt);
            }
        });
        jPanel1.add(btGuiaDeUso, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 180, 110, 90));

        btCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BA1.1.png"))); // NOI18N
        btCuenta.setContentAreaFilled(false);
        btCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCuenta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton de cuenta administrador prueba.png"))); // NOI18N
        btCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 330, 120));

        btRegistroActividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BG.png"))); // NOI18N
        btRegistroActividades.setContentAreaFilled(false);
        btRegistroActividades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btRegistroActividades.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BGPUSH.png"))); // NOI18N
        jPanel1.add(btRegistroActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, 100, 90));

        btAdministrarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BAU.png"))); // NOI18N
        btAdministrarUsuarios.setContentAreaFilled(false);
        btAdministrarUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAdministrarUsuarios.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BAUPUSH.png"))); // NOI18N
        btAdministrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdministrarUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btAdministrarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 100, 100));

        btCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BCS1.png"))); // NOI18N
        btCerrarSesion.setContentAreaFilled(false);
        btCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCerrarSesion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BCS1PUSH.png"))); // NOI18N
        btCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 120, 40));

        jlFondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/silunapp123.png"))); // NOI18N
        jPanel1.add(jlFondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuiaDeUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuiaDeUsoActionPerformed
        Guia g = new Guia(user);
        g.setVisible(true);
        g.setLocationRelativeTo(null);
        
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btGuiaDeUsoActionPerformed

    private void btCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarSesionActionPerformed
        Login obj = new Login();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_btCerrarSesionActionPerformed

    private void btAdministrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdministrarUsuariosActionPerformed
        Admin_Usuarios user1 = new Admin_Usuarios(user);
        user1.setVisible(true);
        user1.setLocationRelativeTo(null);
        
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btAdministrarUsuariosActionPerformed

    private void btAdministrarLabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdministrarLabsActionPerformed
        Admin_Labs ab = new Admin_Labs(user);
        ab.setVisible(true);
        ab.setLocationRelativeTo(null);
        
        this.dispose();
    }//GEN-LAST:event_btAdministrarLabsActionPerformed

    private void btCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCuentaActionPerformed
        Admin_Perfil obj = new Admin_Perfil(user);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        
        this.dispose();        
    }//GEN-LAST:event_btCuentaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Admin_Equipos obj = new Admin_Equipos(user);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        
        this.dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdministrarLabs;
    private javax.swing.JButton btAdministrarUsuarios;
    private javax.swing.JButton btCerrarSesion;
    private javax.swing.JButton btCuenta;
    private javax.swing.JButton btGuiaDeUso;
    private javax.swing.JButton btRegistroActividades;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlFondo3;
    // End of variables declaration//GEN-END:variables
}
