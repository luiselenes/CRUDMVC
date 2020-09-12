
package crud;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionDB {
    @SuppressWarnings("finally")
	public static Connection Getconetiion() {
		
    String 
            database="Crud",
            user="tec",
            password="123",
            server="localhost:1433";
            
            
            Connection con =null;
		try {
		
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                       
                con = DriverManager.getConnection("jdbc:sqlserver://"+server+";databaseName="+database,user,password);
	                  
                          
                    
		}	catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e, "Error con la clase del driver de MySql: " + e.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			con = null;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "Error en la conexion con la BD: " + e.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			con = null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error del sistema: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			con = null;
			
		}
		return null;
	}
	/*public static void main(String[] args) {
		Getconetiion();
                System.out.println("ya entre ");
	}*/
}
