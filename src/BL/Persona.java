/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.Date;

/**
 *
 * @author michael
 */
public class Persona {
    
    public int idPersona;
    public String Nombre;
    public String PrimerApellido;
    public String SegundoApellido;
    public Date FechaNacimiento;
    public String Direccion;
    public String Correo;
    public boolean discipulo;
    public Telefono Telefono;

    public Persona(int idPersona, String Nombre, String PrimerApellido, String SegundoApellido, Date FechaNacimiento, String Direccion, String Correo, boolean discipulo, Telefono Telefono) {
        this.idPersona = idPersona;
        this.Nombre = Nombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.FechaNacimiento = FechaNacimiento;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.discipulo = discipulo;
        this.Telefono = Telefono;
    }

    public Persona(String Nombre, String PrimerApellido, String SegundoApellido, Date FechaNacimiento, String Direccion, String Correo, boolean discipulo, Telefono Telefono) {
        this.Nombre = Nombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.FechaNacimiento = FechaNacimiento;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.discipulo = discipulo;
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public boolean isDiscipulo() {
        return discipulo;
    }

    public void setDiscipulo(boolean discipulo) {
        this.discipulo = discipulo;
    }

    public Telefono getTelefono() {
        return Telefono;
    }

    public void setTelefono(Telefono Telefono) {
        this.Telefono = Telefono;
    } 
    
    
}
