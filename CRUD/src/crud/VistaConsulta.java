
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
  
    DefaultTableModel drm  = new DefaultTableModel() ;
    DALCatalogo dal =new DALCatalogo();
    
    public void HazInterfaz() {
         DALCatalogo dal=new DALCatalogo();
         ModeloCatalogo modelo = new  ModeloCatalogo();
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
        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventana.add(scroll);
        ventana.setVisible(true);
        tabla.setModel(drm);
        
       
       
       
    }
     
     /* public static void main(String[] args) {
         VistaConsulta a =new VistaConsulta();
         a.HazInterfaz();
      }
*/
//     public void Muestrate() {
//         
//         setVisible(true);
//     
//     }
           

}
