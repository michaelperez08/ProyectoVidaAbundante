/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

/**
 *
 * @author michael
 */
public class Telefono {
    
    public int idTelefono;
    public int idPersona;
    public String Categoria;
    public String Numero;

    public Telefono(int idTelefono, int idPersona, String Categoria, String Numero) {
        this.idTelefono = idTelefono;
        this.idPersona = idPersona;
        this.Categoria = Categoria;
        this.Numero = Numero;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }
    
}
