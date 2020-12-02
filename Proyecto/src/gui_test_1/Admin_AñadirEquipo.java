package gui_test_1;

import Control.ValidarEquipo;
import Control.ValidarLogin;
import DAO.EquipoDAO;
import DAO.LaboratorioDAO;
import Entidad.Usuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin_AñadirEquipo extends javax.swing.JFrame {

    public String user;
    Connection connection = null;
    Statement statement = null;
    LaboratorioDAO daoLab = new LaboratorioDAO();

    public Admin_AñadirEquipo(String user) {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;
        jcLaboratorios.removeAllItems();
        this.jcLaboratorios.setModel(daoLab.llenar_Combo());
    }

    private Admin_AñadirEquipo() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btAñadir = new javax.swing.JButton();
        btAtras = new javax.swing.JButton();
        tfId_Equipo = new javax.swing.JTextField();
        tfNombre_Equipo = new javax.swing.JTextField();
        tf_Descripcion = new javax.swing.JTextField();
        jcLaboratorios = new javax.swing.JComboBox<>();
        jlFondo1 = new javax.swing.JLabel();

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
        jPanel1.add(btAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 50, 50));

        btAtras.setContentAreaFilled(false);
        btAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 50));
        jPanel1.add(tfId_Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 170, 30));
        jPanel1.add(tfNombre_Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 290, 30));
        jPanel1.add(tf_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 290, 30));

        jcLaboratorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcLaboratoriosActionPerformed(evt);
            }
        });
        jPanel1.add(jcLaboratorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 290, 30));

        jlFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/añadirequipo.png"))); // NOI18N
        jPanel1.add(jlFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 650));

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
        String id = tfId_Equipo.getText();
        String nombre = tfNombre_Equipo.getText();
        String descripcion = tf_Descripcion.getText();

        String lab = (String) jcLaboratorios.getSelectedItem();
        //System.out.println(lab);
        String Retorno = null;
        ValidarEquipo validar = new ValidarEquipo();
        Retorno = validar.verificarEquipo(id, nombre, descripcion, lab);
        if (lab.equals("Seleccione la id del Laboratorio")) {
            JOptionPane.showMessageDialog(rootPane, "Laboratorio Vacio", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Retorno.equals("Equipo Invalido")) {
                JOptionPane.showMessageDialog(rootPane, "Equipo Invalido", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud id incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud id incorrecta", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud nombre incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud nombre incorrecta", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud descripcion incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud Descripcion incorrecta", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Equipo Registrado")) {
                JOptionPane.showMessageDialog(null, "Equipo Registrado Exitosamente");
                Admin_Equipos obj = new Admin_Equipos(user);
                obj.setVisible(true);
                this.dispose();
            }
//        tfId_Equipo.setText("");
//        tfNombre_Equipo.setText("");
//        tf_Descripcion.setText("");

        }

    }//GEN-LAST:event_btAñadirActionPerformed

    private void btAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtrasActionPerformed
        Admin_Equipos obj = new Admin_Equipos(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btAtrasActionPerformed

    private void jcLaboratoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcLaboratoriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcLaboratoriosActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_AñadirEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_AñadirEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_AñadirEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_AñadirEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Admin_AñadirEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtras;
    private javax.swing.JButton btAñadir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcLaboratorios;
    private javax.swing.JLabel jlFondo1;
    private javax.swing.JTextField tfId_Equipo;
    private javax.swing.JTextField tfNombre_Equipo;
    private javax.swing.JTextField tf_Descripcion;
    // End of variables declaration//GEN-END:variables
}
