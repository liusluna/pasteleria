package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Productos;
import singleton.dbConexion;

public class ProductoDao {
	static Connection currentCon = null; 
	static ResultSet rs = null;
	
	public ProductoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Productos> getAll() {
		List<Productos> lista = new ArrayList<Productos>(); 
		Statement stmt = null; 
		String searchQuery = "select PRODUCTO_ID,NOMBRE,COSTO,VENTA,DESCRIPCION from PRODUCTOS;";
			
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			stmt=currentCon.createStatement(); 
			rs = stmt.executeQuery(searchQuery); 
			//boolean more = rs.next();
			if (rs==null) 
				return lista;
			while (rs.next()) {
				//System.out.println("- " +rs.getString(1)+ rs.getString(2));
				Productos producto = new Productos();
				producto.setProductosId(Integer.parseInt(rs.getString(1)));
				producto.setNombre(rs.getString(2));
				producto.setCosto(Double.parseDouble(rs.getString(3)));
				producto.setVenta(Double.parseDouble(rs.getString(4)));
				producto.setDescripcion(rs.getString(5));
				lista.add(producto);
			}
		}catch(SQLException ex){
			System.err.println(" Productos dao SQLError: " + ex.getSQLState() + "\n"+ex.getStackTrace());	
		 } catch (Exception ex) { 
			 System.out.println("Productos dao: An Exception has occurred! " + ex); 
			 return (lista);
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				    
				} catch (Exception e) {
					System.out.println("Productos dao: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Productos dao: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}	
		
	    return lista;
	}

	public Boolean borra(int id) {
		
		return true;
	}
	
	public Boolean agrega(Productos producto) {
		
		return true;
	}
}
