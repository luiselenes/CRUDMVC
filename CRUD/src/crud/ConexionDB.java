
package crud;
import com.sun.istack.internal.logging.Logger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class ConexionDB {
    public ConexionDB(){}
    
    public Connection conexion() {
		
    String 
            database="Crud",
            user="tec",
            password="123",
            server="localhost:1433";
              Connection con ;
		try {
		
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                       
                con = DriverManager.getConnection("jdbc:sqlserver://"+server+";databaseName="+database,user,password); 
                    
		}	catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e, "Error con la clase del driver de SqlServer: " + e.getMessage(),
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
		return con;
	}
        //------------------------------------------------------------------------------------------------------
	/*public static void main(String[] args){
		ConexionDB cn = new ConexionDB();
                //Getconetiion();
                //S ystem.out.println("ya entre ");
           //  cn.insertar("ee23","alfredo",50,1);
           // cn.select();
         /*System.out.println("aaaaaaa");
           for(int i=0;i<=3;i++){
               System.out.println(cn.select().size());
    
                   System.out.println("aaaaaaa");
           }
            //cn.select().get(0);
           */
         // cn.borrar("abc");
         
        // System.out.println(cn.select().elementAt(9));
	
        //------------------------------------------------------------------------------------------------------
        public  void insertar(String rfc,String nombre,int edad,int idciudad ){
           // String query ="insert into  'Clientes' ('RFC','Nombre','edad','IdCiudad')values"+ 
                       //   "('" +rfc +"','"+nombre+"','"+edad+"','"+idciudad+"')";
            Connection con = conexion();
        try {
          PreparedStatement ps = con.prepareCall("exec sp_registrarcliente ?,?,?,?");
                        ps.setString(1, rfc);
                        ps.setString(2, nombre);
                        ps.setInt(3,edad);
                        ps.setInt(4,idciudad);
                        ps.execute();
                        System.out.println("listo");
                        
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }    
        }
        //------------------------------------------------------------------------------------------------------
        public void modificar(String rfc,String nombre,int edad,int idciudad ){
        try {
            Connection con = conexion();
            PreparedStatement ps = con.prepareCall("exec sp_modificarcliente ?,?,?,?");
            ps.setString(1,rfc);
            ps.setString(2,nombre);
            ps.setInt(3,edad);
            ps.setInt(4,idciudad);
            ps.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            public void borrar(String rfc){
        try {
            Connection con = conexion();
            PreparedStatement ps = con.prepareCall("exec sp_eliminarcliente ?");
             ps.setString(1, rfc);
             ps.execute();
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
       //------------------------------------------------------------------------------------------------------//------------------------------------------------------------------------------------------------------
       
          public Vector select(){
          Vector dato=new Vector();
        try {
            Connection con = conexion();
            PreparedStatement ps = con.prepareCall("exec sp_selectclientes");
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
            dato.add(rs.getString(1));
            dato.add(rs.getString(2));
            dato.add(rs.getInt(3));
            dato.add(rs.getInt(4));
               
            }
           
            //System.out.println(dato.elementAt(5));
           
            
             return dato;
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
       //------------------------------------------------------------------------------------------------------
          }
           
        
/*
    private static Connection connect() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      */      
        
        /*
        String SQL = "INSERT INTO tabla (Col2, Col3) VALUES ('1', 2)";
Statement stmt = con.createStatement();
int count = stmt.executeUpdate(SQL);
System.out.println("filas afectadas: " + count);
stmt.close();
        ------------
        try (Connection conn = connect()){
            Statement consulta=(Statement) 
                    conn.createStatement();
            if(id==0){
                id=getCategoryCount()+1;
            }
            
            consulta.executeUpdate("insert into category(category_id,name) values('"+id+"','"+name+"')");
            JOptionPane.showMessageDialog(null,"Registro actualizado exitosamente");


         } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"El usuario ya existe");
        } 
    }   
    //-----------
        */
  
        
}
