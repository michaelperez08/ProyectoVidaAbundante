/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAO.DAO_Usuario;

/**
 *
 * @author michael
 */
public class BL_Usuario {
    
    public int idUsuario;
    public String NombreUsuario;
    public String Contrasena;

    public BL_Usuario(int idUsuario, String NombreUsuario, String Contrasena) {
        this.idUsuario = idUsuario;
        this.NombreUsuario = NombreUsuario;
        this.Contrasena = Contrasena;
    }

    public BL_Usuario(String NombreUsuario, String Contrasena) {
        this.NombreUsuario = NombreUsuario;
        this.Contrasena = Contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    public boolean iniciarSesion(){
    
        DAO_Usuario daou = new DAO_Usuario();
        return daou.checkInicioSesion(this.NombreUsuario, this.Contrasena);
    }
    
}
