package DAO;

import Entidad.Lab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LaboratorioDAO {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";

    public boolean crear(Lab object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        Lab lab = new Lab();
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO LAB( `ID_LAB`,`NOMBRE_LAB`, `DESCRIPCION_LAB`,`EDIFICIOId_Edificio`,`USUARIOUsername`) VALUES (\""
                    + object.getId_Lab() + "\",\"" + object.getNombre_Lab() + "\",\"" + object.getDescripcion_Lab() + "\",\"" + object.getEdificioId_Edificio() + "\",\""
                    + object.getUsuarioId_Usuario()+ "\")");
            return resultSet > 0;
        } catch (SQLException SQLIntegrityConstraintViolationException) {

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

    public boolean leer(Lab par) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM LAB "
                    + "WHERE ID_LAB = '" + par.getId_Lab()
                    + "'  AND NOMBRE_LAB = '" + par.getNombre_Lab()
                    + "'  AND DESCRIPCION_LAB = '" + par.getDescripcion_Lab()
                    + "'  AND EDIFICIOId_Edificio= '" + par.getEdificioId_Edificio()
                    + "' AND USUARIOUsername = '" + par.getUsuarioId_Usuario() + "'"
            );
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
                statement.close();
                connection.close();
                return resultSet.next();
            } catch (SQLException ex) {
                System.out.println("Error en SQL" + ex);
            }
        }

    }

    public boolean actualizar(Lab oldLab, Lab newLab) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE LAB "
                    + " SET ID_LAB = '" + newLab.getId_Lab() + "' , "
                    + " NOMBRE_LAB = '" + newLab.getNombre_Lab() + "' , "
                    + " DESCRIPCION_LAB = '" + newLab.getDescripcion_Lab() + "' , "
                    + " EDIFICIOId_Edificio = '" + newLab.getEdificioId_Edificio() + "' , "
                    + " USUARIOUsername = '" + newLab.getUsuarioId_Usuario()
                    + "' WHERE ID_LAB = '" + oldLab.getId_Lab()
                    + "' AND NOMBRE_LAB = '" + oldLab.getNombre_Lab()
                    + "' AND DESCRIPCION_LAB = '" + oldLab.getDescripcion_Lab()
                    + "' AND EDIFICIOId_Edificio = '" + oldLab.getEdificioId_Edificio()
                    + "' AND USUARIOUsername= '" + oldLab.getUsuarioId_Usuario()
                    + "';"
            );
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

    public boolean eliminar(Lab object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM LAB "
                    + "WHERE ID_LAB = '" + object.getId_Lab()
                    + "' AND NOMBRE_LAB ='" + object.getNombre_Lab()
                    + "' AND DESCRIPCION_LAB ='" + object.getDescripcion_Lab()
                    + "' AND EDIFICIOId_Edificio ='" + object.getEdificioId_Edificio()
                    + "' AND USUARIOUsername ='" + object.getUsuarioId_Usuario()
                    + "';");
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

    public DefaultComboBoxModel llenar_Combo() {
        Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel listaLabs = new DefaultComboBoxModel();
        listaLabs.addElement("Seleccione la id del Laboratorio");
        String sqlBusqueda = "SELECT * FROM loginapp.LAB";

        int resultSet;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlBusqueda);

            while (result.next()) {
                listaLabs.addElement(result.getString("ID_LAB"));
                //+ ", " + result.getString("NOMBRE_LAB")
            }
            result.close();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            JOptionPane.showMessageDialog(null, "Error al encontrar el id del Laboratorio", "Error Id Laboratorio", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return listaLabs;
    }

    public DefaultComboBoxModel llenar_Busqueda() {

        DefaultComboBoxModel listaLabs = new DefaultComboBoxModel();
        listaLabs.addElement("Seleccione una opcion");
        listaLabs.addElement("Id");
        listaLabs.addElement("Nombre");
        listaLabs.addElement("Descripcion");
        listaLabs.addElement("Edificio");
        listaLabs.addElement("Usuario");

        return listaLabs;
    }
}
