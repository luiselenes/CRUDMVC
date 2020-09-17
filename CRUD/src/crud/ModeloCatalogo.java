/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.awt.List;
import java.sql.Array;
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
    
    public Object[] consultar(int i)
    {
        
        VistaConsulta vista=new VistaConsulta();
        ArrayList list = new ArrayList();
        Object [] ob = new Object[4];
            ob[0]=dalCatalogo.select().get(i).RFC;
            ob[1]=dalCatalogo.select().get(i).Nombre;
            ob[2]=dalCatalogo.select().get(i).Edad;
            ob[3]=dalCatalogo.select().get(i).IDCiudad;
          return ob;
    }
    public int longitud(){
        int l = dalCatalogo.select().size();
                return l ;   
    }
    
    
}
