package gui_test_1;

import Control.ValidarLogin;
import Control.ValidarMantenimiento;
import DAO.PerifericoDAO;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuario_Mantenimiento_ extends javax.swing.JFrame {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    Connection connection = null;
    Statement statement = null;
    DefaultTableModel model = new DefaultTableModel();
    public String user;
    public String fechaAñoMesDia;
    UsuarioDAO usuarioDao = new UsuarioDAO();
    PerifericoDAO perDao = new PerifericoDAO();

    public Usuario_Mantenimiento_(String user) {

        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;
        jcEquipos.removeAllItems();
        this.jcEquipos.setModel(usuarioDao.llenar_ComboEquipo());
        int resultSet;
        String sql = "SELECT * FROM loginapp.LAB";

        int ret = 0;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {

            }
        } catch (Exception e) {
        }

    }

    private Usuario_Mantenimiento_() {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tfDescripcion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btAñadir = new javax.swing.JButton();
        tfNombre = new javax.swing.JTextField();
        rsFecha_Matenimiento = new rojeru_san.componentes.RSDateChooser();
        rSCalendario = new rojeru_san.componentes.RSCalendar();
        btIngresar = new javax.swing.JButton();
        jcEquipos = new javax.swing.JComboBox<>();
        jcPeriferico = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        jPanel1.add(tfDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 270, 30));

        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 50));

        btAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondemostrar.png"))); // NOI18N
        btAñadir.setContentAreaFilled(false);
        btAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAñadir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botondemostrarpush.png"))); // NOI18N
        btAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 160, 50));
        jPanel1.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 270, 30));

        rsFecha_Matenimiento.setColorBackground(new java.awt.Color(246, 203, 38));
        rsFecha_Matenimiento.setPlaceholder("Seleccionar Fecha");
        jPanel1.add(rsFecha_Matenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 230, 60));

        rSCalendario.setColorBackground(new java.awt.Color(11, 55, 68));
        rSCalendario.setColorDiaActual(new java.awt.Color(246, 203, 38));
        jPanel1.add(rSCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 370, 400));

        btIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login.png"))); // NOI18N
        btIngresar.setBorder(null);
        btIngresar.setContentAreaFilled(false);
        btIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btIngresar.setPreferredSize(new java.awt.Dimension(50, 50));
        btIngresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login push.png"))); // NOI18N
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 50, 50));

        jcEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(jcEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 240, 30));

        jcPeriferico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPerifericoActionPerformed(evt);
            }
        });
        jPanel1.add(jcPeriferico, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 240, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Periferico");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 100, 30));

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccionar Fecha");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 170, 30));

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 70, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Descripcion");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 270, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID Equipo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 80, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondemantenimiento.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 110, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ADMINISTRADOR DE MANTENIMIENTOS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 420, -1));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Usuario_Menu obj = new Usuario_Menu(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirActionPerformed
//        Connection connection = null;
//        Statement statement = null;
//        int resultSet;
//
        if (rSCalendario.getDatoFecha() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona una fecha", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String formatoFecha = "dd MM yyyy";
            Date fecha = rSCalendario.getDatoFecha();
            SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
            //JOptionPane.showMessageDialog(this, "La fecha selecionada es: " + formateador.format(fecha), "Informacion", JOptionPane.INFORMATION_MESSAGE);

            String formatoAño = "yyyy";
            String formatoMes = "MM";
            String formatoMesMantenimiento = "MMMM";
            String formatoDia = "dd";

            SimpleDateFormat formateadorAño = new SimpleDateFormat(formatoAño);
            SimpleDateFormat formateadorMes = new SimpleDateFormat(formatoMes);
            SimpleDateFormat formateadorMesMant = new SimpleDateFormat(formatoMesMantenimiento);
            SimpleDateFormat formateadorDia = new SimpleDateFormat(formatoDia);

            fechaAñoMesDia = formateadorAño.format(fecha) + "-" + formateadorMes.format(fecha) + "-" + formateadorDia.format(fecha);
            String fechaMant = formateadorDia.format(fecha) + " de " + formateadorMesMant.format(fecha) + " del " + formateadorAño.format(fecha);
            System.out.println(fechaAñoMesDia);
//            String sqlComparacionFecha = "SELECT * FROM loginapp.MANTENIMIENTO WHERE FECHA_MANTENIMIENTO ='" + fechaAñoMesDia + "'";
//            //String sqlComparacionFecha = "SELECT * FROM loginapp.MANTENIMIENTO ";
//            int ret = 0;
//
//            String[][] datos = new String[10][10];
//            try {
//                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//                statement = connection.createStatement();
//                ResultSet result = statement.executeQuery(sqlComparacionFecha);
//
//                int i = 0;
//                while (result.next()) {
//                    //datos[0][i]= result.getString(1);
//                    //datos[1][i] = result.getString(2);
//                    datos[2][i] = result.getString(3);
//                    datos[3][i] = result.getString(4);
//                    datos[4][i] = result.getString(5);
//                    datos[5][i] = result.getString(6);
//                    //JOptionPane.showMessageDialog(this, datos[1][i] + "," + datos[2][i] + "," + datos[3][i] + "," + datos[4][i] + "," + datos[5][i], "Informacion", JOptionPane.INFORMATION_MESSAGE);
//                    // model.addRow(datos);
//                    i++;
//                }
//
//            } catch (Exception e) {
//            }
//            String resultados = "<html><font color = #FFFFFF><center>";
//            for (int i = 0; i < 10; i++) {
//                if (datos[2][i] != null) {
//                    resultados = resultados + "<b>" + datos[2][i] + "</b>" + "<br><b> Descripcion</b>: " + datos[3][i]
//                            + "<br><b>Periferico</b>: " + datos[5][i] + "<br><b>Equipo</b>: " + datos[4][i] + "<br><br> ";
//                }
//            }
//            resultados = resultados + "</html>";
//            Admin_ListaMantenimientos obj = new Admin_ListaMantenimientos(resultados, user, fechaMant);
//            obj.setVisible(true);
//            obj.setLocationRelativeTo(null);
//
//            //JOptionPane.showMessageDialog(this, resultados, "Usuario_ListaMantenimientos de la fecha: " + fechaAñoMesDia, JOptionPane.INFORMATION_MESSAGE);
//        }
//
//        //String sqlComparacionFecha = "SELECT * FROM loginapp.MANTENIMIENTO ";
        }
//        Admin_ListaMantenimientosPrueba obj = new Admin_ListaMantenimientosPrueba(user, fechaAñoMesDia);
//        obj.setVisible(true);
//        obj.setLocationRelativeTo(null);

        Usuario_ListaMantenimientosTable obj = new Usuario_ListaMantenimientosTable(user, fechaAñoMesDia);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_btAñadirActionPerformed

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        String equipo = (String) jcEquipos.getSelectedItem();
        String periferico = (String) jcPeriferico.getSelectedItem();
        Date fecha = rsFecha_Matenimiento.getDatoFecha();
        String formatoFecha = "dd MMMM yyyy";
        String formatoAño = "yyyy";
        String formatoMes = "MM";
        String formatoDia = "dd";
        SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
        SimpleDateFormat formateadorAño = new SimpleDateFormat(formatoAño);
        SimpleDateFormat formateadorMes = new SimpleDateFormat(formatoMes);
        SimpleDateFormat formateadorDia = new SimpleDateFormat(formatoDia);

        String nombre = tfNombre.getText();
        String descripcion = tfDescripcion.getText();
        String id_Equipo = equipo;
        String id_Periferico = periferico;

        String Retorno = null;
        //System.out.println(rsFecha_Matenimiento.getDatoFecha());
        if (equipo.equals("Seleccione Equipo")) {
            JOptionPane.showMessageDialog(rootPane, "Equipo Vacio", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
        } else {
            if (rsFecha_Matenimiento.getDatoFecha() != null) {
                String fechaAñoMesDia = formateadorAño.format(fecha) + "-" + formateadorMes.format(fecha) + "-" + formateadorDia.format(fecha);

                ValidarMantenimiento validar = new ValidarMantenimiento();
                Retorno = validar.verificarMantenimiento(fechaAñoMesDia, nombre,
                        descripcion, id_Equipo, id_Periferico);
                if (Retorno.equals("Longitud id periferico incorrecta")) {
                    JOptionPane.showMessageDialog(rootPane, "Longitud Id Periferico Incorrecta", "Informacion Mantenimiento Invalido", JOptionPane.ERROR_MESSAGE);
                }
                if (Retorno.equals("Longitud id periferico incorrecta")) {
                    JOptionPane.showMessageDialog(rootPane, "Longitud Id Periferico Incorrecta", "Informacion Mantenimiento Invalido", JOptionPane.ERROR_MESSAGE);
                }
                if (Retorno.equals("Longitud id equipo incorrecta")) {
                    JOptionPane.showMessageDialog(rootPane, "Longitud Id Equipo Incorrecta", "Informacion Mantenimiento Invalido", JOptionPane.ERROR_MESSAGE);
                }
                if (Retorno.equals("Longitud nombre incorrecta")) {
                    JOptionPane.showMessageDialog(rootPane, "Longitud Nombre del Mantenimiento Incorrecta", "Informacion Mantenimiento Invalido", JOptionPane.ERROR_MESSAGE);
                }
                if (Retorno.equals("Longitud descripcion incorrecta")) {
                    JOptionPane.showMessageDialog(rootPane, "Longitud Descripcion incorrecta", "Informacion Mantenimiento Invalido", JOptionPane.ERROR_MESSAGE);
                }
                if (Retorno.equals("Longitud fecha incorrecta")) {
                    JOptionPane.showMessageDialog(rootPane, "Longitud Fecha incorrecta", "Informacion Mantenimiento Invalido", JOptionPane.ERROR_MESSAGE);
                }
                if (Retorno.equals("Informacion Mantenimiento Registrado")) {
                    JOptionPane.showMessageDialog(null, "Informacion del Mantenimiento Registrado Exitosamente");

                }

                tfDescripcion.setText("");
                tfNombre.setText("");
                rsFecha_Matenimiento.setDatoFecha(null);
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una fecha", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btIngresarActionPerformed

    private void jcEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcEquiposActionPerformed

    private void jcPerifericoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPerifericoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcPerifericoActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario_Mantenimiento_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario_Mantenimiento_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario_Mantenimiento_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario_Mantenimiento_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Usuario_Mantenimiento_().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAñadir;
    private javax.swing.JButton btIngresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcEquipos;
    private javax.swing.JComboBox<String> jcPeriferico;
    private rojeru_san.componentes.RSCalendar rSCalendario;
    private rojeru_san.componentes.RSDateChooser rsFecha_Matenimiento;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
