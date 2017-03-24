package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliproped;
import singleton.dbConexion;

public class ClipropedDao {
	static Connection currentCon = null; 
	static ResultSet rs = null; 
	 
	public ClipropedDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Cliproped> getAll() {
		List<Cliproped> lista = new ArrayList<Cliproped>(); 
		Statement stmt = null; 
		String searchQuery = "select CLIPROPED_ID, PRODUCTO_ID, PEDIDO_ID, CLIENTE_ID from CLIPROPED;";
		
		
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			stmt=currentCon.createStatement(); 
			rs = stmt.executeQuery(searchQuery); 
			//boolean more = rs.next();
			if (rs==null) 
				return lista;
			while (rs.next()) {
				//System.out.println("- " +rs.getString(1)+ rs.getString(2));
				Cliproped cliproped = new Cliproped();
				cliproped.setCliproped_id(Integer.parseInt(rs.getString(1)));
				cliproped.setProducto_id(Integer.parseInt(rs.getString(2)));
				cliproped.setPedido_id(Integer.parseInt(rs.getString(3)));
				cliproped.setCliente_id(Integer.parseInt(rs.getString(4)));
				lista.add(cliproped);
			}
			
		 } catch (Exception ex) { 
			 System.out.println("Cliente dao: An Exception has occurred! " + ex); 
			 return (lista);
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println("Clientes proveedores pedidos dao: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Clientes proveedores pedidos dao: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}	
		
	    return lista;
	}

}