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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin_ActualizarLaboratorios extends javax.swing.JFrame {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com:3306/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    public String user;
    public String id;
    public String oldNombre;
    public String oldDescripcion;
    public String oldEdificio;
    public String oldUsuario;
    public String edificio;
    public String usuario;
    UsuarioDAO usuarioDao = new UsuarioDAO();
    Connection connection = null;
    Statement statement = null;

    public Admin_ActualizarLaboratorios(String user, String id, String oldNombre, String oldDescripcion, String oldEdificio, String oldUsuario) {

        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;
        this.id = id;
        this.oldNombre = oldNombre;
        this.oldDescripcion = oldDescripcion;
        this.oldEdificio = oldEdificio;
        this.oldUsuario = oldUsuario;
        jcUsuarios.removeAllItems();

        jcEdificios.removeAllItems();
        this.jcEdificios.setModel(usuarioDao.llenar_ComboEdificio());
        tfId_Lab.setText(id);
        tfNombre_Lab.setText(oldNombre);
        tf_Descripcion.setText(oldDescripcion);
        System.out.println(usuario);

        this.jcUsuarios.setModel(usuarioDao.llenar_ComboActualizar(oldUsuario));
        this.jcEdificios.setModel(usuarioDao.llenar_ComboEdificioActualizar(oldEdificio));

    }

    private Admin_ActualizarLaboratorios() {

    }

    private boolean verificarLongitudNombre(String nombreLab) {
        return (nombreLab.length() > 1 && nombreLab.length() <= 50);
    }

    private boolean verificarLongitudDescripcion(String descripcion_Equipo) {
        return (descripcion_Equipo.length() > 3 && descripcion_Equipo.length() <= 255);
    }

    public void confirmar() {

        int msj = JOptionPane.showConfirmDialog(null, "¿Esta seguro de actualizar el registro?");

        if (msj == JOptionPane.YES_OPTION) {
            actualizar();

        }
        if (msj == JOptionPane.NO_OPTION) {

        }
        if (msj == JOptionPane.CLOSED_OPTION) {

        }
    }

    public void actualizar() {
        edificio = (String) jcEdificios.getSelectedItem();
        usuario = (String) jcUsuarios.getSelectedItem();
        System.out.println(edificio + usuario);
        int resultSet;
        String sql = "UPDATE LAB "
                + " SET ID_LAB = '" + id + "' , "
                + " NOMBRE_LAB = '" + tfNombre_Lab.getText() + "' , "
                + " DESCRIPCION_LAB = '" + tf_Descripcion.getText() + "' , "
                + " EDIFICIOId_Edificio = '" + edificio + "' , "
                + " USUARIOUsername = '" + usuario
                + "' WHERE ID_LAB = '" + id
                + "' AND NOMBRE_LAB = '" + oldNombre
                + "' AND DESCRIPCION_LAB = '" + oldDescripcion
                + "' AND EDIFICIOId_Edificio = '" + oldEdificio
                + "' AND USUARIOUsername= '" + oldUsuario
                + "' ;";

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            int result = statement.executeUpdate(sql);

            JOptionPane.showMessageDialog(rootPane, "Se ha actualizado el Laboratorio: " + id + "", "Actualizacion del registro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No es posible actualizar el registro" , "Error al Actualizar", JOptionPane.ERROR_MESSAGE);
        }

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
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlFondo2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 750));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 750));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 750));
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
        jPanel1.add(btAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 640, 50, 50));

        btPaginaPrincipal.setContentAreaFilled(false);
        btPaginaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPaginaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaginaPrincipalActionPerformed(evt);
            }
        });
        jPanel1.add(btPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 50));

        tfId_Lab.setEditable(false);
        jPanel1.add(tfId_Lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 160, 30));
        jPanel1.add(tf_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 250, 30));
        jPanel1.add(tfNombre_Lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 250, 30));

        jcUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(jcUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 250, 30));

        jcEdificios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEdificiosActionPerformed(evt);
            }
        });
        jPanel1.add(jcEdificios, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 250, 30));

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID LABORATORIO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 160, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BAL.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre del Laboratorio ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 250, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Descripcion");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 250, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Codigo Equipo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 250, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 250, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ACTUALIZAR LABORATORIO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 280, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logosilfin.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 70));

        jlFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mini no tan mini.png"))); // NOI18N
        jPanel1.add(jlFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 750));

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

        usuario = (String) jcUsuarios.getSelectedItem();
        edificio = (String) jcEdificios.getSelectedItem();

        if (!verificarLongitudNombre(tfNombre_Lab.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Longitud id incorrecta", "Laboratorio Invalido", JOptionPane.ERROR_MESSAGE);
        }
        if (!verificarLongitudDescripcion(tf_Descripcion.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Longitud descripcion incorrecta", "Laboratorio Invalido", JOptionPane.ERROR_MESSAGE);

        } else {
            confirmar();
            Admin_Labs obj = new Admin_Labs(user);
            obj.setVisible(true);
            this.dispose();
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
            java.util.logging.Logger.getLogger(Admin_ActualizarLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_ActualizarLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_ActualizarLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_ActualizarLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_ActualizarLaboratorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAñadir;
    private javax.swing.JButton btPaginaPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcEdificios;
    private javax.swing.JComboBox<String> jcUsuarios;
    private javax.swing.JLabel jlFondo2;
    private javax.swing.JTextField tfId_Lab;
    private javax.swing.JTextField tfNombre_Lab;
    private javax.swing.JTextField tf_Descripcion;
    // End of variables declaration//GEN-END:variables
}
