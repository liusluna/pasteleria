package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class dbConexion {
	   private static Connection con=null;
	   
	   public static Connection getConnection(){
	      try{
	         if( con == null ){
	            String driver="com.mysql.jdbc.Driver"; //el driver varia segun la DB que usemos
	            String url="jdbc:mysql://localhost/pasteleria?autoReconnect=true&verifyServerCertificate=false&useSSL=true";
	            String pwd="pasteles123";
	            String usr="pastelero";
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
	   
	   public  static int getResultSetRowCount(ResultSet resultSet) {
			int size = 0;
			try {
				resultSet.last();
				size = resultSet.getRow();
				resultSet.beforeFirst();
			} catch (Exception ex) {
				return 0;
			}
			return size;
		}

}
