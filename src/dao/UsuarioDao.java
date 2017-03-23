package dao;

//import java.text.*; 
//import java.util.*;

import model.Usuario;
import singleton.dbConexion;

import java.sql.*;

public class UsuarioDao {
	 static Connection currentCon = null; 
	 static ResultSet rs = null; 

	public UsuarioDao() {
		// TODO Auto-generated constructor stub
	}
	
	public  Boolean esValido(Usuario usuario){
		Statement stmt = null; 
		String searchQuery = "select * from USUARIOS where usuario='" + usuario.getUser()  + "' AND password='" + usuario.getPass() + "'";
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			stmt=currentCon.createStatement(); 
			rs = stmt.executeQuery(searchQuery); 
			boolean more = rs.next();
			if (!more) { 
				System.out.println("Sorry, you are not a registered user! Please sign up first"); 
				return(false); 
			} else if (more) {
				System.out.println("Welcome "+usuario.getUser());
				return true;
			}
		 } catch (Exception ex) { 
			 System.out.println("Log In failed: An Exception has occurred! " + ex); 
			 return (false);
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
		}
		return false;
	}

}
