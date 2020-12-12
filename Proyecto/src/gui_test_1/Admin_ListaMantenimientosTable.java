package gui_test_1;

import static gui_test_1.Admin_Equipos.DB_PASSWORD;
import static gui_test_1.Admin_Equipos.DB_URL;
import static gui_test_1.Admin_Equipos.DB_USER;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Admin_ListaMantenimientosTable extends javax.swing.JFrame {

    Connection connection = null;
    Statement statement = null;

    public String user;
    String matenimientoFecha;
    DefaultTableModel model = new DefaultTableModel();
    String[] datos = new String[10];
    int count;
    int fila = -1;

    public Admin_ListaMantenimientosTable(String user, String mantenimientoFecha) {

        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());

        this.user = user;
        this.matenimientoFecha = mantenimientoFecha;
        System.out.println(mantenimientoFecha);
        jlFecha.setText(mantenimientoFecha);

        String sqlComparacionFecha = "SELECT * FROM loginapp.MANTENIMIENTO WHERE FECHA_MANTENIMIENTO ='" + mantenimientoFecha + "'";
        // model.addColumn("ID");
        model.addColumn("FECHA");
        model.addColumn("NOMBRE");
        model.addColumn("DESCRIPCION");
        model.addColumn("EQUIPO");
        model.addColumn("PERIFERICO");
        jtTablaMantenimiento.setModel(model);
        int ret = 0;

        datos = new String[10];
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlComparacionFecha);

            int i = 0;
            while (result.next()) {
                datos[0] = result.getString(2);
                datos[1] = result.getString(3);
                datos[2] = result.getString(4);
                datos[3] = result.getString(5);
                datos[4] = result.getString(6);
                //JOptionPane.showMessageDialog(this, datos[1][i] + "," + datos[2][i] + "," + datos[3][i] + "," + datos[4][i] + "," + datos[5][i], "Informacion", JOptionPane.INFORMATION_MESSAGE);

                model.addRow(datos);
            }

        } catch (Exception e) {
        }

    }

    public void todosElementos(String mantenimientoFecha) {

        String sqlComparacionFecha = "SELECT * FROM loginapp.MANTENIMIENTO WHERE FECHA_MANTENIMIENTO ='" + mantenimientoFecha + "'";
        datos = new String[10];
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlComparacionFecha);
            model.getDataVector().removeAllElements();
            while (result.next()) {
                datos[0] = result.getString(2);
                datos[1] = result.getString(3);
                datos[2] = result.getString(4);
                datos[3] = result.getString(5);
                datos[4] = result.getString(6);
                model.addRow(datos);
            }
        } catch (Exception e) {
        }
    }

    private Admin_ListaMantenimientosTable() {

    }

    public void eliminar() {
        int fila = jtTablaMantenimiento.getSelectedRow();
        System.out.println(fila);
        System.out.println(fila);
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "Dato vacio", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            String fecha = jtTablaMantenimiento.getValueAt(fila, 0).toString();
            String nombre = jtTablaMantenimiento.getValueAt(fila, 1).toString();
            String descripcion = jtTablaMantenimiento.getValueAt(fila, 2).toString();
            String equipo = jtTablaMantenimiento.getValueAt(fila, 3).toString();
            System.out.println(fecha + nombre + descripcion + equipo);
            String sql = "DELETE FROM loginapp.MANTENIMIENTO WHERE FECHA_MANTENIMIENTO ='" + fecha + "' AND NOMBRE_MANTENIMIENTO = '" + nombre
                    + "' AND DESCRIPCION_MANTENIMIENTO = '" + descripcion + "' AND EQUIPOID_EQUIPO = '" + equipo + "'";

            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                statement = connection.createStatement();
                int result = statement.executeUpdate(sql);
                fila = -1;
                todosElementos(fecha);
                fila = -1;
                JOptionPane.showMessageDialog(rootPane, "Se ha eliminado el Mantenimiento ", "Eliminar el registro", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No es posible eliminar el registro" + e, "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlFecha = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaMantenimiento = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btCompletado = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jlFondo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(44, 77, 87));
        jPanel1.setForeground(new java.awt.Color(246, 203, 38));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 750));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 750));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlFecha.setFont(new java.awt.Font("Calibri", 2, 24)); // NOI18N
        jlFecha.setForeground(new java.awt.Color(255, 255, 255));
        jlFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlFecha.setText("jLabel1");
        jlFecha.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jlFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 350, -1));

        jtTablaMantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtTablaMantenimiento);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 370, 400));

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MANTENIMIENTOS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 210, -1));

        btCompletado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boton de completado.png"))); // NOI18N
        btCompletado.setContentAreaFilled(false);
        btCompletado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boton de completado push.png"))); // NOI18N
        btCompletado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompletadoActionPerformed(evt);
            }
        });
        jPanel1.add(btCompletado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 160, 40));

        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 140, 50));

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

    private void btCompletadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompletadoActionPerformed
        int msj = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que fue completado el mantenimiento?, Se eliminara al aceptar");

        if (msj == JOptionPane.YES_OPTION) {
            eliminar();

        }
        if (msj == JOptionPane.NO_OPTION) {

        }
        if (msj == JOptionPane.CLOSED_OPTION) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_btCompletadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Admin_ListaMantenimientosTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_ListaMantenimientosTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_ListaMantenimientosTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_ListaMantenimientosTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Admin_ListaMantenimientosTable().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCompletado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlFondo2;
    private javax.swing.JTable jtTablaMantenimiento;
    // End of variables declaration//GEN-END:variables

}
