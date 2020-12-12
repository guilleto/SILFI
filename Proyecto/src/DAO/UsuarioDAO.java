package DAO;

import Entidad.Usuario;
import gui_test_1.Admin_AñadirUsuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com:3306/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    String password;

    public boolean crear(Usuario object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        Usuario usuario = new Usuario();
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO USUARIO( `USERNAME`, `PASS`, `ADMINUSER`) VALUES (\""
                    + object.getUserName() + "\",\"" + object.getPass() + "\",\"" + object.getAdmin() + "\")");
            return resultSet > 0;
        } catch (SQLException SQLIntegrityConstraintViolationException) {
            //JOptionPane.showMessageDialog(null,"Usuario Invalido","Usuario Invalido",JOptionPane.ERROR_MESSAGE);

            return false;
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error en SQL" + ex);
            }
        }

    }

    public boolean leer(Usuario par) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM USUARIO "
                    + "WHERE USERNAME = '" + par.getUserName()
                    + "' AND PASS ='" + par.getPass()
                    //+ "' AND ADMINUSER ='" + par.getAdmin()
                    + "'");
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return resultSet.next();
            } catch (SQLException ex) {

            }
        }

    }

    public boolean actualizar(Usuario oldUser, Usuario newUser) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE USUARIO "
                    + "SET USERNAME = '" + newUser.getUserName() + "' , "
                    + "PASS = '" + newUser.getPass()
                    + "' WHERE USERNAME='" + oldUser.getUserName()
                    + "' AND PASS='" + oldUser.getPass() + "';");
            return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();
                connection.close();

            } catch (SQLException ex) {

            }
        }
    }

    public boolean eliminar(Usuario object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM USUARIO "
                    + "WHERE USERNAME='" + object.getUserName()
                    + "' AND PASS='" + object.getPass() + "';");
            return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();
                connection.close();

            } catch (SQLException ex) {

            }
        }
    }

    public String Contraseña(String user) {
        Connection connection = null;
        Statement statement = null;
        String sqlBusqueda = "SELECT * FROM loginapp.USUARIO WHERE Username = '" + user + "'";
       
        int resultSet;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlBusqueda);

            while (result.next()) {
                password = (result.getString("PASS"));

            }
            result.close();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            JOptionPane.showMessageDialog(null, "Error al encontrar Username", "Error Username", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return password;
    }

    public DefaultComboBoxModel llenar_Combo() {
        Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel listaEquipos = new DefaultComboBoxModel();
        listaEquipos.addElement("Seleccione Usuario");
        String sqlBusqueda = "SELECT * FROM loginapp.USUARIO WHERE AdminUser = 0";

        int resultSet;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlBusqueda);

            while (result.next()) {
                listaEquipos.addElement(result.getString("USERNAME"));

            }
            result.close();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            JOptionPane.showMessageDialog(null, "Error al encontrar Username", "Error Username", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return listaEquipos;
    }

    public DefaultComboBoxModel llenar_ComboEdificio() {
        Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel listaEdificios = new DefaultComboBoxModel();
        listaEdificios.addElement("Seleccione Edificio");
        String sqlBusqueda = "SELECT * FROM loginapp.EDIFICIO ";

        int resultSet;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlBusqueda);

            while (result.next()) {
                listaEdificios.addElement(result.getString("ID_EDIFICIO"));

            }
            result.close();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            JOptionPane.showMessageDialog(null, "Error al encontrar Edificio", "Error Edificio", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return listaEdificios;
    }

    public DefaultComboBoxModel llenar_ComboEquipo() {
        Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel listaEquipos = new DefaultComboBoxModel();
        listaEquipos.addElement("Seleccione Equipo");
        String sqlBusqueda = "SELECT * FROM loginapp.EQUIPO ";

        int resultSet;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlBusqueda);

            while (result.next()) {
                listaEquipos.addElement(result.getString("ID_EQUIPO"));

            }
            result.close();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            JOptionPane.showMessageDialog(null, "Error al encontrar Edificio", "Error Edificio", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return listaEquipos;
    }

    public DefaultComboBoxModel llenar_ComboActualizar(String usuario) {
        Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel listaUsuarios = new DefaultComboBoxModel();
        listaUsuarios.addElement(usuario);

        String sqlBusqueda = "SELECT * FROM loginapp.USUARIO WHERE AdminUser = 0 AND Username != '" + usuario + "'";

        int resultSet;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlBusqueda);

            while (result.next()) {
                listaUsuarios.addElement(result.getString("USERNAME"));

            }
            result.close();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            JOptionPane.showMessageDialog(null, "Error al encontrar Username", "Error Username", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return listaUsuarios;
    }

    public DefaultComboBoxModel llenar_ComboEdificioActualizar(String edificio) {
        Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel listaEdificio = new DefaultComboBoxModel();
        listaEdificio.addElement(edificio);

        String sqlBusqueda = "SELECT * FROM loginapp.EDIFICIO WHERE Id_Edificio != '" + edificio + "'";

        int resultSet;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlBusqueda);

            while (result.next()) {
                listaEdificio.addElement(result.getString("Id_Edificio"));

            }
            result.close();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            JOptionPane.showMessageDialog(null, "Error al encontrar Edificio", "Error Edificio", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return listaEdificio;
    }
}
