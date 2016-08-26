/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAO.DAO_Persona;
import TO.TO_Persona;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author michael
 */
public class BL_Persona {
    
    public int idPersona;
    public String Nombre;
    public String PrimerApellido;
    public String SegundoApellido;
    public Date FechaNacimiento;
    public String Direccion;
    public String Correo;
    public boolean discipulo;
    public BL_Telefono Telefono;

    //Listas
    ArrayList<TO_Persona> top;
    ArrayList<BL_Persona> blp;
    
    public BL_Persona() {
    }
    
    public BL_Persona(int idPersona, String Nombre, String PrimerApellido, String SegundoApellido, Date FechaNacimiento, String Direccion, String Correo, boolean discipulo, BL_Telefono Telefono) {
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

    public BL_Persona(String Nombre, String PrimerApellido, String SegundoApellido, Date FechaNacimiento, String Direccion, String Correo, boolean discipulo, BL_Telefono Telefono) {
        this.Nombre = Nombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.FechaNacimiento = FechaNacimiento;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.discipulo = discipulo;
        this.Telefono = Telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public BL_Telefono getTelefono() {
        return Telefono;
    }

    public void setTelefono(BL_Telefono Telefono) {
        this.Telefono = Telefono;
    }
    
    public ArrayList<BL_Persona> cargarPersonas(){
        DAO_Persona daop = new DAO_Persona();
        blp = new ArrayList<>();
        top = daop.getListaPersonas();
        for (TO_Persona temp : top) {
            blp.add(new BL_Persona(temp.idPersona, temp.Nombre, temp.PrimerApellido, temp.SegundoApellido, temp.FechaNacimiento, 
                    temp.Direccion, temp.Correo, temp.discipulo, null));
        }
        return blp;
    }
    
    public BL_Persona personaPorId(int id, ArrayList<BL_Persona> listblp){
        for (BL_Persona perstemp : listblp) {
            if(perstemp.idPersona == id){
                return perstemp;
            }
        }
        return null;
    }
    
    public boolean ingresarPersona(){
        DAO_Persona daop = new DAO_Persona();
        return daop.ingresarPersona(new TO_Persona(Nombre, PrimerApellido, SegundoApellido, FechaNacimiento, Direccion, Correo, discipulo, null));
    }
    
}
