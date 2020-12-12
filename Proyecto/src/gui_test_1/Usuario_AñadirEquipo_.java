package gui_test_1;

import Control.ValidarEquipo;
import DAO.LaboratorioDAO;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Usuario_AñadirEquipo_ extends javax.swing.JFrame {

    public String user;
    Connection connection = null;
    Statement statement = null;
    LaboratorioDAO daoLab = new LaboratorioDAO();

    public Usuario_AñadirEquipo_(String user) {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/silunimage.png")).getImage());
        this.user = user;
        jcLaboratorios.removeAllItems();
        this.jcLaboratorios.setModel(daoLab.llenar_Combo());
    }

    private Usuario_AñadirEquipo_() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btAñadir = new javax.swing.JButton();
        btAtras = new javax.swing.JButton();
        tfId_Equipo = new javax.swing.JTextField();
        tfNombre_Equipo = new javax.swing.JTextField();
        tf_Descripcion = new javax.swing.JTextField();
        jcLaboratorios = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlFondo2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 750));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 750));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login.png"))); // NOI18N
        btAñadir.setBorder(null);
        btAñadir.setContentAreaFilled(false);
        btAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAñadir.setPreferredSize(new java.awt.Dimension(50, 50));
        btAñadir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_test_1/Images/boton login push.png"))); // NOI18N
        btAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 640, 50, 50));

        btAtras.setContentAreaFilled(false);
        btAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 140, 50));
        jPanel1.add(tfId_Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 170, 30));
        jPanel1.add(tfNombre_Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 290, 30));
        jPanel1.add(tf_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 290, 30));

        jcLaboratorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcLaboratoriosActionPerformed(evt);
            }
        });
        jPanel1.add(jcLaboratorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 290, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Botondeagregarequipo (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Laboratorio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 290, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AGREGAR EQUIPO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 190, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID EQUIPO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 170, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 290, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descripcion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 290, -1));

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

    private void btAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirActionPerformed
        String id = tfId_Equipo.getText();
        String nombre = tfNombre_Equipo.getText();
        String descripcion = tf_Descripcion.getText();

        String lab = (String) jcLaboratorios.getSelectedItem();
        String estado = "Activo";
        String Retorno = null;
        ValidarEquipo validar = new ValidarEquipo();
        Retorno = validar.verificarEquipo(id, nombre, descripcion, lab, estado);
        if (lab.equals("Seleccione la id del Laboratorio")) {
            JOptionPane.showMessageDialog(rootPane, "Laboratorio Vacio", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Retorno.equals("Equipo Invalido")) {
                JOptionPane.showMessageDialog(rootPane, "Equipo Invalido", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud id incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud id incorrecta", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud nombre incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud nombre incorrecta", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Longitud descripcion incorrecta")) {
                JOptionPane.showMessageDialog(rootPane, "Longitud Descripcion incorrecta", "Equipo Invalido", JOptionPane.ERROR_MESSAGE);
            }
            if (Retorno.equals("Equipo Registrado")) {
                JOptionPane.showMessageDialog(null, "Equipo Registrado Exitosamente");
                Admin_Equipos obj = new Admin_Equipos(user);
                obj.setVisible(true);
                this.dispose();
            }

        }

    }//GEN-LAST:event_btAñadirActionPerformed

    private void btAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtrasActionPerformed
        Usuario_Equipos_ obj = new Usuario_Equipos_(user);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btAtrasActionPerformed

    private void jcLaboratoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcLaboratoriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcLaboratoriosActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario_AñadirEquipo_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario_AñadirEquipo_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario_AñadirEquipo_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario_AñadirEquipo_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Usuario_AñadirEquipo_().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtras;
    private javax.swing.JButton btAñadir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcLaboratorios;
    private javax.swing.JLabel jlFondo2;
    private javax.swing.JTextField tfId_Equipo;
    private javax.swing.JTextField tfNombre_Equipo;
    private javax.swing.JTextField tf_Descripcion;
    // End of variables declaration//GEN-END:variables
}
