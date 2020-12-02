package gui_test_1;

import Control.ValidarLaboratorio;
import Control.ValidarLogin;
import DAO.EquipoDAO;
import DAO.UsuarioDAO;
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

public class Admin_AñadirLaboratorios extends javax.swing.JFrame {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com:3306/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    public String user;
    UsuarioDAO usuarioDao = new UsuarioDAO();

    public Admin_AñadirLaboratorios(String user) {

        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;
        jcUsuarios.removeAllItems();
        this.jcUsuarios.setModel(usuarioDao.llenar_Combo());
        jcEdificios.removeAllItems();
        this.jcEdificios.setModel(usuarioDao.llenar_ComboEdificio());
    }

    private Admin_AñadirLaboratorios() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btAñadir = new javax.swing.JButton();
        btPaginaPrincipal = new javax.swing.JButton();
        tfId_Lab = new javax.swing.JTextField();
        tf_Descripcion = new javax.swing.JTextField();
        tfNombre_Lab = new javax.swing.JTextField();
        jcUsuarios = new javax.swing.JComboBox<>();
        jcEdificios = new javax.swing.JComboBox<>();
        jlFondo3 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login.png"))); // NOI18N
        btAñadir.setBorder(null);
        btAñadir.setContentAreaFilled(false);
        btAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAñadir.setPreferredSize(new java.awt.Dimension(50, 50));
        btAñadir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login push.png"))); // NOI18N
        btAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, 50, 50));

        btPaginaPrincipal.setContentAreaFilled(false);
        btPaginaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPaginaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaginaPrincipalActionPerformed(evt);
            }
        });
        jPanel1.add(btPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 50));
        jPanel1.add(tfId_Lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 160, 30));
        jPanel1.add(tf_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 250, 30));
        jPanel1.add(tfNombre_Lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 250, 30));

        jcUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(jcUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 250, 30));

        jcEdificios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEdificiosActionPerformed(evt);
            }
        });
        jPanel1.add(jcEdificios, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 250, 30));

        jlFondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/añadirlab.png"))); // NOI18N
        jPanel1.add(jlFondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirActionPerformed
        String Retorno = null;

        String id = tfId_Lab.getText();
        String nombre = tfNombre_Lab.getText();
        String descripcion = tf_Descripcion.getText();
        String usuario = (String) jcUsuarios.getSelectedItem();
        String edificio = (String) jcEdificios.getSelectedItem();
        ValidarLaboratorio validar = new ValidarLaboratorio();
        Retorno = validar.verificarLab(id, nombre, descripcion, edificio, usuario);
        if (usuario.equals("Seleccione Usuario")) {
            JOptionPane.showMessageDialog(rootPane, "Username Vacio", "Usuario Invalido", JOptionPane.ERROR_MESSAGE);
        }
        else if (edificio.equals("Seleccione Edificio")) {
            JOptionPane.showMessageDialog(rootPane, "Edificio Vacio", "Edificio Invalido", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Retorno.equals("Laboratorio Invalido")) {
                JOptionPane.showMessageDialog(rootPane, "Usuario Invalido", "Usuario Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud id incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud id incorrecta", "Laboratorio Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud nombre incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud nombre incorrecta", "Laboratorio Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud descripcion incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud descripcion incorrecta", "Laboratorio Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud usuario incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud Usuario incorrecta", "Laboratorio Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud id edificio incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud Id Edificio incorrecta", "Laboratorio Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Laboratorio Registrado")) {
                JOptionPane.showMessageDialog(null, "Laboratorio Registrado Exitosamente");
                Admin_Labs obj = new Admin_Labs(user);
                obj.setVisible(true);
                this.dispose();
            }
//        tfId_Lab.setText("");
//        tfNombre_Lab.setText("");
//        tf_Descripcion.setText("");
//        tf_IdEdificio.setText("");
//        tfUsuario.setText("");
        }
    }//GEN-LAST:event_btAñadirActionPerformed

    private void btPaginaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaginaPrincipalActionPerformed
        Admin_Labs obj = new Admin_Labs(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btPaginaPrincipalActionPerformed

    private void jcUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcUsuariosActionPerformed

    private void jcEdificiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEdificiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcEdificiosActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_AñadirLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_AñadirLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_AñadirLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_AñadirLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_AñadirLaboratorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAñadir;
    private javax.swing.JButton btPaginaPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcEdificios;
    private javax.swing.JComboBox<String> jcUsuarios;
    private javax.swing.JLabel jlFondo3;
    private javax.swing.JTextField tfId_Lab;
    private javax.swing.JTextField tfNombre_Lab;
    private javax.swing.JTextField tf_Descripcion;
    // End of variables declaration//GEN-END:variables
}
