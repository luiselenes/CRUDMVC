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
        if(edad!=0 && idCiudad!=0 && nombre!=null && validaRFC(rfc))
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
        if (validaRFC(rfc))
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
        if(edad!=0 && idCiudad!=0 && nombre!=null && validaRFC(rfc))
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
