package DAO;

import Entidad.Mantenimiento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class MantenimientoDAO {

    static final String DB_URL = "jdbc:mysql://project.c7rq75crtpaq.us-east-1.rds.amazonaws.com/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";

    public boolean crear(Mantenimiento object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        Mantenimiento mant = new Mantenimiento();
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            resultSet = statement.executeUpdate("INSERT INTO MANTENIMIENTO( `FECHA_MANTENIMIENTO`,`NOMBRE_MANTENIMIENTO`, `DESCRIPCION_MANTENIMIENTO`,`EQUIPOId_Equipo`,`PERIFERICOId_Periferico`) VALUES (\""
                    + object.getFecha_Mantenimiento() + "\",\"" + object.getNombre_Mantenimiento() + "\",\"" + object.getDescripcion_Mantenimiento() 
                    + "\",\"" + object.getId_equipo() + "\",\"" + object.getId_periferico() + "\")");

            return resultSet > 0;
        } catch (SQLException ex) {

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

    public boolean leer(Mantenimiento par) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM MANTENIMIENTO"
                    + "  WHERE FECHA_MANTENIMIENTO = '" + par.getFecha_Mantenimiento()
                    + "'  AND NOMBRE_MANTENIMIENTO = '" + par.getNombre_Mantenimiento()
                    + "'  AND DESCRIPCION_MANTENIMIENTO = '" + par.getDescripcion_Mantenimiento()
                    + "'  AND EQUIPOId_Equipo= '" + par.getId_equipo()
                    + "' AND PERIFERICOId_Periferico = '" + par.getId_periferico() + "'"
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

    public boolean actualizar(Mantenimiento oldMant, Mantenimiento newMant) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE MANTENIMIENTO "
                    + " SET FECHA_MANTENIMIENTO = '" + newMant.getFecha_Mantenimiento() + "' , "
                    + " NOMBRE_MANTENIMIENTO  = '" + newMant.getNombre_Mantenimiento() + "' , "
                    + " DESCRIPCION_MANTENIMIENTO  = '" + newMant.getDescripcion_Mantenimiento() + "' , "
                    + " EQUIPOId_Equipo  = '" + newMant.getId_equipo() + "' , "
                    + " PERIFERICOId_Periferico = '" + newMant.getId_periferico()
                    + "' WHERE FECHA_MANTENIMIENTO = '" + oldMant.getFecha_Mantenimiento()
                    + "' AND NOMBRE_MANTENIMIENTO = '" + oldMant.getNombre_Mantenimiento()
                    + "' AND DESCRIPCION_MANTENIMIENTO = '" + oldMant.getDescripcion_Mantenimiento()
                    + "' AND EQUIPOId_Equipo = '" + oldMant.getId_equipo()
                    + "' AND PERIFERICOId_Periferico= '" + oldMant.getId_periferico()
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

    public boolean eliminar(Mantenimiento object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM MANTENIMIENTO "
                    + "WHERE FECHA_MANTENIMIENTO = '" + object.getFecha_Mantenimiento()
                    + "' AND NOMBRE_MANTENIMIENTO = '" + object.getNombre_Mantenimiento()
                    + "' AND DESCRIPCION_MANTENIMIENTO = '" + object.getDescripcion_Mantenimiento()
                    + "' AND EQUIPOId_Equipo = '" + object.getId_equipo()
                    + "' AND PERIFERICOId_Periferico= '" + object.getId_periferico()
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

}
