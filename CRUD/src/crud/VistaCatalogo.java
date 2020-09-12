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
	private void HazInterfaz() {
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
		
               
              RFC.addKeyListener(new KeyAdapter() {
       
               public void keyTyped(KeyEvent e) {
                    if (RFC.getText().length() >= 10 ) // limit to 10 characters
                        e.consume();
                      }
                });
              
              Edad.addKeyListener(new KeyAdapter(){
              public void keyTyped(KeyEvent e){
              char caracter = e.getKeyChar();
              if (((caracter < '0') || (caracter > '9')))
                  e.consume();
              }
              });
              
              IDCiudad.addKeyListener(new KeyAdapter(){
              public void keyTyped(KeyEvent e){
              char caracter = e.getKeyChar();
              if (((caracter < '0') || (caracter > '9')))
                  e.consume();
              }
              });
                  
             
              
	}
           
        
        
	/*public void setControlador(ConvertidorControldor c) {
		BtnPesos.addActionListener(c);
		BtnDolares.addActionListener(c);
	}	*/
	public void Muestrate() {
		setVisible(true);
	}
	/*public float getCantidad() {
		try {
			return Float.parseFloat(Txt.getText());
		}catch (Exception E) {
			return 0;
		}
	}
	public void setResultado(float Cantidad) {
		Resultado.setText(Cantidad+"");
	}*/
    
}
