/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import TO.TO_Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael
 */
public class DAO_Persona {

    public Connection conexion;
    public PreparedStatement cmd;
    public ResultSet rs;

    public ArrayList<TO_Persona> getListaPersonas() {
        ArrayList<TO_Persona> listaTop = new ArrayList<>();
        try {

            try {
                if (conexion == null || conexion.isClosed()) {
                    conexion = DAO_Conexion.nuevaConexion();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            cmd = conexion.prepareStatement("select * from Persona;");
            rs = cmd.executeQuery();

            while (rs.next()) {
                listaTop.add(new TO_Persona(rs.getInt("idPersona"), rs.getString("Nombre"), rs.getString("PrimerApellido"),
                        rs.getString("SegundoApellido"), rs.getDate("FechaNacimiento"), rs.getString("Direccion"), rs.getString("Correo"),
                        rs.getBoolean("Discipulo"), null));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cmd.close();
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaTop;
    }

    public boolean ingresarPersona(TO_Persona top) {
        try {

            try {
                if (conexion == null || conexion.isClosed()) {
                    conexion = DAO_Conexion.nuevaConexion();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Persona.class.getName()).log(Level.SEVERE, null, ex);
            }

            cmd = conexion.prepareStatement("Insert into Persona (Nombre, PrimerApellido, SegundoApellido, \n"
                    + "FechaNacimiento, Direccion, Correo, Discipulo) \n"
                    + " values (?,?,?,?,?,?,?);");
            cmd.setString(1, top.Nombre);
            cmd.setString(2, top.PrimerApellido);
            cmd.setString(3, top.SegundoApellido);
            cmd.setDate(4, new java.sql.Date(top.FechaNacimiento.getTime()));
            cmd.setString(5, top.Direccion);
            cmd.setString(6, top.Correo);
            System.out.println(top.discipulo);
            cmd.setBoolean(7, top.discipulo);

            cmd.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DAO_Persona.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

}
