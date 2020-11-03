package DAO;


import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    static final String DB_URL = "jdbc:mysql://database-1.c7rq75crtpaq.us-east-1.rds.amazonaws.com:3306/loginapp"; //Endpoint //Cambia dependiendo de cada usuario
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWORD = "Ojopescado#4170";

    public boolean crear(Usuario object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        Usuario usuario = new Usuario();
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO USUARIO( `USERNAME`, `PASS`) VALUES (\""
                    + object.getUserName()+ "\",\"" + object.getPass()+ "\")");
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
                    + "' AND PASS='" + par.getPass()+ "'");
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
                    + "SET USERNAME = '" + newUser.getUserName()+ "' , "
                    + "PASSWORD = '" + newUser.getPass()
                    + "' WHERE USERNAME='" + oldUser.getUserName()
                    + "' AND PASS='" + oldUser.getPass()+ "';");
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
            resultSet=-1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM USUARIO "
                    + "WHERE USERNAME='" + object.getUserName()
                    + "' AND PASS='" + object.getPass()+ "';");
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