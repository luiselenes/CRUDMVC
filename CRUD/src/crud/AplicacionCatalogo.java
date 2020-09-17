
package crud;

/**
 *
 * @author Tania Nafarrate B
 */
public class AplicacionCatalogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModeloCatalogo modelo = new ModeloCatalogo();
        VistaCatalogo vista = new VistaCatalogo();
        VistaConsulta VistaConsulta = new VistaConsulta();
        ControladorCatalogo controlador = new ControladorCatalogo(modelo, vista);
        vista.setControlador(controlador);
        vista.Muestrate();
        
       
    }
    
}
