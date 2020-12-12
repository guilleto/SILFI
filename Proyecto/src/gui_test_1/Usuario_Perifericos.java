package gui_test_1;

import DAO.EquipoDAO;
import DAO.PerifericoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuario_Perifericos extends javax.swing.JFrame {

    public String user;
    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel CBbuscar = new DefaultComboBoxModel();
    Connection connection = null;
    Statement statement = null;
    PerifericoDAO perifericoDao = new PerifericoDAO();
    String idPeriferico;
    String buscar;
    String sqlBusqueda;
    public String id;
    public String oldNombre;
    public String oldDescripcion;
    public String oldEquipo;
    public String oldEstado;
    public String oldDescripcionEstado;
    String[] dato = new String[10];

    public Usuario_Perifericos(String user, String oldEquipo) {

        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());

        this.user = user;
        this.oldEquipo = oldEquipo;

        this.oldDescripcionEstado = oldDescripcionEstado;
        int resultSet;
        jcBuscar.removeAllItems();
        this.jcBuscar.setModel(perifericoDao.llenar_BusquedaPeriferico());
        buscar = (String) jcBuscar.getSelectedItem();

        model.addColumn("ID");
        model.addColumn("NOMBRE");
        model.addColumn("DESCRIPCION");
        model.addColumn("EQUIPO");
        model.addColumn("ESTADO");
        model.addColumn("DESCRIPCION ESTADO");
        jtTablaPeriferico.setModel(model);
        String sql = "SELECT * FROM loginapp.PERIFERICO WHERE EQUIPOID_EQUIPO  = '" + oldEquipo + "'";

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
                dato[5] = result.getString(6);
                model.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private Usuario_Perifericos() {
        initComponents();

    }

    public void todosElementos() {

        String sql = "SELECT * FROM loginapp.PERIFERICO ";
        tfPerifericos.setText("");

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
                dato[5] = result.getString(6);
                model.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    public void eliminar() {
        int fila = jtTablaPeriferico.getSelectedRow();
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "Dato vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            idPeriferico = jtTablaPeriferico.getValueAt(fila, 0).toString();
            String sql = "DELETE FROM loginapp.PERIFERICO WHERE ID_PERIFERICO ='" + idPeriferico + "'";

            try {
                idPeriferico = jtTablaPeriferico.getValueAt(fila, 0).toString();
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                statement = connection.createStatement();
                int result = statement.executeUpdate(sql);
                fila = -1;
                todosElementos();
                fila = -1;
                JOptionPane.showMessageDialog(rootPane, "Se ha eliminado el Periferico: " + idPeriferico + "", "Eliminar el registro", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No es posible eliminar el registro", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public void actualizar() {
        int fila = jtTablaPeriferico.getSelectedRow();
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "No se selecciono un periferico", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            id = jtTablaPeriferico.getValueAt(fila, 0).toString();
            oldNombre = jtTablaPeriferico.getValueAt(fila, 1).toString();
            oldDescripcion = jtTablaPeriferico.getValueAt(fila, 2).toString();
            oldEquipo = jtTablaPeriferico.getValueAt(fila, 3).toString();

            Usuario_ActualizarPeriferico obj = new Usuario_ActualizarPeriferico(user, id, oldNombre, oldDescripcion, oldEquipo);
            obj.setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tfPerifericos = new javax.swing.JTextField();
        btHome = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btMantenimiento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaPeriferico = new javax.swing.JTable();
        btLista = new javax.swing.JButton();
        jcBuscar = new javax.swing.JComboBox<>();
        btBuscar = new javax.swing.JButton();
        btAñadirPeriferico = new javax.swing.JButton();
        btEstado = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPerifericos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPerifericosActionPerformed(evt);
            }
        });
        jPanel1.add(tfPerifericos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 210, 30));

        btHome.setContentAreaFilled(false);
        btHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 50));

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDE.png"))); // NOI18N
        btEditar.setContentAreaFilled(false);
        btEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEditar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDEPUSH.png"))); // NOI18N
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 160, 40));

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDD.png"))); // NOI18N
        btEliminar.setContentAreaFilled(false);
        btEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BDDPUSH.png"))); // NOI18N
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 160, 50));

        btMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondemantenimiento.png"))); // NOI18N
        btMantenimiento.setContentAreaFilled(false);
        btMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMantenimiento.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondemantenimientopush.png"))); // NOI18N
        btMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMantenimientoActionPerformed(evt);
            }
        });
        jPanel1.add(btMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 110, 140));

        jtTablaPeriferico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtTablaPeriferico);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 640, 310));

        btLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondelista.png"))); // NOI18N
        btLista.setContentAreaFilled(false);
        btLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondelistapush.png"))); // NOI18N
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });
        jPanel1.add(btLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 150, 40));

        jcBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jcBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 210, 30));

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondebusqueda.png"))); // NOI18N
        btBuscar.setContentAreaFilled(false);
        btBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondebusquedapush.png"))); // NOI18N
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 50, 50));

        btAñadirPeriferico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo peri.png"))); // NOI18N
        btAñadirPeriferico.setContentAreaFilled(false);
        btAñadirPeriferico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAñadirPeriferico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirPerifericoActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadirPeriferico, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 120, 140));

        btEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boton de estado.png"))); // NOI18N
        btEstado.setContentAreaFilled(false);
        btEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEstado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boton de estado push.png"))); // NOI18N
        btEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(btEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 160, 50));

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMINISTRACIÓN DE PERIFÉRICOS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 40, 350, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logosilfin.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 70));

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

    private void btHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHomeActionPerformed
        Usuario_Menu obj = new Usuario_Menu(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btHomeActionPerformed

    private void btMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMantenimientoActionPerformed
        Usuario_Mantenimiento_ obj = new Usuario_Mantenimiento_(user);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);

        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btMantenimientoActionPerformed

    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed

        String sql = "SELECT * FROM loginapp.PERIFERICO WHERE EQUIPOID_EQUIPO  = '" + oldEquipo + "'";
        tfPerifericos.setText("");

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
                dato[5] = result.getString(6);
                model.addRow(dato);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btListaActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        int fila = jtTablaPeriferico.getSelectedRow();

        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "No se selecciono un Periferico", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            int msj = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el registro?");

            if (msj == JOptionPane.YES_OPTION) {
                eliminar();
                tfPerifericos.setText("");

            }
            if (msj == JOptionPane.NO_OPTION) {

                tfPerifericos.setText("");

            }
            if (msj == JOptionPane.CLOSED_OPTION) {

                tfPerifericos.setText("");

            }
        }

    }//GEN-LAST:event_btEliminarActionPerformed

    private void jcBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcBuscarActionPerformed

    private void tfPerifericosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPerifericosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPerifericosActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        actualizar();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        buscar = (String) jcBuscar.getSelectedItem();
        Connection connection = null;
        Statement statement = null;
        if (buscar.equals("Seleccione una opcion")) {
            JOptionPane.showMessageDialog(rootPane, "Seleccion una opcion para la busqueda ", "Campo Vacio", JOptionPane.ERROR_MESSAGE);
        } else {
            if (tfPerifericos.getText().equals(null) || tfPerifericos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Campo de busqueda vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {
                if (buscar.equals("Id")) {
                    sqlBusqueda = "SELECT * FROM loginapp.PERIFERICO WHERE EQUIPOID_EQUIPO  = '" + oldEquipo + "' AND Id_Periferico LIKE '%" + tfPerifericos.getText() + "%'";
                }
                if (buscar.equals("Nombre")) {
                    sqlBusqueda = "SELECT * FROM loginapp.PERIFERICO WHERE EQUIPOID_EQUIPO  = '" + oldEquipo + "' AND Nombre_Periferico LIKE '%" + tfPerifericos.getText() + "%'";
                }
                if (buscar.equals("Descripcion")) {
                    sqlBusqueda = "SELECT * FROM loginapp.PERIFERICO WHERE EQUIPOID_EQUIPO  = '" + oldEquipo + "' AND DESCRIPCION LIKE '%" + tfPerifericos.getText() + "%'";
                }
                if (buscar.equals("Equipo")) {
                    sqlBusqueda = "SELECT * FROM loginapp.PERIFERICO WHERE EQUIPOID_EQUIPO  = '" + oldEquipo + "' AND EQUIPOID_EQUIPO LIKE '%" + tfPerifericos.getText() + "%'";
                }
                if (buscar.equals("Estado")) {
                    sqlBusqueda = "SELECT * FROM loginapp.PERIFERICO WHERE EQUIPOID_EQUIPO  = '" + oldEquipo + "' AND ESTADO = '" + tfPerifericos.getText() + "'";
                }
                if (buscar.equals("Descripcion Estado")) {
                    sqlBusqueda = "SELECT * FROM loginapp.PERIFERICO WHERE EQUIPOID_EQUIPO  = '" + oldEquipo + "' AND DESCRIPCION_ESTADO LIKE '%" + tfPerifericos.getText() + "%'";
                }
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
                        dato[5] = result.getString(6);
                        model.addRow(dato);
                    }
                    if (dato[0] == null) {
                        JOptionPane.showMessageDialog(rootPane, "El registro no existe ", "No se encontro el registro", JOptionPane.INFORMATION_MESSAGE);
                        tfPerifericos.setText("");
                    }
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEstadoActionPerformed
        int fila = jtTablaPeriferico.getSelectedRow();

        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "No se selecciono un Periferico", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            id = jtTablaPeriferico.getValueAt(fila, 0).toString();
            oldNombre = jtTablaPeriferico.getValueAt(fila, 1).toString();
            oldDescripcion = jtTablaPeriferico.getValueAt(fila, 2).toString();
            oldEquipo = jtTablaPeriferico.getValueAt(fila, 3).toString();
            oldEstado = jtTablaPeriferico.getValueAt(fila, 4).toString();

            oldDescripcionEstado = jtTablaPeriferico.getValueAt(fila, 5).toString();

            System.out.println("Estado en Periferico" + oldDescripcionEstado);
            System.out.println("Estado en Periferico" + oldEquipo);
            Usuario_EstadoPeriferico obj = new Usuario_EstadoPeriferico(user, id, oldNombre, oldDescripcion, oldEquipo, oldEstado, oldDescripcionEstado);
            obj.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btEstadoActionPerformed

    private void btAñadirPerifericoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirPerifericoActionPerformed
        Usuario_AñadirPeriferico obj = new Usuario_AñadirPeriferico(user, oldEquipo);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);

        this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_btAñadirPerifericoActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario_Perifericos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario_Perifericos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario_Perifericos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario_Perifericos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Usuario_Perifericos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAñadirPeriferico;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEstado;
    private javax.swing.JButton btHome;
    private javax.swing.JButton btLista;
    private javax.swing.JButton btMantenimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcBuscar;
    private javax.swing.JTable jtTablaPeriferico;
    private javax.swing.JTextField tfPerifericos;
    // End of variables declaration//GEN-END:variables
}
