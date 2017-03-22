package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbConexion {
	   private static Connection con=null;
	   
	   public static Connection getConnection(){
	      try{
	         if( con == null ){
	            String driver="com.mysql.jdbc.Driver"; //el driver varia segun la DB que usemos
	            String url="jdbc:mysql://localhost/pasteleria?autoReconnect=true";
	            String pwd="pasteles123";
	            String usr="pasteles";
	            Class.forName(driver);
	            con = DriverManager.getConnection(url,usr,pwd);
	            System.out.println("Conection Exitosa");
	         }
	     }
	     catch(ClassNotFoundException | SQLException ex){
	        ex.printStackTrace();
	     }
	     return con;
	   }

}