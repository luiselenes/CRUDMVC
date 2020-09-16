
package crud;

//import java.awt.GridLayout;
//import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//import sun.applet.Main;
//import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author lu
 */
public class VistaConsulta{
    ConexionDB con =new ConexionDB();
     private void HazInterfaz() {
        DefaultTableModel drm  = new DefaultTableModel() ;
        drm.addColumn("RFC");
        drm.addColumn("NOMBRE");
        drm.addColumn("EDAD");
        drm.addColumn("IDCIUDAD");
           drm.setRowCount(0);
           
         String q;
        JTable tabla =new JTable(drm);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40,40,400,400);
        JFrame ventana = new JFrame();
        ventana.setLayout(null);
        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(scroll);
        ventana.setVisible(true);
        tabla.setModel(drm);
        
//         for (int i = 0; i <con.select().size() ; i++) 
//         {
//                drm.addRow(con.select());
//                     
//        }
           
	
       
       
    }

//     public void Muestrate() {
//         
//         setVisible(true);
//     
//     }
           

}
