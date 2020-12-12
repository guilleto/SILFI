package gui_test_1;

import static gui_test_1.Admin_Equipos.DB_PASSWORD;
import static gui_test_1.Admin_Equipos.DB_URL;
import static gui_test_1.Admin_Equipos.DB_USER;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import static java.awt.Label.CENTER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Admin_ListaMantenimientosPrueba extends javax.swing.JFrame  {

    FondoPanel fondo = new FondoPanel();
    public String user;
    public String matenimientoFecha;
    Connection connection = null;
    java.sql.Statement statement = null;
    String[][] datos = new String[10][10];
    int count;

    public Admin_ListaMantenimientosPrueba(String user, String mantenimientoFecha) {
        this.setContentPane(fondo);
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());

        this.user = user;
        this.matenimientoFecha = mantenimientoFecha;
        System.out.println(mantenimientoFecha);
        jlFecha.setText(mantenimientoFecha);

        String sqlComparacionFecha = "SELECT * FROM loginapp.MANTENIMIENTO WHERE FECHA_MANTENIMIENTO ='" + mantenimientoFecha + "'";

        int ret = 0;
        // scroller.setWheelScrollingEnabled(true);
        datos = new String[10][10];
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlComparacionFecha);

            int i = 0;
            while (result.next()) {
                //datos[0][i]= result.getString(1);
                //datos[1][i] = result.getString(2);
                datos[2][i] = result.getString(3);
                datos[3][i] = result.getString(4);
                datos[4][i] = result.getString(5);
                datos[5][i] = result.getString(6);
                //JOptionPane.showMessageDialog(this, datos[1][i] + "," + datos[2][i] + "," + datos[3][i] + "," + datos[4][i] + "," + datos[5][i], "Informacion", JOptionPane.INFORMATION_MESSAGE);
                // model.addRow(datos);
                i++;
            }

        } catch (Exception e) {
        }
        int ubicacion = 0;

        String resultados = "";
        for (int i = 0; i < 10; i++) {
            if (datos[2][i] != null) {
               
                resultados = "<html><font color = #00000><center>";
                resultados = resultados + "<b>" + datos[2][i] + "</b>" + "<br><b> Descripcion</b>: " + datos[3][i]
                        + "<br><b>Periferico</b>: " + datos[5][i] + "<br><b>Equipo</b>: " + datos[4][i] + "<br><br> " + "</html>";
                JButton btMantenimiento = new JButton(resultados);
                
                btMantenimiento.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Funciono");
                        System.out.println();
                    }
                });

                btMantenimiento.setBackground(new Color(59, 89, 182));
                jpMantenimiento.add(btMantenimiento);
                btMantenimiento.setMinimumSize(new Dimension(100, 100));
                btMantenimiento.setLocation(CENTER, ubicacion);
                ubicacion += 80;

            }
        }
        jpMantenimiento.setLayout(new BoxLayout(jpMantenimiento, BoxLayout.Y_AXIS));

    }

    private Admin_ListaMantenimientosPrueba() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlFecha = new javax.swing.JLabel();
        btAceptar = new javax.swing.JButton();
        jpMantenimiento = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btAceptar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(44, 77, 87));
        jPanel1.setForeground(new java.awt.Color(246, 203, 38));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlFecha.setFont(new java.awt.Font("Calibri", 2, 24)); // NOI18N
        jlFecha.setForeground(new java.awt.Color(255, 255, 255));
        jlFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlFecha.setText("jLabel1");
        jlFecha.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jlFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 350, -1));

        btAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login.png"))); // NOI18N
        btAceptar.setBorder(null);
        btAceptar.setContentAreaFilled(false);
        btAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAceptar.setPreferredSize(new java.awt.Dimension(50, 50));
        btAceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login push.png"))); // NOI18N
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 70, -1));

        javax.swing.GroupLayout jpMantenimientoLayout = new javax.swing.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jpMantenimientoLayout.setVerticalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jPanel1.add(jpMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 350, 360));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pestañitamantenimiento.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 650));

        btAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login.png"))); // NOI18N
        btAceptar1.setBorder(null);
        btAceptar1.setContentAreaFilled(false);
        btAceptar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAceptar1.setPreferredSize(new java.awt.Dimension(50, 50));
        btAceptar1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login push.png"))); // NOI18N
        btAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 70, -1));

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

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btAceptarActionPerformed

    private void btAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAceptar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_ListaMantenimientosPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_ListaMantenimientosPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_ListaMantenimientosPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_ListaMantenimientosPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Admin_ListaMantenimientosPrueba().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btAceptar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JPanel jpMantenimiento;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Images/Pestañitamantenimiento.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);

            super.paint(g);
        }
    }
}
