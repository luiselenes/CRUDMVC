/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.util.ArrayList;

/**
 *
 * @author EQUIPO
 */
public class ModeloCatalogo 
{
    DALCatalogo dalCatalogo;

    public ModeloCatalogo() 
    {
        this.dalCatalogo = new DALCatalogo();
    }
    
    public boolean insertar(String rfc, String nombre, int edad, int idCiudad)
    {
        if(edad!=0 && idCiudad!=0 && nombre!=null && validaRFC())
        {
            
            return dalCatalogo.insertar(rfc, nombre, edad, idCiudad);
           
        }
    
        return false;
    }
    
    public boolean borrar(String rfc)
    {
        if (validaRFC())
        {
            return dalCatalogo.borrar(rfc);
        }
        else
        {
            return false;
        }
    }
    
    public boolean validaRFC()
    {
        
       return true;
    }
    
    public CatalogoDeClientes recuperar(String rfc)
    {
        if (validaRFC())
        {
            return dalCatalogo.selectcliente(rfc);
        }
        else
        {
            return null;
        }
    }
    public boolean modificar(String rfc, String nombre, int edad, int idCiudad)
    {
        if(edad!=0 && idCiudad!=0 && nombre!=null && validaRFC())
        {
            return dalCatalogo.modificar(rfc, nombre, edad, idCiudad);
        }
        else
        {
            return false;
        }
    }
    
    public ArrayList<CatalogoDeClientes> consultar()
    {
        return dalCatalogo.select();
    }
    
}
