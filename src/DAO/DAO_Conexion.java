/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author michael
 */
public class DAO_Conexion {
    
    public static String servidor = System.getProperty("servidor");
    public static String usuarioDB = System.getProperty("usuarioDB");
    public static String nombreDB = System.getProperty("nombreDB");
    public static String passwordDB = System.getProperty("passwordDB");

    public DAO_Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println(e.toString());

        }

    }

    public static Connection nuevaConexion() {
        try {
            return DriverManager.getConnection("jdbc:mysql://"+servidor+":3306/"+nombreDB, usuarioDB, passwordDB);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static boolean probarConeccion() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://"+servidor+":3306/"+nombreDB, usuarioDB, passwordDB)) {
            return true;
        } catch (SQLException e) {
            System.err.println("Cannot connect the database!"+ e);
            return false;
        }
        
    }
    
}
