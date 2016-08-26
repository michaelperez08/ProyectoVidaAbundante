/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import TO.*;
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
public class DAO_Usuario {

    public Connection conexion;
    public PreparedStatement cmd;
    public ResultSet rs;

    public boolean checkInicioSesion(String NombreUsuario, String Contraseña) {
        boolean inicioSesion = false;
        try {

            try {
                if (conexion == null || conexion.isClosed()) {
                    conexion = DAO_Conexion.nuevaConexion(); //nuevaConexion metodo estatico para obtener nueva coneccion
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            cmd = conexion.prepareStatement(
                    "select\n"
                    + "	case count(*) \n"
                    + "		when 1 then true\n"
                    + "		else false\n"
                    + "	end as InicioSesion\n"
                    + "from Usuario where NombreUsuario = ? and Contrasena = ?;");
            cmd.setString(1, NombreUsuario);
            cmd.setString(2, Contraseña);

            rs = cmd.executeQuery();
            while (rs.next()) {
                inicioSesion = rs.getBoolean("InicioSesion");
                return inicioSesion;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return inicioSesion;
    }

    public boolean guardarUsuario(String nombreUsuario, String contrasena, boolean admin) {
        try {

            try {
                if (conexion == null || conexion.isClosed()) {
                    conexion = DAO_Conexion.nuevaConexion();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            cmd = conexion.prepareStatement("insert into Usuario(NombreUsuario, Contrasena, Administrador) values (?,?,?);");
            cmd.setString(1, nombreUsuario);
            cmd.setString(2, contrasena);
            cmd.setBoolean(3, admin);
            cmd.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean eliminarUsuario(int id) {
        try {

            try {
                if (conexion == null || conexion.isClosed()) {
                    conexion = DAO_Conexion.nuevaConexion();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            cmd = conexion.prepareStatement("delete from Usuario where idUsuario = ?;");
            cmd.setInt(1, id);
            cmd.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ArrayList<TO_Usuario> getListaUsuarios() {
        ArrayList<TO_Usuario> listaTou = new ArrayList<>();
        try {

            try {
                if (conexion == null || conexion.isClosed()) {
                    conexion = DAO_Conexion.nuevaConexion();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            cmd = conexion.prepareStatement("select * from Usuario;");
            rs = cmd.executeQuery();

            while (rs.next()) {
                listaTou.add(new TO_Usuario(rs.getInt("idUsuario"), rs.getString("NombreUsuario"), rs.getBoolean("Administrador")));
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
        return listaTou;
    }

    public int getCantidadUsuarios() {
        int retorno = -1;
        try {

            try {
                if (conexion == null || conexion.isClosed()) {
                    conexion = DAO_Conexion.nuevaConexion();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            cmd = conexion.prepareStatement("select count(*) as cantidad from Usuario limit 1;");
            rs = cmd.executeQuery();

            while (rs.next()) {
                retorno = rs.getInt("cantidad");
            }

            return retorno;

        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }

}
