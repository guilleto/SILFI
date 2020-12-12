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

public class Admin_Usuarios extends javax.swing.JFrame {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    DefaultTableModel model = new DefaultTableModel();
    public String user;
    Connection connection = null;
    Statement statement = null;
    public String username;
    public String pass;
    public int adminUser;
    String[] dato = new String[6];

    public Admin_Usuarios(String user) {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;

        int resultSet;
        String sql = "SELECT * FROM loginapp.USUARIO";

        model.addColumn("ID");
        model.addColumn("USUARIO");
        model.addColumn("CONTRASEÑA");

        jtTablaUser.setModel(model);
        dato = new String[4];
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);

                model.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private Admin_Usuarios() {
    }

    public void todosElementos() {
        String sql = "SELECT *  FROM loginapp.USUARIO ";
        tfUsuarios.setText("");
        dato = new String[6];

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            model.getDataVector().removeAllElements();
            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);

                model.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    public void eliminar() {
        int fila = jtTablaUser.getSelectedRow();
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "Dato vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            String username = jtTablaUser.getValueAt(fila, 1).toString();
            String sql = "DELETE FROM loginapp.USUARIO WHERE USERNAME ='" + username + "'";

            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                statement = connection.createStatement();
                int result = statement.executeUpdate(sql);
                fila = -1;
                todosElementos();
                fila = -1;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No es posible eliminar el registro", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public void actualizar() {
        int fila = jtTablaUser.getSelectedRow();
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "Dato vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            username = jtTablaUser.getValueAt(fila, 1).toString();
            pass = jtTablaUser.getValueAt(fila, 2).toString();

            String sql = "SELECT ADMINUSER  FROM loginapp.USUARIO WHERE USERNAME = '" + username + "' AND PASS ='" + pass + "'";

            Integer[] datoAdmin = new Integer[6];

            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while (result.next()) {

                    datoAdmin[0] = result.getInt(1);

                }
                adminUser = datoAdmin[0];
                System.out.println(username + pass + adminUser);
                Admin_ActualizarUsuarios obj = new Admin_ActualizarUsuarios(user, username, pass, adminUser);
                obj.setVisible(true);
            } catch (Exception e) {
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tfUsuarios = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaUser = new javax.swing.JTable();
        btAñadir = new javax.swing.JButton();
        btAñadir2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(tfUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 160, 30));

        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 50));

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDE.png"))); // NOI18N
        btEditar.setContentAreaFilled(false);
        btEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEditar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDEPUSH.png"))); // NOI18N
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 160, 40));

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDD.png"))); // NOI18N
        btEliminar.setContentAreaFilled(false);
        btEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDDPUSH.png"))); // NOI18N
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 160, 50));

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondebusqueda.png"))); // NOI18N
        btBuscar.setContentAreaFilled(false);
        btBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondebusquedapush.png"))); // NOI18N
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 50, 50));

        jtTablaUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtTablaUser.setMaximumSize(new java.awt.Dimension(300, 750));
        jtTablaUser.setMinimumSize(new java.awt.Dimension(300, 750));
        jScrollPane2.setViewportView(jtTablaUser);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 760, 240));

        btAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondeagregarusuario.png"))); // NOI18N
        btAñadir.setContentAreaFilled(false);
        btAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAñadir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondeagregarusuariopush.png"))); // NOI18N
        btAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 110, 140));

        btAñadir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondelista.png"))); // NOI18N
        btAñadir2.setContentAreaFilled(false);
        btAñadir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAñadir2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondelistapush.png"))); // NOI18N
        btAñadir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 150, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/12345.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 110, 100));

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Código de Usuario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 150, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ADMINISTRADOR DE USUARIOS");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 330, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logosilfin.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logosilfin.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SILUNAPPBACKGROUND1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Admin_Menu obj = new Admin_Menu(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if (tfUsuarios.getText().equals(null) || tfUsuarios.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Username vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {

            Connection connection = null;
            Statement statement = null;
            String sqlBusqueda = "SELECT * FROM loginapp.USUARIO WHERE Username LIKE '%" + tfUsuarios.getText() + "%' ";

            String[] dato = new String[6];

            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sqlBusqueda);
                model.getDataVector().removeAllElements();

                while (result.next()) {
                    dato[0] = result.getString(1);
                    dato[1] = result.getString(2);
                    dato[2] = result.getString(3);
                    dato[3] = result.getString(4);

                    model.addRow(dato);
                }

            } catch (Exception e) {

            }        // TODO add your handling code here:
        }             // TODO add your handling code here:
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirActionPerformed
        Admin_AñadirUsuarios obj = new Admin_AñadirUsuarios(user);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btAñadirActionPerformed

    private void btAñadir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadir2ActionPerformed
        Connection connection = null;
        Statement statement = null;
        String sql = "SELECT * FROM loginapp.USUARIO";
        tfUsuarios.setText("");
        String[] dato = new String[6];

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            model.getDataVector().removeAllElements();
            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);

                model.addRow(dato);
            }
        } catch (Exception e) {
        }          // TODO add your handling code here:
    }//GEN-LAST:event_btAñadir2ActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
 int msj = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el registro?");

        if (msj == JOptionPane.YES_OPTION) {
            eliminar();
            tfUsuarios.setText("");

        }
        if (msj == JOptionPane.NO_OPTION) {

            tfUsuarios.setText("");

        }
        if (msj == JOptionPane.CLOSED_OPTION) {

            tfUsuarios.setText("");

        }               // TODO add your handling code here:
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        actualizar();        // TODO add your handling code here:
    }//GEN-LAST:event_btEditarActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Admin_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAñadir;
    private javax.swing.JButton btAñadir2;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable jtTablaUser;
    private javax.swing.JTextField tfUsuarios;
    // End of variables declaration//GEN-END:variables
}
