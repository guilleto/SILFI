package DAO;

import Entidad.Equipo;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EquipoDAO {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    Connection connection = null;
    Statement statement = null;

    public boolean crear(Equipo object) {

        int resultSet;
        Equipo equipo = new Equipo();
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO EQUIPO( `ID_EQUIPO`,`NOMBRE_EQUIPO`, `DESCRIPCION_EQUIPO`,  `LABId_LAB`, `ESTADO`) VALUES (\""
                    + object.getId_Equipo() + "\",\"" + object.getNombre_Equipo() + "\",\"" + object.getDescripcion_Equipo() + "\",\"" + object.getLabId_Lab()
                    + "\",\"" + object.getEstado() + "\")");
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

    public boolean leer(Equipo par) {

        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM EQUIPO "
                    + "WHERE ID_EQUIPO = '" + par.getId_Equipo()
                    + "' AND NOMBRE_EQUIPO = '" + par.getNombre_Equipo()
                    + "' AND DESCRIPCION_EQUIPO = '" + par.getDescripcion_Equipo()
                    + "' AND LABId_LAB = '" + par.getLabId_Lab()
                    + "'"
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

    public boolean actualizar(Equipo oldEquipo, Equipo newEquipo) {

        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE EQUIPO "
                    + " SET ID_EQUIPO  = '" + newEquipo.getId_Equipo() + "' , "
                    + " NOMBRE_EQUIPO  = '" + newEquipo.getNombre_Equipo() + "' , "
                    + " DESCRIPCION_EQUIPO= '" + newEquipo.getDescripcion_Equipo() + "' , "
                    + " LABId_LAB = '" + newEquipo.getLabId_Lab()
                    + "' WHERE ID_EQUIPO  = '" + oldEquipo.getId_Equipo()
                    + "' AND NOMBRE_EQUIPO  = '" + oldEquipo.getNombre_Equipo()
                    + "' AND  DESCRIPCION_EQUIPO = '" + oldEquipo.getDescripcion_Equipo()
                    + "' AND LABId_LAB= '" + oldEquipo.getLabId_Lab()
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

    public boolean eliminar(Equipo object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM EQUIPO "
                    + " WHERE ID_EQUIPO  = '" + object.getId_Equipo()
                    + "' AND  NOMBRE_EQUIPO = '" + object.getNombre_Equipo()
                    + "' AND  DESCRIPCION_EQUIPO = '" + object.getDescripcion_Equipo()
                    + "' AND LABId_LAB= '" + object.getLabId_Lab()
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

    public DefaultComboBoxModel llenar_ComboActualizarEquipo(String equipo) {
        Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel listaEquipos = new DefaultComboBoxModel();
        listaEquipos.addElement(equipo);

        String sqlBusqueda = "SELECT * FROM loginapp.EQUIPO WHERE ID_EQUIPO != '" + equipo + "'";

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
            JOptionPane.showMessageDialog(null, "Error al encontrar Equipo", "Error Equipo", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return listaEquipos;
    }

    public DefaultComboBoxModel llenar_ComboEstadoEquipo(String equipo) {

        DefaultComboBoxModel listaEquipos = new DefaultComboBoxModel();
        listaEquipos.addElement(equipo);
        return listaEquipos;
    }

    public DefaultComboBoxModel llenar_Combo() {
        Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel listaLabs = new DefaultComboBoxModel();
        listaLabs.addElement("Seleccione una placa del Equipo");
        String sqlBusqueda = "SELECT * FROM loginapp.EQUIPO";

        int resultSet;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlBusqueda);

            while (result.next()) {
                listaLabs.addElement(result.getString("ID_EQUIPO"));

            }
            result.close();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            JOptionPane.showMessageDialog(null, "Error al encontrar la placa del equipo", "Error Id Equipos", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return listaLabs;
    }

    public DefaultComboBoxModel llenar_Busqueda() {

        DefaultComboBoxModel listaLabs = new DefaultComboBoxModel();
        listaLabs.addElement("Seleccione una opcion");
        listaLabs.addElement("Placa");
        listaLabs.addElement("Nombre");
        listaLabs.addElement("Descripcion");
        listaLabs.addElement("Laboratorio");
        listaLabs.addElement("Estado");
        listaLabs.addElement("Descripcion Estado");

        return listaLabs;
    }

    public DefaultComboBoxModel llenar_BusquedaEstado() {

        DefaultComboBoxModel listaEstado = new DefaultComboBoxModel();
        listaEstado.addElement("Activo");
        listaEstado.addElement("Inactivo");
        listaEstado.addElement("Suspendido");

        return listaEstado;
    }

    public DefaultTableModel mostrar() {

        String sql = "SELECT * FROM loginapp.EQUIPO";
        DefaultTableModel model = new DefaultTableModel();

        String[] dato = new String[6];

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

                model.addRow(dato);
            }
        } catch (Exception e) {
        }
        return model;
    }
}
