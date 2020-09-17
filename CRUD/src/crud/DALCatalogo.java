/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author EQUIPO
 */
public class DALCatalogo 
{   
    ConexionDB cn;

    public DALCatalogo() 
    {
        cn = new ConexionDB();
    }
    
    public boolean insertar(String rfc,String nombre,int edad,int idciudad )
    {
        Connection con= cn.Getconexion();
        try 
        {
            PreparedStatement ps = con.prepareCall("exec sp_registrarcliente ?,?,?,?");
            ps.setString(1, rfc);
            ps.setString(2, nombre);
            ps.setInt(3,edad);
            ps.setInt(4,idciudad);
            ps.execute();
            
            con.close();
            con = null;
            return true;

        }
        catch (SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        
    }
        //------------------------------------------------------------------------------------------------------
    public boolean modificar(String rfc,String nombre,int edad,int idciudad )
    {
        try {
            Connection con =  cn.Getconexion();
            PreparedStatement ps = con.prepareCall("exec sp_modificarcliente ?,?,?,?");
            ps.setString(1,rfc);
            ps.setString(2,nombre);
            ps.setInt(3,edad);
            ps.setInt(4,idciudad);
            ps.execute();
            con.close();
            con = null;
            return true;
        } 
        catch (SQLException ex) 
        {
            java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean borrar(String rfc)
    {
        try
        {
            Connection con = cn.Getconexion();
            PreparedStatement ps = con.prepareCall("exec sp_eliminarcliente ?");
            ps.setString(1, rfc);
            ps.execute();
            con.close();
            con = null;
            return true;

        } 
        catch (SQLException ex) 
        {
            java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
       //------------------------------------------------------------------------------------------------------//------------------------------------------------------------------------------------------------------
       
    public ArrayList<CatalogoDeClientes> select()
    {
        ArrayList<CatalogoDeClientes> listaCatalogoClientes = new ArrayList<CatalogoDeClientes>();
        try 
        {
            Connection con = cn.Getconexion();
            PreparedStatement ps = con.prepareCall("exec sp_selectclientes");
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                
                CatalogoDeClientes catalogoDeClientes = new CatalogoDeClientes();
                catalogoDeClientes.setRFC(rs.getString(1));
                catalogoDeClientes.setNombre(rs.getString(2));
                catalogoDeClientes.setEdad(rs.getInt(3));
                catalogoDeClientes.setIDCiudad(rs.getInt(4));
                listaCatalogoClientes.add(catalogoDeClientes);
                
            }
        con.close();
        con = null;
        return listaCatalogoClientes;
        
        }
        catch (SQLException ex) 
        {
            java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            
    }
       //---------------------------------------------------------------------------- 
    public CatalogoDeClientes selectcliente(String rfc)
    {
        CatalogoDeClientes catalogo = new CatalogoDeClientes();
        catalogo.setRFC(rfc);
        try 
        {
            Connection con = cn.Getconexion();
            PreparedStatement ps = con.prepareCall("exec sp_selectcliente ?");
            ps.setString(1,rfc);
            ResultSet rs= ps.executeQuery();
            
            while(rs.next())
            {
                catalogo.setNombre(rs.getString(1));
                catalogo.setEdad(rs.getInt(2));
                catalogo.setIDCiudad(rs.getInt(3));
            }
            
        return catalogo;

        } 
        catch (SQLException ex) 
        {
            java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    } 
}
