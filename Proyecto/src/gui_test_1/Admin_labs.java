package gui_test_1;

import Control.ValidarLogin;
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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin_Labs extends javax.swing.JFrame {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    DefaultTableModel model = new DefaultTableModel();
    public String user;
    LaboratorioDAO labDao = new LaboratorioDAO();
    Connection connection = null;
    Statement statement = null;
    String buscar;
    public String id;
    public String oldNombre;
    public String oldDescripcion;
    public String oldEdificio;
    public String oldUsuario;

    public Admin_Labs(String user) {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;
        int resultSet;
        String sql = "SELECT * FROM loginapp.LAB";
        jcBuscar.removeAllItems();
        this.jcBuscar.setModel(labDao.llenar_Busqueda());
        buscar = (String) jcBuscar.getSelectedItem();
        model.addColumn("ID");
        model.addColumn("NOMBRE");
        model.addColumn("DESCRIPCION");
        model.addColumn("Edificio");
        model.addColumn("Usuario");
        jtTablaLab.setModel(model);
        String[] dato = new String[5];
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
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

    private Admin_Labs() {
    }

    public void todosElementos() {
        String sql = "SELECT * FROM loginapp.LAB ";
        tfLabs.setText("");
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
        int fila = jtTablaLab.getSelectedRow();
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "Dato vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            String id = jtTablaLab.getValueAt(fila, 0).toString();
            String sql = "DELETE FROM loginapp.LAB WHERE ID_LAB ='" + id + "'";

            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                statement = connection.createStatement();
                int result = statement.executeUpdate(sql);
                fila = -1;
                todosElementos();
                fila = -1;
                JOptionPane.showMessageDialog(rootPane, "Se ha eliminado el Laboratorio: " + id + "", "Eliminar el registro", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No es posible eliminar el registro", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public void actualizar() {
        int fila = jtTablaLab.getSelectedRow();
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "Dato vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            id = jtTablaLab.getValueAt(fila, 0).toString();
            oldNombre = jtTablaLab.getValueAt(fila, 1).toString();
            oldDescripcion = jtTablaLab.getValueAt(fila, 2).toString();
            oldEdificio = jtTablaLab.getValueAt(fila, 3).toString();
            oldUsuario = jtTablaLab.getValueAt(fila, 4).toString();
            System.out.println(id + oldNombre + oldDescripcion + oldEdificio + oldUsuario);
            Admin_ActualizarLaboratorios obj = new Admin_ActualizarLaboratorios(user, id, oldNombre, oldDescripcion, oldEdificio, oldUsuario);
            obj.setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btPaginaPrincipal = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btAñadir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaLab = new javax.swing.JTable();
        tfLabs = new javax.swing.JTextField();
        btLista = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        jcBuscar = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(900, 650));
        setMinimumSize(new java.awt.Dimension(900, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btPaginaPrincipal.setContentAreaFilled(false);
        btPaginaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaginaPrincipalActionPerformed(evt);
            }
        });
        jPanel1.add(btPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 50));

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDE.png"))); // NOI18N
        btEditar.setContentAreaFilled(false);
        btEditar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDEPUSH.png"))); // NOI18N
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 160, 40));

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDD.png"))); // NOI18N
        btEliminar.setContentAreaFilled(false);
        btEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDDPUSH.png"))); // NOI18N
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 160, 50));

        btAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BAL.png"))); // NOI18N
        btAñadir.setContentAreaFilled(false);
        btAñadir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BALPUSH.png"))); // NOI18N
        btAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 110, 140));

        jtTablaLab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtTablaLab.setMaximumSize(new java.awt.Dimension(300, 750));
        jtTablaLab.setMinimumSize(new java.awt.Dimension(300, 750));
        jtTablaLab.setSelectionBackground(new java.awt.Color(11, 55, 68));
        jScrollPane2.setViewportView(jtTablaLab);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 800, 260));

        tfLabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLabsActionPerformed(evt);
            }
        });
        jPanel1.add(tfLabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 210, 30));

        btLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondelista.png"))); // NOI18N
        btLista.setContentAreaFilled(false);
        btLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondelistapush.png"))); // NOI18N
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });
        jPanel1.add(btLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 150, 40));

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondebusqueda.png"))); // NOI18N
        btBuscar.setContentAreaFilled(false);
        btBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondebusquedapush.png"))); // NOI18N
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 50, 50));

        jcBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jcBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 210, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LABORATORIOS");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 170, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logolabs.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logosilfin.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SILUNAPPBACKGROUND1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

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

    private void btPaginaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaginaPrincipalActionPerformed
        Admin_Menu obj = new Admin_Menu(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btPaginaPrincipalActionPerformed

    private void btAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirActionPerformed
        Admin_AñadirLaboratorios admin = new Admin_AñadirLaboratorios(user);
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btAñadirActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        buscar = (String) jcBuscar.getSelectedItem();
        if (buscar.equals("Id")) {

            if (tfLabs.getText().equals(null) || tfLabs.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nombre del Laboratorio vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {

                String sqlBusqueda = "SELECT * FROM loginapp.LAB WHERE Id_Lab LIKE '%" + tfLabs.getText() + "%' ";

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
                        dato[4] = result.getString(5);
                        model.addRow(dato);
                    }
                    if (dato[0] == null) {
                        JOptionPane.showMessageDialog(rootPane, "El registro no existe ", "No se encontro el registro", JOptionPane.INFORMATION_MESSAGE);
                        tfLabs.setText("");

                    }
                } catch (Exception e) {
                }        // TODO add your handling code here:
            }
        }
        ///////////////////////////////////////////////////////////////////////////////
        buscar = (String) jcBuscar.getSelectedItem();
        if (buscar.equals("Nombre")) {

            if (tfLabs.getText().equals(null) || tfLabs.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nombre del Laboratorio vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {

                String sqlBusqueda = "SELECT * FROM loginapp.LAB WHERE Nombre_Lab LIKE '%" + tfLabs.getText() + "%' ";

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
                        dato[4] = result.getString(5);
                        model.addRow(dato);
                    }
                    if (dato[0] == null) {
                        JOptionPane.showMessageDialog(rootPane, "El registro no existe ", "No se encontro el registro", JOptionPane.INFORMATION_MESSAGE);
                        tfLabs.setText("");

                    }
                } catch (Exception e) {
                }        // TODO add your handling code here:
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        buscar = (String) jcBuscar.getSelectedItem();
        if (buscar.equals("Descripcion")) {

            if (tfLabs.getText().equals(null) || tfLabs.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nombre del Laboratorio vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {

                String sqlBusqueda = "SELECT * FROM loginapp.LAB WHERE DESCRIPCION_LAB LIKE '%" + tfLabs.getText() + "%' ";

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
                        dato[4] = result.getString(5);
                        model.addRow(dato);
                    }
                    if (dato[0] == null) {
                        JOptionPane.showMessageDialog(rootPane, "El registro no existe ", "No se encontro el registro", JOptionPane.INFORMATION_MESSAGE);
                        tfLabs.setText("");

                    }
                } catch (Exception e) {
                }        // TODO add your handling code here:
            }
        }
        buscar = (String) jcBuscar.getSelectedItem();
        if (buscar.equals("Edificio")) {

            if (tfLabs.getText().equals(null) || tfLabs.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nombre del Laboratorio vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {

                String sqlBusqueda = "SELECT * FROM loginapp.LAB WHERE EDIFICIOId_Edificio LIKE '%" + tfLabs.getText() + "%' ";

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
                        dato[4] = result.getString(5);
                        model.addRow(dato);
                    }
                    if (dato[0] == null) {
                        JOptionPane.showMessageDialog(rootPane, "El registro no existe ", "No se encontro el registro", JOptionPane.INFORMATION_MESSAGE);
                        tfLabs.setText("");

                    }
                } catch (Exception e) {
                }        // TODO add your handling code here:
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////
        buscar = (String) jcBuscar.getSelectedItem();
        if (buscar.equals("Usuario")) {

            if (tfLabs.getText().equals(null) || tfLabs.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Nombre del Laboratorio vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {

                String sqlBusqueda = "SELECT * FROM loginapp.LAB WHERE ADMINUSUARIOUsername LIKE '%" + tfLabs.getText() + "%' ";

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
                        dato[4] = result.getString(5);
                        model.addRow(dato);
                    }
                    if (dato[0] == null) {
                        JOptionPane.showMessageDialog(rootPane, "El registro no existe ", "No se encontro el registro", JOptionPane.INFORMATION_MESSAGE);
                        tfLabs.setText("");

                    }
                } catch (Exception e) {
                }        // TODO add your handling code here:
            }
        }
        buscar = (String) jcBuscar.getSelectedItem();
        if (buscar.equals("Seleccione una opcion")) {
            JOptionPane.showMessageDialog(rootPane, "Seleccion una opcion para la busqueda ", "Campo Vacio", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed
        Connection connection = null;
        Statement statement = null;
        String sql = "SELECT * FROM loginapp.LAB ";
        tfLabs.setText("");
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
        }          // TODO add your handling code here:
    }//GEN-LAST:event_btListaActionPerformed

    private void tfLabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLabsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLabsActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        int msj = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el registro?");

        if (msj == JOptionPane.YES_OPTION) {
            eliminar();
            tfLabs.setText("");

        }
        if (msj == JOptionPane.NO_OPTION) {

            tfLabs.setText("");

        }
        if (msj == JOptionPane.CLOSED_OPTION) {

            tfLabs.setText("");

        }

    }//GEN-LAST:event_btEliminarActionPerformed

    private void jcBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcBuscarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        actualizar();


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
            java.util.logging.Logger.getLogger(Admin_Labs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Labs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Labs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Labs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Labs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAñadir;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btLista;
    private javax.swing.JButton btPaginaPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcBuscar;
    private javax.swing.JTable jtTablaLab;
    private javax.swing.JTextField tfLabs;
    // End of variables declaration//GEN-END:variables
}
