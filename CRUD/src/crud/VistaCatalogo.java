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
import java.awt.Container;
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
              
                setSize(500,200);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 JPanel Panelizq=new JPanel();
                 
                JPanel PanelDer= new JPanel();
              
		setLayout(new GridLayout(0,2,20,30));
  
        
		RFC=new JTextField();
                
		Nombre=new JTextField();
		Edad=new JTextField();
		IDCiudad=new JTextField();
                
                ERFC=new JLabel("RFC: ");
                ENombre=new JLabel("Nombre: ");
                EEdad=new JLabel("Edad: ");
		EIDCiudad=new JLabel("ID de Ciudad: ");
                        
		BtnGrabar=new JButton("Grabar");
		BtnBorrar=new JButton("Borrar");
		BtnRecuperar = new JButton("Recuperar");
		BtnModificar = new JButton("Modificar");
		BtnConsultar = new JButton("Consultar"); 
             
                        
           
                Panelizq.setLayout(new GridLayout(3,2,15,20));
 
                Panelizq.add(ERFC=new JLabel("RFC: "));
		Panelizq.add(RFC);
                Panelizq.add(BtnRecuperar);
                Panelizq.add(BtnBorrar);
                add (Panelizq);
                
                
                PanelDer.setLayout(new GridLayout(0,2,15,20));
                
                PanelDer.add(ENombre=new JLabel("Nombre: "));
		PanelDer.add(Nombre);
		
		PanelDer.add(EEdad=new JLabel("Edad: "));
		PanelDer.add(Edad);
		
		PanelDer.add(EIDCiudad=new JLabel("ID de Ciudad: "));
		PanelDer.add(IDCiudad);
		PanelDer.add(BtnGrabar);
                PanelDer.add(BtnModificar);
		PanelDer.add(BtnConsultar);
                add(PanelDer);
                           
                RFC.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent e){
                if(RFC.getText().length() >=10){
                    e.consume();
                 }
                }
                });
                
                 Nombre.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent e){
                if(Nombre.getText().length() > 50){
                    e.consume();
                 }
                }
                });
                
                
                Edad.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent e){
                char caracter = e.getKeyChar();
                 if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume(); 
                       }
                 }
                });
                
                IDCiudad.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent e){
                char caracter = e.getKeyChar();
                 if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume(); 
                       }
                 }
                });
                
		
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
        String edad = Edad.getText().equals("") ?  "0" : Edad.getText();
        return Integer.parseInt(edad);
    }

    public int getIDCiudad() 
    {
        String idCiudad = IDCiudad.getText().equals("") ?  "0" : IDCiudad.getText() ;
        return Integer.parseInt(idCiudad);
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
       public void incorrecto()
       {
           JOptionPane.showMessageDialog(null, "Operación incorrecta");
       }
       
//       public void RFCINCORRECTO()
//       {
//       JOptionPane.showMessageDialog(null, "Ese RFC es incorrecto");
//       }
       

    public void setNombre(String Nombre) {
        this.Nombre.setText(Nombre);
    }

    public void setEdad(int Edad) {
    this.Edad.setText(Integer.toString(Edad));
    }

    public void setIDCiudad(int IDCiudad) {
        this.IDCiudad.setText(Integer.toString(IDCiudad));
    }
    
    public void actualizaDatos(CatalogoDeClientes cliente)
    {
        this.setNombre(cliente.getNombre());
        this.setEdad(cliente.getEdad());
        this.setIDCiudad(cliente.getIDCiudad());
    }
    
    
    
}
