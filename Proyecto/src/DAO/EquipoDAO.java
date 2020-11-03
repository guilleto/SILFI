package DAO;


import Entidad.Equipo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EquipoDAO {

    static final String DB_URL = "jdbc:mysql://database-1.c7rq75crtpaq.us-east-1.rds.amazonaws.com:3306/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";

    public boolean crear(Equipo object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        Equipo equipo = new Equipo();
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO EQUIPO( `ID_EQUIPO`,`NOMBRE_EQUIPO`, `DESCRIPCION_EQUIPO`, `ULTIMO_MANTENIMIENTO`) VALUES (\""
                    + object.getId_Equipo()+ "\",\""+ object.getNombre_Equipo()+ "\",\"" + object.getDescripcion_Equipo()+ "\",\"" + object.getMantenimiento()+ "\")");
            return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
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
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM EQUIPO "
                    + "WHERE ID_EQUIPO = '" + par.getId_Equipo()
                    + "AND NOMBRE_EQUIPO = '" + par.getNombre_Equipo()
                    + "' AND DESCRIPCION_EQUIPO = '" + par.getDescripcion_Equipo()+ "'"
                    + "' AND MANTENIMIENTO = '" + par.getMantenimiento()+ "'"
                    + "' AND LAB = '" + par.getLabId_Lab()+ "'"
            );
            if(resultSet.next()){
                return true;
            }else{
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

    public boolean actualizar(Equipo oldId,Equipo newId, Equipo oldEquipo, Equipo newEquipo
    ) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE EQUIPO "
                    + "SET ID_EQUIPO = '" + newEquipo.getId_Equipo()+ "' , "
                    + " NOMBRE_EQUIPO = '" + newEquipo.getNombre_Equipo()+ "' , "
                    + "DESCRIPCION_EQUIPO = '" + newEquipo.getDescripcion_Equipo()
                    + "MANTENIMIENTO= '" + newEquipo.getMantenimiento()
                    
                    
                    + "' WHERE ID_EQUIPO='" + oldEquipo.getId_Equipo()
                    + "' AND NOMBRE_EQUIPO='" + oldEquipo.getNombre_Equipo()
                    + "' AND DESCRIPCION_EQUIPO='" + oldEquipo.getDescripcion_Equipo()
                    + "' AND MANTENIMIENTO= '" + oldEquipo.getMantenimiento()
                   
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
            resultSet=-1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM EQUIPO "
                    + "WHERE ID_EQUIPO ='" + object.getId_Equipo()
                    + "AND NOMBRE_EQUIPO = '" + object.getNombre_Equipo()
                    + "' AND DESCRIPCION_EQUIPO ='" + object.getDescripcion_Equipo()
                    + "' AND MANTENIMIENTO_EQUIPO ='" + object.getMantenimiento()
                   
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