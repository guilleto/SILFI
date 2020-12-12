package gui_test_1;

import Control.ValidarLogin;
import DAO.UsuarioDAO;
import Entidad.Usuario;
import com.placeholder.PlaceHolder;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

public class Login extends javax.swing.JFrame {

    private UsuarioDAO dao = new UsuarioDAO();

    FondoPanel fondo = new FondoPanel();
    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com:3306/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    Connection connection = null;
    Statement statement = null;
    String admin;

    public Login() {
        this.setContentPane(fondo);
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        holders();
        String nombreUsuario;

    }

    public void holders() {
        PlaceHolder holder;
        holder = new PlaceHolder(tfUsuario, "USUARIO");
        holder = new PlaceHolder(tfContraseña, "CONTRASEÑA");

    }

    public String verificarLogin(Usuario usuario) {
        if (!verificarLongitudNombre(usuario.getUserName())) {
            return ("Longitud nombre incorrecta");
        }
        if (!verificarLongitudPassword(usuario.getPass())) {
            return ("Longitud contraseña incorrecta");
        }
        if (dao.leer(usuario) == true) {
            return ("Bienvenido");
        }
        return ("Datos Incorrectos");
    }

    public void Ingresar() {
        String user = tfUsuario.getText();
        String sql = "SELECT * FROM loginapp.USUARIO WHERE USERNAME = '" + tfUsuario.getText() + "'";
        int resultSet;
        String datos[] = new String[4];
        admin = null;
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
        String resultado = verificarLogin(usuario);
        if (resultado == "Bienvenido") {
            if (admin.equals("1")) {
                JOptionPane.showMessageDialog(null, resultado + " " + tfUsuario.getText());
                Admin_Menu adminVentana = new Admin_Menu(user);
                adminVentana.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, resultado + " " + tfUsuario.getText());
                Usuario_Menu obj = new Usuario_Menu(user);
                obj.setVisible(true);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuario incorrecto", "Usuario Invalido", JOptionPane.ERROR_MESSAGE);
            tfUsuario.setText("");
            tfContraseña.setText("");
        }

    }

    private boolean verificarLongitudNombre(String userName) {
        return (userName.length() > 3 && userName.length() <= 13);
    }

    private boolean verificarLongitudPassword(String pass) {
        return (pass.length() >= 3 && pass.length() < 16);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new FondoPanel();
        tfContraseña = new javax.swing.JPasswordField();
        tfUsuario = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
        jPanel1.add(tfContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 414, 250, 30));

        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 377, 250, 30));

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
        jPanel1.add(btIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 462, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ingeniero login.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 150, -1, 220));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logosilfin.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 70));

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        Ingresar();
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField tfContraseña;
    private javax.swing.JTextField tfUsuario;
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
