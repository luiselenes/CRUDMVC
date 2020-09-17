
package crud;
//import com.sun.istack.internal.logging.Logger;
//import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Vector;
//import java.util.logging.Level;
import javax.swing.JOptionPane;

public class ConexionDB 
{   String database;
    String user;
    String password;
    String server;
     
    public ConexionDB()
    {         
        database="Crud";
        user="tec";
        password="123";
        server="localhost";
    }
    
    public Connection Getconexion() 
    {
        Connection con ;
	try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");           
            con = DriverManager.getConnection("jdbc:sqlserver://"+server+";databaseName="+database,user,password); 
                    
	}
        catch (ClassNotFoundException e) 
        {		
          //  JOptionPane.showMessageDialog(null, e, "Error con la clase del driver de SqlServer: " + e.getMessage(),
					//JOptionPane.ERROR_MESSAGE);
			con = null;
	} 
        catch (SQLException e)
        {
		//	JOptionPane.showMessageDialog(null, e, "Error en la conexion con la BD: " + e.getMessage(),
					//JOptionPane.ERROR_MESSAGE);
			con = null;
	}
        catch (Exception e)
        {
		//	JOptionPane.showMessageDialog(null, e, "Error del sistema: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			con = null;
			
	}
        return con;
    }
}