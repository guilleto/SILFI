package gui_test_1;

import Control.ValidarLogin;
import DAO.EquipoDAO;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Usuario_Equipos extends javax.swing.JFrame {

    public String user;
    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    DefaultTableModel model = new DefaultTableModel();
    Connection connection = null;
    Statement statement = null;
    EquipoDAO equipoDao = new EquipoDAO();
    String idEquipo;
    String buscar;

    public Usuario_Equipos(String user) {

        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());

        this.user = user;
        int resultSet;
        String sql = "SELECT * FROM loginapp.EQUIPO";
        jcBuscar.removeAllItems();
        this.jcBuscar.setModel(equipoDao.llenar_Busqueda());
        buscar = (String) jcBuscar.getSelectedItem();
        model.addColumn("ID");
        model.addColumn("NOMBRE");
        model.addColumn("DESCRIPCION");
        model.addColumn("ID LABORATORIO");
        jtTablaEquipos.setModel(model);
        String[] dato = new String[6];
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

    private Usuario_Equipos() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void todosElementos() {
        String sql = "SELECT * FROM loginapp.EQUIPO";
        tfEquipos.setText("");
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
                dato[4] = result.getString(5);
                model.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    public void eliminar() {
        int fila = jtTablaEquipos.getSelectedRow();
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "Dato vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            String id = jtTablaEquipos.getValueAt(fila, 0).toString();
            String sql = "DELETE FROM loginapp.EQUIPO WHERE ID_EQUIPO ='" + id + "'";

            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                statement = connection.createStatement();
                int result = statement.executeUpdate(sql);
                fila = -1;
                todosElementos();
                fila = -1;
                JOptionPane.showMessageDialog(rootPane, "Se ha eliminado el equipo: " + id + "", "Eliminar el registro", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No es posible eliminar el registro", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public void limpiarCelda(JTable jtTablaEquipos) {
        jtTablaEquipos.setValueAt("", jtTablaEquipos.getSelectedRow(), jtTablaEquipos.getSelectedColumn());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btAñadirEquipos = new javax.swing.JButton();
        btAñadir2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaEquipos = new javax.swing.JTable();
        jcBuscar = new javax.swing.JComboBox<>();
        tfEquipos = new javax.swing.JTextField();
        btLista = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        jlFondo3 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 160, 40));

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDD.png"))); // NOI18N
        btEliminar.setContentAreaFilled(false);
        btEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDDPUSH.png"))); // NOI18N
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 160, 50));

        btAñadirEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondeagregarequipo (2).png"))); // NOI18N
        btAñadirEquipos.setContentAreaFilled(false);
        btAñadirEquipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAñadirEquipos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BotondeagregarequipoPUSH.png"))); // NOI18N
        btAñadirEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadirEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 110, 140));

        btAñadir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondemantenimiento.png"))); // NOI18N
        btAñadir2.setContentAreaFilled(false);
        btAñadir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAñadir2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondemantenimientopush.png"))); // NOI18N
        btAñadir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 110, 140));

        jtTablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtTablaEquipos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 640, 330));

        jcBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jcBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 210, 30));

        tfEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(tfEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 210, 30));

        btLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondelista.png"))); // NOI18N
        btLista.setContentAreaFilled(false);
        btLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondelistapush.png"))); // NOI18N
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });
        jPanel1.add(btLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 150, 40));

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondebusqueda.png"))); // NOI18N
        btBuscar.setContentAreaFilled(false);
        btBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondebusquedapush.png"))); // NOI18N
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 50, 50));

        jlFondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adminequip.png"))); // NOI18N
        jPanel1.add(jlFondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

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
        Usuario_Menu obj = new Usuario_Menu(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btAñadir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadir2ActionPerformed
        Usuario_Mantenimiento obj = new Usuario_Mantenimiento(user);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);

        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btAñadir2ActionPerformed

    private void btAñadirEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirEquiposActionPerformed
        Usuario_AñadirEquipo obj = new Usuario_AñadirEquipo(user);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);

        this.dispose();           // TODO add your handling code here:
    }//GEN-LAST:event_btAñadirEquiposActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEditarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        int msj = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el registro?");

        if (msj == JOptionPane.YES_OPTION) {
            eliminar();
            tfEquipos.setText("");

        }
        if (msj == JOptionPane.NO_OPTION) {

            tfEquipos.setText("");

        }
        if (msj == JOptionPane.CLOSED_OPTION) {

            tfEquipos.setText("");

        }

    }//GEN-LAST:event_btEliminarActionPerformed

    private void jcBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcBuscarActionPerformed

    private void tfEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEquiposActionPerformed

    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed
        Connection connection = null;
        Statement statement = null;
        String sql = "SELECT * FROM loginapp.EQUIPO ";
        tfEquipos.setText("");
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
        }
    }//GEN-LAST:event_btListaActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        buscar = (String) jcBuscar.getSelectedItem();
        if (buscar.equals("Placa")) {
            if (tfEquipos.getText().equals(null) || tfEquipos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Placa del Equipo vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {

                Connection connection = null;
                Statement statement = null;
                String sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE Id_Equipo LIKE '%" + tfEquipos.getText() + "%'";

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
                    if (dato[0] == null) {
                        JOptionPane.showMessageDialog(rootPane, "El registro no existe ", "No se encontro el registro", JOptionPane.INFORMATION_MESSAGE);
                        tfEquipos.setText("");
                    }

                } catch (Exception e) {

                }
            }
        }
        buscar = (String) jcBuscar.getSelectedItem();
        if (buscar.equals("Nombre")) {
            if (tfEquipos.getText().equals(null) || tfEquipos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Placa del Equipo vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {

                Connection connection = null;
                Statement statement = null;
                String sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE NOMBRE_EQUIPO LIKE '%" + tfEquipos.getText() + "%'";

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
                    if (dato[0] == null) {
                        JOptionPane.showMessageDialog(rootPane, "El registro no existe ", "No se encontro el registro", JOptionPane.INFORMATION_MESSAGE);
                        tfEquipos.setText("");
                    }

                } catch (Exception e) {

                }
            }
        }
        buscar = (String) jcBuscar.getSelectedItem();
        if (buscar.equals("Descripcion")) {
            if (tfEquipos.getText().equals(null) || tfEquipos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Placa del Equipo vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {

                Connection connection = null;
                Statement statement = null;
                String sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE DESCRIPCION_EQUIPO LIKE '%" + tfEquipos.getText() + "%'";

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
                    if (dato[0] == null) {
                        JOptionPane.showMessageDialog(rootPane, "El registro no existe ", "No se encontro el registro", JOptionPane.INFORMATION_MESSAGE);
                        tfEquipos.setText("");
                    }

                } catch (Exception e) {

                }

            }
        }
        buscar = (String) jcBuscar.getSelectedItem();
        if (buscar.equals("Laboratorio")) {
            if (tfEquipos.getText().equals(null) || tfEquipos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Placa del Equipo vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {

                Connection connection = null;
                Statement statement = null;
                String sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE LABId_Lab LIKE '%" + tfEquipos.getText() + "%'";

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
                    if (dato[0] == null) {
                        JOptionPane.showMessageDialog(rootPane, "El registro no existe ", "No se encontro el registro", JOptionPane.INFORMATION_MESSAGE);
                        tfEquipos.setText("");
                    }

                } catch (Exception e) {

                }

            }
        }
        buscar = (String) jcBuscar.getSelectedItem();
        System.out.println(buscar);
        if (buscar.equals("Seleccione una opcion")) {
            JOptionPane.showMessageDialog(rootPane, "Seleccion una opcion para la busqueda ", "Campo Vacio", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Usuario_Equipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAñadir2;
    private javax.swing.JButton btAñadirEquipos;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btLista;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcBuscar;
    private javax.swing.JLabel jlFondo3;
    private javax.swing.JTable jtTablaEquipos;
    private javax.swing.JTextField tfEquipos;
    // End of variables declaration//GEN-END:variables
}
