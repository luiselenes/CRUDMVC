/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

/**
 *
 * @author Tania Nafarrate B
 */
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class VistaCatalogo extends JFrame{
    
        JTextField RFC;
	JTextField Nombre;
	JTextField Edad;
	JTextField IDCiudad;
	
	JLabel ERFC;
	JLabel ENombre;
	JLabel EEdad;
	JLabel EIDCiudad;
	
	JButton BtnGrabar;
	JButton BtnBorrar;
	JButton BtnRecuperar;
	JButton BtnModificar;
	JButton BtnConsultar;
	
	public VistaCatalogo() {
		super("Catalogo de Clientes");
		HazInterfaz();
	}
	private void HazInterfaz() 
        {
		setSize(250,150);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2));
		RFC=new JTextField();
		Nombre=new JTextField();
		Edad=new JTextField();
		IDCiudad=new JTextField();
               
		
		BtnGrabar=new JButton("Grabar");
		BtnBorrar=new JButton("Borrar");
		BtnRecuperar = new JButton("Recuperar");
		BtnModificar = new JButton("Modificar");
		BtnConsultar = new JButton("Consultar");
		
		add(ERFC=new JLabel("RFC: "));
		add(RFC);
		
		add(ENombre=new JLabel("Nombre: "));
		add(Nombre);
		
		add(EEdad=new JLabel("Edad: "));
		add(Edad);
		
		add(EIDCiudad=new JLabel("ID de Ciudad: "));
		add(IDCiudad);
		
		add(BtnGrabar);
		add(BtnBorrar);
		add(BtnRecuperar);
		add(BtnModificar);
		add(BtnConsultar);	
		
        }       
    public String getRFC() 
    {
        return RFC.getText();
    }

    public String getNombre() 
    {
        return Nombre.getText();
    }

    public int getEdad() 
    {
        return Integer.parseInt(Edad.getText());
    }

    public int getIDCiudad() 
    {
        return Integer.parseInt(IDCiudad.getText());
    }
           
        
         public void setControlador(ControladorCatalogo c) {
		BtnGrabar.addActionListener(c);
		BtnBorrar.addActionListener(c);
		BtnRecuperar.addActionListener(c);
		BtnModificar.addActionListener(c);
                BtnConsultar.addActionListener(c);
         }
	public void Muestrate() 
        {
            setVisible(true);
	}
	
       public void correcto()
        {
           JOptionPane.showMessageDialog(null, "Se ha realizado de manera correcta la operacion");
        }

    public void setNombre(String Nombre) {
        this.Nombre = new JTextField(Nombre);
    }

    public void setEdad(int Edad) {
        this.Edad = new JTextField(Integer.toString(Edad));
    }

    public void setIDCiudad(int IDCiudad) {
        this.IDCiudad = new JTextField(Integer.toString(IDCiudad));
    }
    
    public void actualizaDatos(CatalogoDeClientes cliente)
    {
        this.setNombre(cliente.getNombre());
        this.setEdad(cliente.getEdad());
        this.setIDCiudad(cliente.IDCiudad);
    }
    
    
    
}
