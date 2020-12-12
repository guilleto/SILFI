package DAO;

import Entidad.Periferico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class PerifericoDAO {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";
    Connection connection = null;
    Statement statement = null;

    public boolean crear(Periferico object) {

        int resultSet;
        Periferico periferico = new Periferico();
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO PERIFERICO( `ID_PERIFERICO`,`NOMBRE_PERIFERICO`, `DESCRIPCION`,  `EQUIPOID_EQUIPO`, `ESTADO`, `DESCRIPCION_ESTADO`) VALUES (\""
                    + object.getId_Periferico() + "\",\"" + object.getNombre_Periferico() + "\",\"" + object.getDescripcion() + "\",\"" + object.getEquipoId_Equipo()
                    + "\",\"" + object.getEstado() + "\",\"" + object.getEstadoDescripcion() + "\")");
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

    public DefaultComboBoxModel llenar_ComboPeriferico() {
      Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel listaEquipos = new DefaultComboBoxModel();
        listaEquipos.addElement("Seleccione Periferico");
        String sqlBusqueda = "SELECT * FROM loginapp.PERIFERICO";

        int resultSet;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlBusqueda);

            while (result.next()) {
                listaEquipos.addElement(result.getString("ID_PERIFERICO"));

            }
            result.close();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            JOptionPane.showMessageDialog(null, "Error al encontrar Periferico", "Error Periferico", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return listaEquipos;
    }

    public DefaultComboBoxModel llenar_BusquedaPeriferico() {

        DefaultComboBoxModel listaPeriferico = new DefaultComboBoxModel();
        listaPeriferico.addElement("Seleccione una opcion");
        listaPeriferico.addElement("Id");
        listaPeriferico.addElement("Nombre");
        listaPeriferico.addElement("Descripcion");
        listaPeriferico.addElement("Equipo");
        listaPeriferico.addElement("Estado");
        listaPeriferico.addElement("Descripcion Estado");
        return listaPeriferico;
    }

    public DefaultComboBoxModel llenar_ComboActualizarPeriferico(String periferico) {
        Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel listaPeriferico = new DefaultComboBoxModel();
        listaPeriferico.addElement(periferico);

        String sqlBusqueda = "SELECT * FROM loginapp.PERIFERICO WHERE ID_PERIFERICO != '" + periferico + "'";

        int resultSet;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlBusqueda);

            while (result.next()) {
                listaPeriferico.addElement(result.getString("ID_PERIFERICO"));

            }
            result.close();
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            JOptionPane.showMessageDialog(null, "Error al encontrar Periferico", "Error Equipo", JOptionPane.ERROR_MESSAGE);
            //return false;
        }
        return listaPeriferico;
    }
}
