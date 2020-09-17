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
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EQUIPO
 */
public class ControladorCatalogo implements ActionListener {
    ModeloCatalogo modelo;
    VistaCatalogo vista;
    VistaConsulta vistaconsulta;

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
                    vista.getEdad(),
                    vista.getIDCiudad()
                )
            )
            {
                vista.correcto();
            }
            else
            {
              //  vista.RFCINCORRECTO();
                vista.incorrecto();
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
            else
            {
            // vista.RFCINCORRECTO();
             vista.incorrecto();
            }
            return;
	}
        
        else if (e.getSource()==vista.BtnModificar)
        {
            if(modelo.modificar(vista.getRFC(), vista.getNombre(), vista.getEdad(), vista.getIDCiudad()))
            {
                vista.correcto();
            }
            else 
            {
                vista.RFCINCORRECTO();
                vista.incorrecto();
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
            else 
            {
                vista.incorrecto();
            }
 
        
        }
        else if (e.getSource()== vista.BtnConsultar)
        {
          vistaconsulta =new VistaConsulta();
            vistaconsulta.HazInterfaz();
            for (int i = 0; i <modelo.longitud(); i++) {
           vistaconsulta.drm.addRow(modelo.consultar(i));
           
        }
            //aqui implementarias lo del grid con los datos de la tabla, listaCatalogo trae todos los registros
            //de la tabla
        }
       
    }
}
