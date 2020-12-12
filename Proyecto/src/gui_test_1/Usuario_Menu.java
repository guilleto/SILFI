package gui_test_1;

import Control.ValidarLogin;
import Entidad.Usuario;
import java.awt.Color;
import java.awt.Graphics;
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
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Usuario_Menu extends javax.swing.JFrame {

    public String user;
    FondoPanel fondo = new FondoPanel();

    public Usuario_Menu(String user) {
        this.setContentPane(fondo);
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;
        setResizable(false);
        jlEquipo1.setText("<html><center> ADMINISTRACION <br> DE EQUIPOS </html>");
        jlEquipo2.setText("<html><center> ADMINISTRACION <br> DE LABORATORIOS </html>");
    }

    private Usuario_Menu() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new FondoPanel();
        btAdministrarEquipos = new javax.swing.JButton();
        btPerfil = new javax.swing.JButton();
        btAdministrarLabs = new javax.swing.JButton();
        jlEquipo1 = new javax.swing.JLabel();
        jlEquipo2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btCerrarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAdministrarEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BADE.png"))); // NOI18N
        btAdministrarEquipos.setContentAreaFilled(false);
        btAdministrarEquipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAdministrarEquipos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BADEPUSH.png"))); // NOI18N
        btAdministrarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdministrarEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(btAdministrarEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 190, 170));

        btPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BA1.1.png"))); // NOI18N
        btPerfil.setContentAreaFilled(false);
        btPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPerfil.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton de cuenta administrador prueba.png"))); // NOI18N
        btPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(btPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 330, 120));

        btAdministrarLabs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botonlabpush.png"))); // NOI18N
        btAdministrarLabs.setContentAreaFilled(false);
        btAdministrarLabs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAdministrarLabs.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/labfuncionario.png"))); // NOI18N
        btAdministrarLabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdministrarLabsActionPerformed(evt);
            }
        });
        jPanel1.add(btAdministrarLabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 190, 180));

        jlEquipo1.setFont(new java.awt.Font("Calibri", 3, 20)); // NOI18N
        jlEquipo1.setForeground(new java.awt.Color(255, 255, 255));
        jlEquipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEquipo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlEquipo1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(jlEquipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 442, 222, 48));

        jlEquipo2.setFont(new java.awt.Font("Calibri", 3, 20)); // NOI18N
        jlEquipo2.setForeground(new java.awt.Color(255, 255, 255));
        jlEquipo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEquipo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlEquipo2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(jlEquipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 442, 204, 48));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logosilfin.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 70));

        btCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BCS1.png"))); // NOI18N
        btCerrarSesion.setContentAreaFilled(false);
        btCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCerrarSesion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/BCS1PUSH.png"))); // NOI18N
        btCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 120, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SILUNAPPBACKGROUND1.png"))); // NOI18N
        jLabel2.setText("jLabel1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPerfilActionPerformed
        Usuario_Perfil_ per = new Usuario_Perfil_(user);
        per.setVisible(true);
        per.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_btPerfilActionPerformed

    private void btAdministrarLabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdministrarLabsActionPerformed
        Usuario_Labs_ labs = new Usuario_Labs_(user);

        labs.setVisible(true);
        labs.setLocationRelativeTo(null);

        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btAdministrarLabsActionPerformed

    private void btAdministrarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdministrarEquiposActionPerformed
        Usuario_Equipos_ eq = new Usuario_Equipos_(user);
        eq.setVisible(true);
        eq.setLocationRelativeTo(null);

        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btAdministrarEquiposActionPerformed

    private void btCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarSesionActionPerformed
        Login obj = new Login();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_btCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Usuario_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdministrarEquipos;
    private javax.swing.JButton btAdministrarLabs;
    private javax.swing.JButton btCerrarSesion;
    private javax.swing.JButton btPerfil;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlEquipo1;
    private javax.swing.JLabel jlEquipo2;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Images/SILUNAPPBACKGROUND1.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);

            super.paint(g);
        }
    }
}
