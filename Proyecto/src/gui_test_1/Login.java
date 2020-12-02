package gui_test_1;

import Control.ValidarLogin;
import Entidad.Usuario;
import com.placeholder.PlaceHolder;
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

public class Login extends javax.swing.JFrame {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com:3306/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";

    public Login() {
        initComponents();

        setLocationRelativeTo(null);
        //setExtendedState(MAXIMIZED_BOTH);
        String nombreUsuario;
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        holders();
      
    }
    public void holders(){
        PlaceHolder holder;
        holder = new PlaceHolder(tfUsuario, "USUARIO");
        holder = new PlaceHolder(tfContraseña, "CONTRASEÑA");
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfContraseña = new javax.swing.JPasswordField();
        btIngresar = new javax.swing.JButton();
        jlFondo = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 650));
        setMinimumSize(new java.awt.Dimension(900, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 250, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("He olvidado mi contraseña");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 250, -1));
        jPanel1.add(tfContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 250, 30));

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
        btIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btIngresarKeyTyped(evt);
            }
        });
        jPanel1.add(btIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 50, 50));

        jlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/loginFondo.png"))); // NOI18N
        jPanel1.add(jlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed

//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("User");
//        modelo.addColumn("Pass");
//        modelo.addColumn("Admin");
        //String sql = "SELECT * FROM loginapp.USUARIO WHERE USERNAME = 'Admin'";
        String sql = "SELECT * FROM loginapp.USUARIO WHERE USERNAME = '" + tfUsuario.getText() + "'";
        Connection connection = null;
        Statement statement = null;
        String user = tfUsuario.getText();

        int resultSet;
        String datos[] = new String[4];
        String admin = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {

                admin = result.getString(4);
            }

        } catch (SQLException ex) {

        }

        Usuario usuario = new Usuario();
        usuario.setUserName(tfUsuario.getText());
        usuario.setPass(tfContraseña.getText());

        ValidarLogin validar = new ValidarLogin();
        String resultado = validar.verificarLogin(usuario);

        if (resultado == "Bienvenido") {
            if (admin.equals("1")) {
                JOptionPane.showMessageDialog(null, resultado + "  " + tfUsuario.getText());

                Admin_Menu adminVentana = new Admin_Menu(user);
                adminVentana.setVisible(true);
                this.dispose();

            } else {

                JOptionPane.showMessageDialog(null, resultado + "  " + tfUsuario.getText());

                Usuario_Menu obj = new Usuario_Menu(user);
                obj.setVisible(true);
                this.dispose();

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuario incorrecto", "Usuario Invalido", JOptionPane.ERROR_MESSAGE);
            tfUsuario.setText("");
            tfContraseña.setText("");
        }
        
    }//GEN-LAST:event_btIngresarActionPerformed

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsuarioActionPerformed

    private void btIngresarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btIngresarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btIngresarKeyTyped

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlFondo;
    private javax.swing.JPasswordField tfContraseña;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
