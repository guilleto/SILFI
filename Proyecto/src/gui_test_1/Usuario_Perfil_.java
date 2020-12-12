package gui_test_1;

import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Usuario_Perfil_ extends javax.swing.JFrame {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com:3306/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    public String user;
    public String contraseña;
    UsuarioDAO usuario = new UsuarioDAO();
    Connection connection = null;
    Statement statement = null;

    public Usuario_Perfil_(String user) {
      initComponents();
        this.user = user;
        setLocationRelativeTo(null);
        //setExtendedState(MAXIMIZED_BOTH);
        String nombreUsuario;
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        String userNamePerfil = user;
        System.out.println(userNamePerfil);
        jlNombrePerfil.setText(user);
    }

    private Usuario_Perfil_() {

    }

    public void confirmar() {
        int msj = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cambiar la contraseña?");
        if (msj == JOptionPane.YES_OPTION) {
            actualizar();
        }
        if (msj == JOptionPane.NO_OPTION) {
            //    tfNuevaContraseña.setText("");
        }
        if (msj == JOptionPane.CLOSED_OPTION) {
            Admin_Menu obj = new Admin_Menu(user);
            obj.setVisible(true);
            dispose();
        }
    }

    public void actualizar() {

        int resultSet;
        String sql = "UPDATE USUARIO "
                + " SET USERNAME = '" + user + "' , "
                //   + " PASS = '" + tfNuevaContraseña.getText() + "' , "
                + "' WHERE USERNAME = '" + user
                //   + "' AND PASS = '" + tfOldContraseña.getText()
                + "' ;";
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(rootPane, "Se ha actualizado la contraseña : " + user + "", "Actualizacion del registro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No es posible actualizar el registro" + e, "Error al Actualizar", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btValidar = new javax.swing.JButton();
        jlNombrePerfil = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlFondo3 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 750));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 750));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btValidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login.png"))); // NOI18N
        btValidar.setBorder(null);
        btValidar.setContentAreaFilled(false);
        btValidar.setPreferredSize(new java.awt.Dimension(50, 50));
        btValidar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login push.png"))); // NOI18N
        btValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidarActionPerformed(evt);
            }
        });
        jPanel1.add(btValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 640, 50, 50));

        jlNombrePerfil.setFont(new java.awt.Font("Ancizar Sans", 3, 24)); // NOI18N
        jlNombrePerfil.setForeground(new java.awt.Color(255, 255, 255));
        jlNombrePerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombrePerfil.setText("Andres L.");
        jlNombrePerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlNombrePerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 200, -1));

        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 140, 50));

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MI PERFIL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 100, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logosilfin.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/usuarioslogo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 260, 240));

        jlFondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mini no tan mini.png"))); // NOI18N
        jPanel1.add(jlFondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 750));

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

    private void btValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidarActionPerformed
        Usuario_Menu obj = new Usuario_Menu(user);
        obj.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_btValidarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Usuario_Menu obj = new Usuario_Menu(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario_Perfil_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario_Perfil_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario_Perfil_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario_Perfil_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Usuario_Perfil_().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btValidar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlFondo3;
    private javax.swing.JLabel jlNombrePerfil;
    // End of variables declaration//GEN-END:variables
}
