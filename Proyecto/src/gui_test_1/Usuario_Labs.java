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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuario_Labs extends javax.swing.JFrame {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    DefaultTableModel model = new DefaultTableModel();

    Connection connection = null;
    Statement statement = null;
    public String user;
    LaboratorioDAO labDao = new LaboratorioDAO();
    String buscar;

    public Usuario_Labs(String user) {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;

        int resultSet;
        jcBuscar.removeAllItems();
        this.jcBuscar.setModel(labDao.llenar_Busqueda());
        buscar = (String) jcBuscar.getSelectedItem();
        String sql = "SELECT * FROM loginapp.LAB WHERE ADMINUSUARIOUsername = '" + user + "'";
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

    private Usuario_Labs() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btPaginaPrincipal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaLab = new javax.swing.JTable();
        jcBuscar = new javax.swing.JComboBox<>();
        tfLabs = new javax.swing.JTextField();
        btLista = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        jlFondo2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(900, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btPaginaPrincipal.setContentAreaFilled(false);
        btPaginaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPaginaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaginaPrincipalActionPerformed(evt);
            }
        });
        jPanel1.add(btPaginaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 50));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 800, 250));

        jcBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jcBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 210, 30));

        tfLabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLabsActionPerformed(evt);
            }
        });
        jPanel1.add(tfLabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 210, 30));

        btLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondelista.png"))); // NOI18N
        btLista.setContentAreaFilled(false);
        btLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondelistapush.png"))); // NOI18N
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });
        jPanel1.add(btLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 150, 40));

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondebusqueda.png"))); // NOI18N
        btBuscar.setContentAreaFilled(false);
        btBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondebusquedapush.png"))); // NOI18N
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 50, 50));

        jlFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pestañalab.png"))); // NOI18N
        jlFondo2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jlFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPaginaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaginaPrincipalActionPerformed
        Usuario_Menu obj = new Usuario_Menu(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btPaginaPrincipalActionPerformed

    private void jcBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcBuscarActionPerformed

    private void tfLabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLabsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLabsActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario_Labs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario_Labs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario_Labs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario_Labs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Usuario_Labs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btLista;
    private javax.swing.JButton btPaginaPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcBuscar;
    private javax.swing.JLabel jlFondo2;
    private javax.swing.JTable jtTablaLab;
    private javax.swing.JTextField tfLabs;
    // End of variables declaration//GEN-END:variables
}
