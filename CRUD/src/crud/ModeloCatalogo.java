/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.awt.List;
import java.sql.Array;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        if(edad!=0 && idCiudad!=0 && !nombre.equals("") && validaRFC(rfc))
        {
            
            return dalCatalogo.insertar(rfc, nombre, edad, idCiudad);
           
        }
        else
        {
           
        return false;
        }
    }
    
    public boolean borrar(String rfc)
    {
        if (validaRFC(rfc))
        {
            return dalCatalogo.borrar(rfc);
        }
        else
        {
           
            return false;
        }
    }
    
    public boolean validaRFC(String rfc){
          if(rfc.length() !=10 || rfc== ""){
            return false;
            } 
          else{
            rfc=rfc.toUpperCase().trim();
            return rfc.toUpperCase().matches("[A-Z]{4}[0-9]{6}");
             }   
         }
    public CatalogoDeClientes recuperar(String rfc)
    {
        CatalogoDeClientes catalogoDeClientes = new CatalogoDeClientes();
        if (validaRFC(rfc))
        {
            catalogoDeClientes = dalCatalogo.selectcliente(rfc);
        }
        return catalogoDeClientes;
    }
    public boolean modificar(String rfc, String nombre, int edad, int idCiudad)
    {
        if(edad!=0 && idCiudad!=0 && !nombre.equals("") && validaRFC(rfc))
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
