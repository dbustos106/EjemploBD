package DAO;

import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    static final String DB_URL
            = "jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC ";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "EHCkez99";

    public UsuarioDAO(){
        
    }
    
    public boolean crear(Usuario object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        Usuario usuario = new Usuario();
        try {
            resultSet = -1;
            System.out.println("hola");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO Usuario( `NOMBRE`, `PASSWORD`) VALUES (\""
                    + object.getNombre() + "\",\"" + object.getPassword() + "\")");
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
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Usuario "
                    + "WHERE NOMBRE = '" + par.getNombre()
                    + "' AND PASSWORD='" + par.getPassword() + "'");
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
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("UPDATE Usuario "
                    + "SET NOMBRE = '" + newUser.getNombre() + "' , "
                    + "PASSWORD = '" + newUser.getPassword()
                    + "' WHERE NOMBRE='" + oldUser.getNombre()
                    + "' AND PASSWORD='" + oldUser.getPassword() + "';");
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
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM Usuario "
                    + "WHERE NOMBRE='" + object.getNombre()
                    + "' AND PASSWORD='" + object.getPassword() + "';");
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


/*
package amnesiabar.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

public class ModeloBD {
    private static ModeloBD instanciaUnica;
    private Connection conexion;
    private final String SERVIDOR = "jdbc:mysql://localhost/proyecto?useUnicode=true&useJDBCCompliantTimezoneShift=true&"
                                    + "useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    private ModeloBD(){ }
    
    public static ModeloBD getInstancia(){
        if (instanciaUnica == null) {
            instanciaUnica = new ModeloBD();
        }
        return instanciaUnica;
    }

    public int realizarConexion(String usuario, String clave) throws ClassNotFoundException, SQLException{
        conexion = null;
        Statement st = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection(SERVIDOR, usuario, clave);
        st = conexion.createStatement();
        String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'proyecto'";
        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            switch (usuario){
                case "HectorRojas":
                    return 1;
                case "EmpleadoSedeExperto":
                    return 2;
                case "EmpleadoFabricaExperto":
                    return 3;
            }
        }
        return -1;
    }
    */