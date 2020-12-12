package gui_test_1;

import DAO.EquipoDAO;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Usuario_Equipos_ extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    public String user;
    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel CBbuscar = new DefaultComboBoxModel();
    Connection connection = null;
    Statement statement = null;
    EquipoDAO equipoDao = new EquipoDAO();
    String idEquipo;
    String buscar;
    String sqlBusqueda;
    public String id;
    public String oldNombre;
    public String oldDescripcion;
    public String oldLab;
    public String oldEstado;
    public String oldDescripcionEstado;
    String[] dato = new String[10];

    public Usuario_Equipos_(String user) {
        this.setContentPane(fondo);
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;
        this.id = id;

        this.oldDescripcionEstado = oldDescripcionEstado;
        int resultSet;
        jcBuscar.removeAllItems();
        this.jcBuscar.setModel(equipoDao.llenar_Busqueda());
        buscar = (String) jcBuscar.getSelectedItem();

        model.addColumn("ID");
        model.addColumn("NOMBRE");
        model.addColumn("DESCRIPCION");
        model.addColumn("ID LABORATORIO");
        model.addColumn("ESTADO");
        model.addColumn("DESCRIPCION ESTADO");
        jtTablaEquipos.setModel(model);
        String sql = "SELECT * FROM loginapp.EQUIPO";

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

    private Usuario_Equipos_() {
        initComponents();

    }

    public void todosElementos() {

        String sql = "SELECT * FROM loginapp.EQUIPO ";
        tfEquipos.setText("");

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
        int fila = jtTablaEquipos.getSelectedRow();
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "Dato vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            idEquipo = jtTablaEquipos.getValueAt(fila, 0).toString();
            String sql = "DELETE FROM loginapp.EQUIPO WHERE ID_EQUIPO ='" + idEquipo + "'";

            try {
                idEquipo = jtTablaEquipos.getValueAt(fila, 0).toString();
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                statement = connection.createStatement();
                int result = statement.executeUpdate(sql);
                fila = -1;
                todosElementos();
                fila = -1;
                JOptionPane.showMessageDialog(rootPane, "Se ha eliminado el equipo: " + idEquipo + "", "Eliminar el registro", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No es posible eliminar el registro", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public void actualizar() {
        int fila = jtTablaEquipos.getSelectedRow();
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "No se selecciono un equipo", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            id = jtTablaEquipos.getValueAt(fila, 0).toString();
            oldNombre = jtTablaEquipos.getValueAt(fila, 1).toString();
            oldDescripcion = jtTablaEquipos.getValueAt(fila, 2).toString();
            oldLab = jtTablaEquipos.getValueAt(fila, 3).toString();

            System.out.println(id + oldNombre + oldDescripcion + oldLab);
            Usuario_ActualizarEquipo_ obj = new Usuario_ActualizarEquipo_(user, id, oldNombre, oldDescripcion, oldLab);
            obj.setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new FondoPanel();
        tfEquipos = new javax.swing.JTextField();
        btHome = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btAñadirEquipos = new javax.swing.JButton();
        btMantenimiento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaEquipos = new javax.swing.JTable();
        btLista = new javax.swing.JButton();
        jcBuscar = new javax.swing.JComboBox<>();
        btBuscar = new javax.swing.JButton();
        btEstado = new javax.swing.JButton();
        btPerifericos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(tfEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 210, 30));

        btHome.setContentAreaFilled(false);
        btHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, 140, 50));

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

        btAñadirEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondeagregarequipo (2).png"))); // NOI18N
        btAñadirEquipos.setContentAreaFilled(false);
        btAñadirEquipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAñadirEquipos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BotondeagregarequipoPUSH.png"))); // NOI18N
        btAñadirEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadirEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 110, 140));

        btMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondemantenimiento.png"))); // NOI18N
        btMantenimiento.setContentAreaFilled(false);
        btMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMantenimiento.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondemantenimientopush.png"))); // NOI18N
        btMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMantenimientoActionPerformed(evt);
            }
        });
        jPanel1.add(btMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 110, 140));

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

        btPerifericos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boton de perifericos.png"))); // NOI18N
        btPerifericos.setContentAreaFilled(false);
        btPerifericos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPerifericos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boton de perifericos push.png"))); // NOI18N
        btPerifericos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPerifericosActionPerformed(evt);
            }
        });
        jPanel1.add(btPerifericos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 160, 50));

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMINISTRACIÓN DE EQUIPOS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 40, 320, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logosilfin.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SILUNAPPBACKGROUND1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

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

    private void btHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHomeActionPerformed
        Usuario_Menu obj = new Usuario_Menu(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btHomeActionPerformed

    private void btMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMantenimientoActionPerformed
        Usuario_Mantenimiento_ obj = new Usuario_Mantenimiento_(user);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);

        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_btMantenimientoActionPerformed

    private void btAñadirEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirEquiposActionPerformed
        Usuario_AñadirEquipo_ obj = new Usuario_AñadirEquipo_(user);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);

        this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_btAñadirEquiposActionPerformed

    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed

        String sql = "SELECT * FROM loginapp.EQUIPO ";
        tfEquipos.setText("");

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
        int fila = jtTablaEquipos.getSelectedRow();

        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "No se selecciono un equipo", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
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
        }

    }//GEN-LAST:event_btEliminarActionPerformed

    private void jcBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcBuscarActionPerformed

    private void tfEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEquiposActionPerformed

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
            if (tfEquipos.getText().equals(null) || tfEquipos.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Campo de busqueda vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
            } else {
                if (buscar.equals("Placa")) {
                    sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE Id_Equipo LIKE '%" + tfEquipos.getText() + "%'";
                }
                if (buscar.equals("Nombre")) {
                    sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE Nombre_Equipo LIKE '%" + tfEquipos.getText() + "%'";
                }
                if (buscar.equals("Descripcion")) {
                    sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE DESCRIPCION_EQUIPO LIKE '%" + tfEquipos.getText() + "%'";
                }
                if (buscar.equals("Laboratorio")) {
                    sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE LABID_LAB LIKE '%" + tfEquipos.getText() + "%'";
                }
                if (buscar.equals("Estado")) {
                    sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE ESTADO LIKE '%" + tfEquipos.getText() + "%'";
                }
                if (buscar.equals("Descripcion Estado")) {
                    sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE DESCRIPCION_ESTADO LIKE '%" + tfEquipos.getText() + "%'";
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
                        tfEquipos.setText("");
                    }
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEstadoActionPerformed
        int fila = jtTablaEquipos.getSelectedRow();

        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "No se selecciono un equipo", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            id = jtTablaEquipos.getValueAt(fila, 0).toString();
            oldNombre = jtTablaEquipos.getValueAt(fila, 1).toString();
            oldDescripcion = jtTablaEquipos.getValueAt(fila, 2).toString();
            oldLab = jtTablaEquipos.getValueAt(fila, 3).toString();
            oldEstado = jtTablaEquipos.getValueAt(fila, 4).toString();
            oldDescripcionEstado = jtTablaEquipos.getValueAt(fila, 5).toString();

            System.out.println(oldDescripcionEstado);
            Usuario_EstadoEquipo_ obj = new Usuario_EstadoEquipo_(user, id, oldNombre, oldDescripcion, oldLab, oldEstado, oldDescripcionEstado);
            obj.setVisible(true);
            dispose();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btEstadoActionPerformed

    private void btPerifericosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPerifericosActionPerformed
        int fila = jtTablaEquipos.getSelectedRow();
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "No se selecciono un equipo", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            id = jtTablaEquipos.getValueAt(fila, 0).toString();

            Usuario_Perifericos obj = new Usuario_Perifericos(user, id);
            obj.setVisible(true);
            dispose();
        }        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btPerifericosActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario_Equipos_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario_Equipos_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario_Equipos_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario_Equipos_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Usuario_Equipos_().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAñadirEquipos;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEstado;
    private javax.swing.JButton btHome;
    private javax.swing.JButton btLista;
    private javax.swing.JButton btMantenimiento;
    private javax.swing.JButton btPerifericos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcBuscar;
    private javax.swing.JTable jtTablaEquipos;
    private javax.swing.JTextField tfEquipos;
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
