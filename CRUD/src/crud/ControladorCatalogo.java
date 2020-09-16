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


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author EQUIPO
 */
public class ControladorCatalogo implements ActionListener {
    ModeloCatalogo modelo;
    VistaCatalogo vista;

    public ControladorCatalogo(ModeloCatalogo modelo, VistaCatalogo vista) {
        this.modelo = modelo;
        this.vista = vista;
       
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==vista.BtnGrabar) 
        {
            if (modelo.insertar
                (   
                    vista.getRFC(),
                    vista.getNombre(),
                    vista.getIDCiudad(),
                    vista.getEdad()
                )
            )
            {
                vista.correcto();
            }
            
            return;
	}
        
        else if(e.getSource()==vista.BtnBorrar) 
        {
            if (modelo.borrar
                (
                    vista.getRFC()
                )
            )
            {
                vista.correcto();
            }
            return;
	}
        
        else if (e.getSource()==vista.BtnModificar)
        {
            if(modelo.modificar(vista.getRFC(), vista.getNombre(), vista.getEdad(), vista.getIDCiudad()))
            {
                vista.correcto();
            }
        }
        
        else if (e.getSource()==vista.BtnRecuperar)
        {
            CatalogoDeClientes catalogoDeClientes = modelo.recuperar(vista.getRFC());
            if (catalogoDeClientes.esValido())
            {
                vista.actualizaDatos(catalogoDeClientes);
                vista.correcto();
            }
 
        
        }
       
    }
}
