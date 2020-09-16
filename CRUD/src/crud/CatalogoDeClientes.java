/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

/**
 *
 * @author EQUIPO
 */
public class CatalogoDeClientes {
    String RFC;
    String Nombre;
    int Edad;
    int IDCiudad;

    public CatalogoDeClientes(String RFC, String Nombre, int Edad, int IDCiudad) {
        this.RFC = RFC;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.IDCiudad = IDCiudad;
    }

    public CatalogoDeClientes() {
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getIDCiudad() {
        return IDCiudad;
    }

    public void setIDCiudad(int IDCiudad) {
        this.IDCiudad = IDCiudad;
    }
    
    public boolean esValido()
    {
        if (this.Edad != 0 && this.IDCiudad != 0 && this.Nombre != null && this.RFC != null )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
